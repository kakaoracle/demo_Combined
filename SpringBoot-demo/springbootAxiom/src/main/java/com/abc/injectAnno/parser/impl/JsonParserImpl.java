package com.abc.injectAnno.parser.impl;

import com.abc.injectAnno.model.BeanDefinition;
import com.abc.injectAnno.parser.Parser;
import com.abc.injectAnno.util.JsonReaderUtil;

import java.util.List;

/**
 * @description: json
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:58
 **/
public class JsonParserImpl implements Parser {
    @Override
    public List<BeanDefinition> parse(String fileName) {
        return JsonReaderUtil.readJson(fileName);
    }
}
