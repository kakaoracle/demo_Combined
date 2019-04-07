### Swagger-SpringBoot
1. pom中的依赖,最新版本为2.8.0
    <!-- Swagger的ui界面,不需要手动写html -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.8.0</version>
        </dependency>
2. 在主程序启动的类StartMain中添加注释:
    @EnableSwagger2
3. 各种注释的最简明列表:
    类:@Api(tags = "类的说明")
    方法:@ApiOperation("方法的说明")
    参数:@ApiParam(value = "参数的说明",required = true)
    pojo:@ApiModel("pojo的说明")
    pojo中的字段:@ApiModelProperty(value = "字段的说明",required = false)