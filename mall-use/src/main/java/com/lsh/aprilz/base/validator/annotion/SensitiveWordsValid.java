package com.lsh.aprilz.base.validator.annotion;



import com.lsh.aprilz.base.validator.constraint.SensitiveWordsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

/**
 * @description: 敏感词过滤校验
 * @author: liushaohui
 * @since: 2022/4/13
 **/
@Target({ FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SensitiveWordsValidator.class})
public @interface SensitiveWordsValid {


    // 默认通用词库
    String type() default "1";

    // 字段中文名
    String name() default "";



    String message() default "含有敏感字，请修改！";

    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
