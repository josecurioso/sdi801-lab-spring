package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Mark;
import com.uniovi.services.MarksService;

@Component
public class EditMarkFormValidator implements Validator {
	@Autowired
	private MarksService marksService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Mark.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Mark mark = (Mark) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		if (mark.getScore().isNaN()) {
			errors.rejectValue("score", "Error.mark.score.numeric");
		}
	}
}
