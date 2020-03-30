# Getting Started
1. 不要用自动生成代码
2. 如果遇到entity与数据库字段不一致(默认都是驼峰识别),就如下:
```
    @TableField(value = "create_time")
    private Date createTime1;
```
3. 用了mybatis-plus依赖就不要再用mybatis依赖了
4. 一张表一个entity,但是不用再一张表一个service了,由于经常联表查询,因此
不如统一一个service,然后service不再调用单表的service,而直接调用单表的
mapper.