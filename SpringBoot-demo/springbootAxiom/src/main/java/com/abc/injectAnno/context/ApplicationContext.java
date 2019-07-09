package com.abc.injectAnno.context;

import com.abc.injectAnno.annotation.CDZAutowired;
import com.abc.injectAnno.constant.ParseType;
import com.abc.injectAnno.model.BeanDefinition;
import com.abc.injectAnno.parser.Parser;
import com.abc.injectAnno.parser.factory.ParserFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @description: spring容器
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:04
 **/
public class ApplicationContext {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationContext.class);

    private List<BeanDefinition> beanDefinitions = Lists.newArrayList();
    //根据bean标签中的id与路径名,实例化一个类,用hashMap装起来
    private Map<String, Object> instanceBeans = Maps.newHashMap();


    public ApplicationContext(){

    }

    public ApplicationContext(String configLocation, ParseType parseType){
        //加载配置文件并转换为BeanDefinition
        this.loadConfigFile(configLocation,parseType);
        //实例化BeanDefinition
        this.instanceBeanDefinitions();
        //基于注解的依赖注入
        this.annotationInject();

    }

    private void annotationInject() {
        for (String beanName : instanceBeans.keySet()) {
            Object bean = instanceBeans.get(beanName);
            if (bean != null) {
                try {
                    BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

                    for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                        // 获取Setter方法
                        Method setter = propertyDescriptor.getWriteMethod();

                        if (setter != null && setter.isAnnotationPresent(CDZAutowired.class)) {
                            CDZAutowired jackieAutowired = setter.getAnnotation(CDZAutowired.class);
                            Object value = null;

                            if (jackieAutowired != null && StringUtils.isNotEmpty(jackieAutowired.name())) {
                                value = instanceBeans.get(jackieAutowired.name());
                            } else {
                                value = instanceBeans.get(propertyDescriptor.getName());
                                if (value == null) {
                                    for (String key : instanceBeans.keySet()) {
                                        if (propertyDescriptor.getPropertyType().isAssignableFrom(instanceBeans.get(key).getClass())) {
                                            value=instanceBeans.get(key);//类型匹配的话就把此相同类型的
                                            break;//找到了类型相同的bean，退出循环
                                        }
                                    }
                                }
                            }

                            setter.setAccessible(true);
                            try {
                                setter.invoke(bean, value);
                            } catch (Exception e) {
                                LOG.error("invoke setter invoke failed", e);
                            }
                        }
                    }
                    //
                    Field[] fields = bean.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(CDZAutowired.class)) {
                            CDZAutowired jackieAutowired = field.getAnnotation(CDZAutowired.class);
                            Object value = null;

                            if (jackieAutowired != null && StringUtils.isNotEmpty(jackieAutowired.name())) {
                                value = instanceBeans.get(jackieAutowired.name());
                            } else {
                                value = instanceBeans.get(field.getName());
                                if (value == null) {
                                    for (String key : instanceBeans.keySet()) {
                                        if (field.getType().isAssignableFrom(instanceBeans.get(key).getClass())) {
                                            value = instanceBeans.get(key);
                                            break;
                                        }
                                    }
                                }
                            }

                            field.setAccessible(true);
                            try {
                                field.set(bean, value);
                            } catch (Exception e) {
                                LOG.error("invoke field.set failed", e);
                            }
                        }
                    }
                } catch (Exception e) {
                    LOG.error("invoke getBean failed", e);
                }
            }
        }
    }



    private void instanceBeanDefinitions(){
        if (CollectionUtils.isNotEmpty(beanDefinitions)){
            for (BeanDefinition beanDefinition:beanDefinitions){
                if (StringUtils.isNotEmpty(beanDefinition.getClassName())){
                    try {
                        instanceBeans.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
                        LOG.info("instance beans successfully,instanceBeans: {}"+instanceBeans);
                    } catch (InstantiationException e) {
                        LOG.error("instantiation failed", e);
                    } catch (IllegalAccessException e) {
                        LOG.error("illegalAccessException", e);
                    } catch (ClassNotFoundException e) {
                        LOG.error("classNotFoundException", e);
                    }
                }
            }
        }
    }

    private void loadConfigFile(String configLocation, ParseType parseType){
        Preconditions.checkArgument(StringUtils.isNotEmpty(configLocation),
                "configLocation must be not null");
        Parser parser = ParserFactory.getParser(parseType);
        LOG.info("++++++parsered beanDefinitions: "+parser.parse(configLocation));
        this.beanDefinitions = parser.parse(configLocation);
    }


    public Object getBean(String beanName) {
        return instanceBeans.get(beanName);
    }
}
