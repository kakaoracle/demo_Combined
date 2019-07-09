package com.abc.injectWithoutAnno.parser.factory;

import com.abc.injectWithoutAnno.constant.ParseType;
import com.abc.injectWithoutAnno.parser.Parser;
import com.abc.injectWithoutAnno.parser.impl.JsonParserImpl;
import com.abc.injectWithoutAnno.parser.impl.XmlParserImpl;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;


/**
 * @description: 解析器工厂
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:52
 **/
public class ParserFactory {

    public static Parser getParser(ParseType parseType){
        Preconditions.checkArgument(StringUtils.isNotEmpty(parseType.name()),
                "parseType must be not null");
        Parser parser = null;
        switch (parseType){
            case XML_PARSER:
                return new XmlParserImpl();
            case JSON_PARSER:
                return new JsonParserImpl();
            default:
                return parser;
        }
    }

}
