package com.abc.injectWithoutAnno.parser.impl;

import com.abc.injectWithoutAnno.model.BeanDefinition;
import com.abc.injectWithoutAnno.parser.Parser;
import com.abc.injectWithoutAnno.util.XmlReaderUtil;

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
