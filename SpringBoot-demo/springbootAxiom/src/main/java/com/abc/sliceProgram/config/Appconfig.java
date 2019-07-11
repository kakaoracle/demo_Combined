package com.abc.sliceProgram.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @description:
 * @author: kakaoracle
 * @create: 2019-04-07 08:52
 **/
@Configuration
@ComponentScan("com.abc.sliceProgram")
@EnableAspectJAutoProxy
public class Appconfig {

}
