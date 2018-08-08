package com.iss;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class log4j_SLF4j_test {
    private static final Logger logger = LoggerFactory.getLogger(log4j_SLF4j_test.class);
    @Test
    public void fun01(){
        logger.info("Test Info");
        logger.warn("test Warning");
        logger.error("test error");
        logger.error("Current : {}",log4j_SLF4j_test.class);
    }
}
