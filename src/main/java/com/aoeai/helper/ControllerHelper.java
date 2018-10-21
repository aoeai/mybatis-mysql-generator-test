package com.aoeai.helper;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器助手
 */
public class ControllerHelper {

    /**
     * 表单验证
     *
     * @param bindingResult
     * @return 错误信息
     */
    public static final StringBuilder getErrorMessage(BindingResult bindingResult) {
        StringBuilder errors = null;

        if (bindingResult.hasErrors()) {
            errors = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append("!");
            }
        }

        return errors;
    }

    /**
     * 根据实体对象返回查询参数
     *
     * @param entity
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static final Map<String, Object> getParams(Object entity) {
        Map<String, Object> params = new HashMap<>();
        params.put("entity", entity);
        return params;
    }

    /**
     * 根据实体对象返回查询参数
     *
     * @param entity
     * @param pageSize 每页显示的记录数
     * @param pageNum  当前页
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static final Map<String, Object> getParams(Object entity, int pageSize, int pageNum) {
        Map<String, Object> params = getParams(entity);
        params.put("pageSize", pageSize);
        params.put("pageNum", pageNum);
        return params;
    }

}
