package com.abc.loadAndInstanceBean.context;

import com.abc.loadAndInstanceBean.constant.ParseType;
import com.abc.loadAndInstanceBean.model.BeanDefinition;
import com.abc.loadAndInstanceBean.parser.Parser;
import com.abc.loadAndInstanceBean.parser.factory.ParserFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
