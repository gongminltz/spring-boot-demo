package org.example.custom.valid.config;

import lombok.extern.slf4j.Slf4j;
import org.example.custom.valid.annotation.UniqueTitle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * TODO
 *
 * @author gongmin
 * @date 2023/5/17 8:37
 */
@Slf4j
public class UniqueTitleValidator implements ConstraintValidator<UniqueTitle, String> {
    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        if (title == null) {
            return true;
        }
        log.info("<isValid> title = " + title);

        return true;
    }
}
