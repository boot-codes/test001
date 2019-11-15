package com.aosica.common.annotation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *  特殊字符校验
 */
@Constraint(validatedBy = {SpecialCharacterValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpecialCharacterCheck {

    String message() default "不可输入非法的字符 " ;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
