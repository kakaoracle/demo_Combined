# 设计模式
## 适配器模式:AdapterModel
## 观察者模式： watchmodel
## 发布订阅模式:publishscriptionmodel
> Runtime类可以获取当前机器的核心数: Runtime.getRuntime().availableProcessors()
## 策略模式: strategymodel
> 中心就是遍历枚举类,val相同时执行对应的实例
> 场景就是,多种异常处理逻辑,需要一种一种进行处理,且每种之间独立没有依赖关系,属于平级关系
## 工厂模式: factorymodel
## 单例模式: singlemodel
> 注意点就一是懒汉式,二是构造方法私有化,使得无法实例化,只能走自定义的方法获取单例
> 场景就是操作数据库资源的类,不必要频繁销毁,因此做一个单例,同理日志也是
## 模板方法模式: templateModel
> 考勤模块中,由于系统封装的是quartz,只暴露一个execute()方法,所有类都要继承并重写,但是我还要提供给其他人使用,
> 并且记录时间,因此我在execute()方法中封装了一个execute1()方法,里面有记录开始时间,execute1(),
> 记录结束时间,然后其他人继承我的类,重写execute1()方法,最终平台调其他人,虽然表面上他们没有写execute方法,
> 但是实际上他们也都写了execute(),因为在父类也就是我这边提供了
