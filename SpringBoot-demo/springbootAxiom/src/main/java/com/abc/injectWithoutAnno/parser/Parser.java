package com.abc.injectWithoutAnno.parser;

import com.abc.injectWithoutAnno.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
