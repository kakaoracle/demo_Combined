package com.abc.类的加载和实例化.parser.impl;

import com.abc.类的加载和实例化.model.BeanDefinition;
import com.abc.类的加载和实例化.parser.Parser;
import com.abc.类的加载和实例化.util.JsonReaderUtil;

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
