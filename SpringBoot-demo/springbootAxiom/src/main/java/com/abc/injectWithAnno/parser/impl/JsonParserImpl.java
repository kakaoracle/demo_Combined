package com.abc.injectWithAnno.parser.impl;

import com.abc.injectWithAnno.model.BeanDefinition;
import com.abc.injectWithAnno.parser.Parser;
import com.abc.injectWithAnno.util.JsonReaderUtil;

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
