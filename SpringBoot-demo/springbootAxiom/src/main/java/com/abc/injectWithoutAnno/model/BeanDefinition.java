package com.abc.injectWithoutAnno.model;

import java.util.List;

/**
 * @description: 用来存储描述bean的所有属性信息,比如id,propertyDefinition
 * @author: DeZhao Chen
 * @create: 2019-07-03 11:50
 **/
public class BeanDefinition {
    private String id;
    private String className;
    private List<PropertyDefinition> propertyDefinitions;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public BeanDefinition(String id, String className, List<PropertyDefinition> propertyDefinitions) {
        this.id = id;
        this.className = className;
        this.propertyDefinitions = propertyDefinitions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<PropertyDefinition> getPropertyDefinitions() {
        return propertyDefinitions;
    }

    public void setPropertyDefinitions(List<PropertyDefinition> propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", propertyDefinitions=" + propertyDefinitions +
                '}';
    }
}
