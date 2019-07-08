package com.abc.依赖注入_非注解.parser.impl;

import com.abc.依赖注入_非注解.model.BeanDefinition;
import com.abc.依赖注入_非注解.parser.Parser;
import com.abc.依赖注入_非注解.util.XmlReaderUtil;

import java.util.List;

/**
 * @description: xml
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:59
 **/
public class XmlParserImpl implements Parser {
    @Override
    public List<BeanDefinition> parse(String fileName) {
        return XmlReaderUtil.readXml(fileName);
    }
}
