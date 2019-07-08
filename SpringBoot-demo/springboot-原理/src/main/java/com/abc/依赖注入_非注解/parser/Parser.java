package com.abc.依赖注入_非注解.parser;

import com.abc.依赖注入_非注解.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
