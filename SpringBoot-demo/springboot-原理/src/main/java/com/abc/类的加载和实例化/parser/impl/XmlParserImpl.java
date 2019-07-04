package com.abc.类的加载和实例化.parser.impl;

import com.abc.类的加载和实例化.util.XmlReaderUtil;
import com.abc.类的加载和实例化.model.BeanDefinition;
import com.abc.类的加载和实例化.parser.Parser;

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
