package com.pay.common.mybatis;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pay.common.domain.AbstractEntity;
import com.pay.common.domain.AbstractValueObject;
import com.pay.common.helper.StringHelper;

/**
 * Created by HanKeQi on 2017/1/17.
 * 提供基本的CRUD方法 - 除了删除!
 *
 */
@Deprecated //暂时先设置成阉割版
public abstract class CrudProvider<T extends AbstractEntity> {

    private static final Logger log = LoggerFactory.getLogger(CrudProvider.class);

    private static final String INSERT_TYPE = "insert";
    private static final String UPDATE_TYPE = "update";
    private static final String SELECT_TYPE = "select";
    private static final String INSERT_BATCH_TYPE = "insert_all"; // 批量插入

    private Class<T> entityClass;

    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * 根据类名生成的数据库表名
     */
    protected String tableName;

    public CrudProvider() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
        StringBuffer str = new StringBuffer("T_");
        str.append(StringHelper.camelToUnderline(entityClass.getSimpleName()));
        tableName = str.toString();
    }

    public String insert() {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName).append("(");
        AtomicBoolean isFirst = new AtomicBoolean(true);
        // 限制递归
        AtomicInteger recursionCount = new AtomicInteger(0);
        StringBuilder valuesSql = new StringBuilder();
        Field[] fields = entityClass.getDeclaredFields();
        sql.append(getBodySql(valuesSql, fields, isFirst, recursionCount, INSERT_TYPE));
        sql.append(") values (").append(valuesSql).append(")");
        return sql.toString();
    }

    public String insertBatch(Map<String, List<?>> map) {
        List<?> list = map.get("list");
        StringBuilder sql = new StringBuilder();
        sql.append("insert into ").append(tableName).append("(");
        AtomicBoolean isFirst = new AtomicBoolean(true);
        // 限制递归
        AtomicInteger recursionCount = new AtomicInteger(0);
        Field[] fields = entityClass.getDeclaredFields();
        StringBuilder valueSql = new StringBuilder();
        sql.append(getBodySql(valueSql, fields, isFirst, recursionCount, INSERT_BATCH_TYPE));
        sql.append(") values ");
        valueSql.append(")");
        MessageFormat messageFormat = new MessageFormat(valueSql.toString());
        for (int i = 0; i < list.size(); i++) {
            sql.append(messageFormat.format(new Integer[]{i}));
            sql.append(",");
        }
        sql.setLength(sql.length() - 1);
        return sql.toString();
    }

    public String update() {
        StringBuilder sql = new StringBuilder();
        sql.append("update ").append(tableName);
        AtomicBoolean isFirst = new AtomicBoolean(true);
        // 限制递归
        AtomicInteger recursionCount = new AtomicInteger(0);
        Field[] fields = entityClass.getDeclaredFields();
        sql.append(getBodySql(null, fields, isFirst, recursionCount, UPDATE_TYPE));
        sql.append(" where id = #{id}");
        return sql.toString();
    }

    public String getById() {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from ").append(tableName).append(" where id = #{id}");
//        AtomicBoolean isFirst = new AtomicBoolean(true);
//        // 限制递归
//        AtomicInteger recursionCount = new AtomicInteger(0);
//        Field[] fields = entityClass.getDeclaredFields();
//        sql.append(getBodySql(null, fields, isFirst, recursionCount, SELECT_TYPE));
//        sql.append(" from ").append(tableName).append(" where id = #{id}");
        return sql.toString();
    }

    public String getAll() {
        return "select * from " + this.tableName + " order by id desc";
    }

    public String countAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(*) as count from ");
        sql.append(tableName);
        return sql.toString();
    }

    private String getBodySql(StringBuilder valuesSql, Field[] fields, AtomicBoolean isFirst, AtomicInteger recursionCount, String sqlType) {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            if (isIgnoredField(field)) {
                // 此情况是List或者Set
                continue;
            }
            // 基本类型应当区分
            String fieldSuperClass = field.getType().getSuperclass() == null ? field.getType().getName() : field.getType().getSuperclass()
                    .getName();
            String keyStr = field.getName();
            String valStr = field.getName();
            if (!AbstractEntity.class.getName().equals(fieldSuperClass) && recursionCount.intValue() == 1) {
                // 递归到下一层的时候，valStr需要带上类名.
                Class<?> declaringClass = field.getDeclaringClass();
                String simpleName = declaringClass.getSimpleName();
                // 开头小写
                simpleName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
                valStr = simpleName + "." + valStr;
            } else if (AbstractEntity.class.getName().equals(fieldSuperClass) && recursionCount.intValue() == 1) {
                // 递归到下一层的时候，出现复杂对象，跳过
                continue;
            } else if (AbstractEntity.class.getName().equals(fieldSuperClass) && recursionCount.intValue() == 0) {
                // 只有第一层才要，递归到深层则忽略它
                valStr = keyStr + ".id";
                keyStr = keyStr + "Id";
            } else if (AbstractValueObject.class.getName().equals(fieldSuperClass)) {
                // 递归限制
                recursionCount.incrementAndGet();
                // 递归两级
                if (recursionCount.intValue() < 2) {
                    Field[] innerFields = field.getType().getDeclaredFields();
                    sb.append(getBodySql(valuesSql, innerFields, isFirst, recursionCount, sqlType));
                }
                recursionCount.decrementAndGet();
                continue;
            }
            switch (sqlType) {
                case INSERT_TYPE: {
                    if (isFirst.get()) {
                        isFirst.set(false);
                        sb.append(keyStr);
                        valuesSql.append("#{");
                        valuesSql.append(valStr);
                        valuesSql.append("}");
                    } else {
                        sb.append(",");
                        sb.append(keyStr);
                        valuesSql.append(",#{");
                        valuesSql.append(valStr);
                        valuesSql.append("}");
                    }
                    break;
                }
                case INSERT_BATCH_TYPE: {
                    if (isFirst.get()) {
                        isFirst.set(false);
                        sb.append(keyStr);
                        valuesSql.append("(#'{'list[{0}].");
                        valuesSql.append(valStr);
                        valuesSql.append("}");
                    } else {
                        sb.append(",");
                        sb.append(keyStr);
                        valuesSql.append(",#'{'list[{0}].");
                        valuesSql.append(valStr);
                        valuesSql.append("}");
                    }
                    break;
                }
                case UPDATE_TYPE: {
                    if (isFirst.get()) {
                        sb.append(" set ");
                        isFirst.set(false);
                    } else {
                        sb.append(",");
                    }
                    sb.append(keyStr).append("=").append("#{").append(valStr).append("}");
                    break;
                }
                case SELECT_TYPE: {
                    if (isFirst.get()) {
                        isFirst.set(false);
                        sb.append("id,");
                        sb.append(keyStr);
                    } else {
                        sb.append(",");
                        sb.append(keyStr);
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return sb.toString();
    }

    private boolean isIgnoredField(Field field) {
        //JDK1.8
    	//CRUDProviderIgnore ignoreAnnotation = field.getDeclaredAnnotation(CRUDProviderIgnore.class);
    	//支持JDK1.7
    	CRUDProviderIgnore ignoreAnnotation = field.getAnnotation(CRUDProviderIgnore.class);
        if (ignoreAnnotation != null) {
            return true;
        }
        if (field.getType().isPrimitive()) {
            // 此情况为该类是基本类型
            return false;
        }
        if (field.getType().getSuperclass() == null) {
            // 此情况为该类是接口类
            return true;
        }
        String fieldSuperClass = field.getType().getSuperclass().getName();
        boolean isCollections = AbstractSet.class.getName().equals(fieldSuperClass) || AbstractList.class.getName().equals(fieldSuperClass);
        if (isCollections) {
            // 此情况是集合类
            return true;
        }
        return false;
    }

}
