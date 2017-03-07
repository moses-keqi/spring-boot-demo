package com.pay.channel.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pay.channel.form.RecurringForm;
import com.pay.channel.form.validator.annotation.RecurringCell;

/**
 * 校验可包含form的字段或业务
 * @author HanKeQi
 *
 */
public class RecurringCellValidator implements ConstraintValidator<RecurringCell, RecurringForm>{

	@Override
	public void initialize(RecurringCell arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(RecurringForm arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
