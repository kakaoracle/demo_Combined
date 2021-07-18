## 手写ORM

---
#### 一、主要完成的功能【基本CURD是可以支持的】
> 1.通过自己实现的ORM,进行增删改查demo   
> 2.@Param注解解析，支持注解到对象和基本数据类型  
> 3.用dtd文件定义Mapper.xml文档的合法构建模块   
> 4.根据resultType，对结果进行处理    
> 5.除了xml配置方式外，新加注解方式@Select @Insert @Delete @Update


---

#### 二、Mybatis原理
###### 我们先复习一下Mybatis的实现原理：
1.SqlSessionFactory是线程安全的   
2.SqlSession是单线程对象，因为它是非线程安全的

![avatar](https://raw.githubusercontent.com/chenxingxing6/myorm/master/img/1.jpg)

流程描述：  
> 1.加载Mybatis全局配置文件并解析，生成Configuration对象和MapperdStatement  
2.SqlSessionFactoryBuilder通过Configuration对象构建SqlSessionFactory  
3.通过SqlSessionFactory获取sqlSession  
4.sqlSession和数据库进行交互

---

#### 三、MyORM实现
![avatar](https://raw.githubusercontent.com/chenxingxing6/myorm/master/img/2.jpg)

我的实现思路
> 1.解析配置文件，初始化数据库连接，创建sqlSession池，交给SqlSessionFactory管理   
2.创建Execute,底层调用JDBC操作数据库   
3.创建MapperProxy代理对象，动态代理Mapper接口   
4.大体架子搭建好后，可以继续完善，比如@Param注解.       
5.测试就直接使用单测测试就可以了

---

#### 四、MyORM项目结构
![avatar](https://raw.githubusercontent.com/chenxingxing6/myorm/master/img/3.jpg)


##### 4.1 增删改查Demo

![avatar](https://raw.githubusercontent.com/chenxingxing6/myorm/master/img/4.jpg)

---

![avatar](https://raw.githubusercontent.com/chenxingxing6/myorm/master/img/5.jpg)

