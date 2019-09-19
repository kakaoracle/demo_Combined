# 提供各种工具类的原始与封装使用示范
## 大部分工具类都用HuTool
- 依赖:
    <dependency>
          <groupId>cn.hutool</groupId>
          <artifactId>hutool-all</artifactId>
          <version>4.4.4</version>
    </dependency>
- 官网:https://hutool.cn/
- 模块:
    泛型克隆
    日期与时间
    IO流
    惟一ID
    字符串切割
    加密解密
    http客户端
    邮件工具
    二维码工具
    Emoji表情
    Office文档操作
    图形验证码

## 其他的模块:
masterDataSourceConfig:用来设置同一个工程中的多个数据库源
参考网址:https://www.jianshu.com/p/735852145580
## 工具类详解
1. ListUtil:对象的相同属性复制值通常用beanUtil,但是如果是两个list,就没有现成
的方法进行复制
使用示例见测试
