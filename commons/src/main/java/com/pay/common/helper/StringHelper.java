package com.pay.common.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class StringHelper {

   // private static final Logger log = LoggerFactory.getLogger(StringHelper.class);

    private static final String UNDERLINE = "_";

    /**
     * 驼峰转下划线
     */
    public static String camelToUnderline(String param) {
        if (StringUtils.isBlank(param)) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        sb.append(Character.toLowerCase(param.charAt(0)));
        for (int i = 1; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString().toUpperCase();
    }

    public static String valueOf(Object val) {
        if (val == null) {
            return null;
        }
        if (val instanceof Date) {
            //return DateTimeHelper.dateToString((Date) val, DateTimeHelper.YYYY_MM_DD_HH_MM_SS);
        }
        return String.valueOf(val);
    }

}
