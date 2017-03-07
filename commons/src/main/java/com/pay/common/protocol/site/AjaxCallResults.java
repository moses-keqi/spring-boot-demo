package com.pay.common.protocol.site;

import com.fasterxml.jackson.core.type.TypeReference;

import com.pay.common.helper.JacksonHelper;
import com.pay.common.protocol.site.exception.AbstractSiteException;
import com.pay.common.protocol.site.exception.GenericSiteException;
import com.pay.common.protocol.site.exception.ValidationFailedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HanKeQi on 2017/1/17.
 * 所有内部远程API调用的返回值容器
 */
public class AjaxCallResults {

    private String code;

    private final static String SUCCESS = "SUCCESS";

    private final static String GLOBAL_ERRORS = "global_errors";

    private final static String FIELD_ERROR_MAP = "field_error_map";

    private final Map<String, Object> data = new HashMap<>();

    private AjaxCallResults() {
    }

    private AjaxCallResults(String code) {
        this.code = code;
    }

    private AjaxCallResults(String code, Map<String, Object> data) {
        this.code = code;
        this.data.putAll(data);
    }

    private AjaxCallResults(AbstractSiteException e) {
        this.code = e.getErrorCode();
    }

    private AjaxCallResults(AbstractSiteException code, Map<String, Object> data) {
        this.code = code.getErrorCode();
        this.data.putAll(data);
    }

    // ------------------------------------
    // factory methods
    // ------------------------------------

    public static AjaxCallResults newInstanceOfSuccess() {
        return new AjaxCallResults(SUCCESS);
    }

    public static AjaxCallResults newInstanceOfSuccess(Map<String, Object> data) {
        return new AjaxCallResults(SUCCESS, data);
    }

    public static AjaxCallResults newInstanceOfSuccess(String key, Object value) {
        AjaxCallResults ret = new AjaxCallResults(SUCCESS);
        ret.put(key, value);
        return ret;
    }

    public static AjaxCallResults newInstanceOfError() {
        return new AjaxCallResults(new GenericSiteException());
    }

    public static AjaxCallResults newInstanceOfError(Map<String, Object> data) {
        return new AjaxCallResults(new GenericSiteException(), data);
    }

    public static AjaxCallResults newInstanceOfError(String key, Object value) {
        AjaxCallResults ret = new AjaxCallResults(new GenericSiteException());
        ret.put(key, value);
        return ret;
    }

    public static AjaxCallResults newInstanceOfError(AbstractSiteException exception) {
        return new AjaxCallResults(exception);
    }

    public static AjaxCallResults newInstanceOfError(AbstractSiteException exception, Map<String, Object> data) {
        return new AjaxCallResults(exception, data);
    }

    public static AjaxCallResults newInstanceOfError(AbstractSiteException exception, String key, Object value) {
        AjaxCallResults ret = new AjaxCallResults(exception);
        ret.put(key, value);
        return ret;
    }


    public static AjaxCallResults newInstanceOfError(BindingResult bindingResult) {
        AjaxCallResults ret = new AjaxCallResults(new ValidationFailedException());
        ret.put(bindingResult);
        return ret;
    }


    // ------------------------------------
    // instance methods
    // ------------------------------------

    public <T> T get(String key, Class<T> clazz) {
        String jsonStr = JacksonHelper.parseToJson(data.get(key));
        T obj = JacksonHelper.parseToObject(jsonStr, clazz);
        return obj;
    }

    public <T> T get(String key, TypeReference<T> type) {
        String jsonStr = JacksonHelper.parseToJson(data.get(key));
        T obj = JacksonHelper.parseToObject(jsonStr, type);
        return obj;
    }

    public void put(String key, Object value) {
        this.data.put(key, value);
    }

    public void putAll(Map<String, Object> data) {
        this.data.putAll(data);
    }

    public void put(BindingResult bindingResult) {
        List<String> globalErrorList = new ArrayList<>();
        Map<String, String> fieldErrorMap = new HashMap<>();
        for (ObjectError oe : bindingResult.getAllErrors()) {
            if (oe instanceof FieldError) {
                FieldError fe = (FieldError) oe;
                fieldErrorMap.put(fe.getField(), oe.getDefaultMessage());
            } else {
                globalErrorList.add(oe.getDefaultMessage());
            }
        }
        this.put(GLOBAL_ERRORS, globalErrorList);
        this.put(FIELD_ERROR_MAP, fieldErrorMap);
    }

    public boolean isSuccess() {
        return SUCCESS.equals(this.code);
    }

    @Override
    public String toString() {
        return JacksonHelper.parseToJson(this);
    }


    // ------------------------------------
    // only getters are needed
    // ------------------------------------

    public String getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

}
