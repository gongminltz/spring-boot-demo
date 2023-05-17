package org.example.custom.valid.annotation;

import org.example.custom.valid.config.UniqueTitleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueTitleValidator.class)
@Documented
public @interface UniqueTitle {
    String message() default "Title must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}