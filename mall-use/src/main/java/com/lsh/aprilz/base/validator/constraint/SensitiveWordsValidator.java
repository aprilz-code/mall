package com.lsh.aprilz.base.validator.constraint;



import cn.hutool.core.util.StrUtil;
import com.lsh.aprilz.base.util.SensitiveWordsUtils;
import com.lsh.aprilz.base.validator.annotion.SensitiveWordsValid;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 敏感词过滤校验实现
 * @author: liushaohui
 * @since: 2022/4/13
 **/
public class SensitiveWordsValidator implements ConstraintValidator<SensitiveWordsValid, String> {
    private String type;

    private String name;

    @Override
    public void initialize(SensitiveWordsValid constraintAnnotation) {
        type = constraintAnnotation.type();
        name = constraintAnnotation.name();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( StringUtils.isBlank(value)) {
            return true;
        }
        String filter = SensitiveWordsUtils.getSensitiveWords(value,type);
        if(StringUtils.isNotBlank(filter)){
            //禁用默认的message的值
            context.disableDefaultConstraintViolation();
            //重新添加错误提示语句
            context.buildConstraintViolationWithTemplate("["+ name +"]含有敏感字 ["+ filter +"]，请修改！").addConstraintViolation();
            return  false;
        }
        return  true;
        //return SensitiveWordsUtils.notExistSensitiveWords(value,type);
    }
}
