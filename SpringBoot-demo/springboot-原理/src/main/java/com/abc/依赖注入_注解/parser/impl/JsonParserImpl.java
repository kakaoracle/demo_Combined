package com.abc.依赖注入_注解.parser.impl;

import com.abc.依赖注入_注解.model.BeanDefinition;
import com.abc.依赖注入_注解.parser.Parser;
import com.abc.依赖注入_注解.util.JsonReaderUtil;

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
