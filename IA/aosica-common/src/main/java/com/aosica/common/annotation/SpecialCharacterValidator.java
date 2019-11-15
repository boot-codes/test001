package com.aosica.common.annotation;


import com.aosica.common.util.ValidatorServer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SpecialCharacterValidator implements ConstraintValidator<SpecialCharacterCheck, String> {

    @Override
    public void initialize(SpecialCharacterCheck specialCharacter) {
        //this.values = specialCharacter.value() ;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // 如果包含，则返回false .
        if(ValidatorServer.isContainSpecialCharacter(value)) {
            return false;
        }
        return  true ;
    }
}
