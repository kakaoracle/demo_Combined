package com.abc.依赖注入_注解.parser;

import com.abc.依赖注入_注解.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
