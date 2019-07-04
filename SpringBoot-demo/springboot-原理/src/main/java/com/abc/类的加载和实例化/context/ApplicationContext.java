package com.abc.类的加载和实例化.context;

import com.abc.类的加载和实例化.constant.ParseType;
import com.abc.类的加载和实例化.dao.DemoDao;
import com.abc.类的加载和实例化.model.BeanDefinition;
import com.abc.类的加载和实例化.model.PropertyDefinition;
import com.abc.类的加载和实例化.parser.Parser;
import com.abc.类的加载和实例化.parser.factory.ParserFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @description: spring容器
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:04
 **/
public class ApplicationContext {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationContext.class);

    private List<BeanDefinition> beanDefinitions = Lists.newArrayList();
    //根据bean标签中的id与路径名,实例化一个类,用hashMap装起来
    private HashMap<Object, Object> instanceBeans = Maps.newHashMap();


    public ApplicationContext(){

    }

    public ApplicationContext(String configLocation, ParseType parseType){
        //加载配置文件并转换为BeanDefinition
        this.loadConfigFile(configLocation,parseType);
        //实例化BeanDefinition
        this.instanceBeanDefinitions();
        //基于注解的依赖注入

        //实现依赖注入
        this.injectObject();
    }

    private void injectObject() {
        for (BeanDefinition beanDefinition : beanDefinitions){
            Object bean = instanceBeans.get(beanDefinition.getId());
            if (bean != null){
                try {
                    BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
                    //通过beanInfo来获取属性的描述器,再获取某个属性的getset方法再反射
                    PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

                    for (PropertyDefinition propertyDefinition : beanDefinition.getPropertyDefinitions()){
                        for (PropertyDescriptor propertyDescriptor : propertyDescriptors){
                            //用记定义的bean属性和java内省后的bean属性名称相同时
                            if (StringUtils.equals(propertyDescriptor.getName(),propertyDefinition.getName())){
                                //获取setter方法
                                Method setter = propertyDescriptor.getWriteMethod();
                                if (setter != null){
                                    Object value = null;
                                    if (StringUtils.isNotEmpty(propertyDefinition.getRef())){
                                        //根据bean的名称在instanceBeans中获取指定的对象值
                                        value = instanceBeans.get(propertyDefinition.getRef());
                                    }else {
                                        value = ConvertUtils.convert(propertyDefinition.getValue(),propertyDescriptor.getPropertyType());
                                    }
                                    //保证setter方法可以访问私有
                                    setter.setAccessible(true);
                                    try {
                                        setter.invoke(bean,value);
                                    } catch (Exception e) {
                                        LOG.error("invoke setter.invoke failed",e);
                                    }

                                }
                                break;
                            }
                        }
                    }


                } catch (IntrospectionException e) {
                    LOG.error("invoke getBean failed",e);
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

    private void loadConfigFile(String configLocation,ParseType parseType){
        Preconditions.checkArgument(StringUtils.isNotEmpty(configLocation),
                "configLocation must be not null");
        Parser parser = ParserFactory.getParser(parseType);
        LOG.info("+++++parsered beanDefinitions: "+parser.parse(configLocation));
        this.beanDefinitions = parser.parse(configLocation);
    }


    public Object getBean(String beanName) {
        return instanceBeans.get(beanName);
    }
}
