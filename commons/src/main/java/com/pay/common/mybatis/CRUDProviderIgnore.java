package com.pay.common.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by HanKeQi on 2017/1/17.
 * 业务字段不需要保存到数据库字段
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Deprecated //暂设置成阉割版
public @interface CRUDProviderIgnore {
}
