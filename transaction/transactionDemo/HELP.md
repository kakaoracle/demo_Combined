# 参考的博客
https://juejin.im/post/5ae9639af265da0b926564e7#heading-11

transactionDemo工程全部讲的都是同一个数据源,多个事务并发,不涉及分布式事务

## 什么是事务的传播行为
    方法在嵌套的时候,父方法的事务行为能否传播给内部方法(内部方法也有自己的事务)
## 先分析required, reqires_new, requires_nested三种:
required(融合事务): 外围异常回滚,内部异常回滚,外围捕捉内部异常回滚,如果外围也是required,那么与外围的融为一体
requires_new(新事务): 外围回滚内部不回滚,独立于外围事务
requires_nested(嵌套事务): 外围回滚则nested也回滚

|     | 子方法内部new异常  | 子方法异常被父方法trycatch    |
| --- |         ---       | ---                         |
| 父required,子requires_nested |  父方法事务回滚 | 父方法事务不回滚  |
| 父required,子requires_new | 父方法事务回滚| 父方法事务不回滚 |