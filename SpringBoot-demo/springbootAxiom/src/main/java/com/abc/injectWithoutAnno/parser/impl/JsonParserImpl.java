package com.abc.injectWithoutAnno.parser.impl;

import com.abc.injectWithoutAnno.model.BeanDefinition;
import com.abc.injectWithoutAnno.parser.Parser;
import com.abc.injectWithoutAnno.util.JsonReaderUtil;

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
