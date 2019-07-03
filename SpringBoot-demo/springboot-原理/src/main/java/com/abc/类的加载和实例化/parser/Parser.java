package com.abc.类的加载和实例化.parser;

import com.abc.类的加载和实例化.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
