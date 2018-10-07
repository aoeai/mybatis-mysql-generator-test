package com.aoeai.helper;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 控制器助手
 */
public class ControllerHelper {

    /**
     * 表单验证
     * @param bindingResult
     * @return 错误信息
     */
    public static final StringBuilder getErrorMessage(BindingResult bindingResult){
        StringBuilder errors = null;

        if(bindingResult.hasErrors()){
            errors = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append("!");
            }
        }

        return errors;
    }

}
