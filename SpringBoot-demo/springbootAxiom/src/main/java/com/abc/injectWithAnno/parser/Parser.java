package com.abc.injectWithAnno.parser;

import com.abc.injectWithAnno.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
