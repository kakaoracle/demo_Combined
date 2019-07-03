package com.abc.类的加载和实例化.constant;

/**
 * @description: parse类型
 * @author: DeZhao Chen
 * @create: 2019-07-03 16:13
 **/
public enum ParseType {

    NOT_SUPPORT_PARSER(0),XML_PARSER(1), JSON_PARSER(2);

    private int value;
    private ParseType(int value) {
        this.value = value;
    }

    public ParseType getParseType(int value) {
        ParseType result = null;
        switch (value) {
            case 1:
                result = ParseType.XML_PARSER;
                break;
            case 2:
                result = ParseType.JSON_PARSER;
                break;
            default:
                result = ParseType.NOT_SUPPORT_PARSER;
                break;
        }

        return result;
    }
}
