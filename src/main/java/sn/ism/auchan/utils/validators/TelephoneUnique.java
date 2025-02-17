package sn.ism.auchan.utils.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import sn.ism.auchan.utils.validators.impl.ListNotEmptyValidator;
import sn.ism.auchan.utils.validators.impl.TelephoneUniqueValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TelephoneUniqueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelephoneUnique {
    String message() default "Le téléphone doit être unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
