package com.jamersc.springboot.todoexpense.validation;

import com.jamersc.springboot.todoexpense.dto.ManageUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, ManageUser> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ManageUser manageUser, ConstraintValidatorContext context) {
        // Check if the password match
        if (manageUser.getPassword() == null || manageUser.getConfirmPassword() == null) {
            return false;
        }
        boolean isValid = manageUser.getPassword().equals(manageUser.getConfirmPassword());
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmPassword").addConstraintViolation();
        }
        return isValid;
    }
}
