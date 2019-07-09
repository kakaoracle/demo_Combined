package com.abc.loadAndInstanceBean.parser.impl;

import com.abc.loadAndInstanceBean.util.XmlReaderUtil;
import com.abc.loadAndInstanceBean.model.BeanDefinition;
import com.abc.loadAndInstanceBean.parser.Parser;

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
