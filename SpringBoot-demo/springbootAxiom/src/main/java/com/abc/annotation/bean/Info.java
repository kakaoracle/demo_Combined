package com.abc.annotation.bean;

import com.abc.annotation.NotNull;

public class Info {
    /** 类名 */
    @NotNull
    private String className;

    /** 方法名 */
    private String methodName;

    /** 参数名 */
    private String paramName;

    /** 属性名 */
    private String fieldName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
