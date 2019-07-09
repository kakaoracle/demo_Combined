package com.abc.injectAnno.parser;

import com.abc.injectAnno.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
