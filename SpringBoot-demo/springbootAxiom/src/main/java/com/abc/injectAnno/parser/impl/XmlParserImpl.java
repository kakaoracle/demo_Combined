package com.abc.injectAnno.parser.impl;

import com.abc.injectAnno.model.BeanDefinition;
import com.abc.injectAnno.parser.Parser;
import com.abc.injectAnno.util.XmlReaderUtil;

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
