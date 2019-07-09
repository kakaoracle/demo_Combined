package com.abc.loadAndInstanceBean.parser;

import com.abc.loadAndInstanceBean.model.BeanDefinition;

import java.util.List;

public interface Parser {
    List<BeanDefinition> parse(String fileName);
}
