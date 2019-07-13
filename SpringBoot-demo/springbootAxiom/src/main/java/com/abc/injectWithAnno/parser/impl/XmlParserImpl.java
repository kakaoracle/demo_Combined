package com.abc.injectWithAnno.parser.impl;

import com.abc.injectWithAnno.model.BeanDefinition;
import com.abc.injectWithAnno.parser.Parser;
import com.abc.injectWithAnno.util.XmlReaderUtil;

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
