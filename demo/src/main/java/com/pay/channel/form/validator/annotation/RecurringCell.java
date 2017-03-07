package com.pay.channel.form.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.pay.channel.form.validator.RecurringCellValidator;

/**
 * 校验form以外的字段{也可以包含form(建议比较复杂的字段 比如：组合等)}或业务,此注解用于 xxxForm上
 * @author HanKeQi
 *
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RecurringCellValidator.class)
@Documented
public @interface RecurringCell {

	//测试
	// default error message
    String message() default "test！";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
