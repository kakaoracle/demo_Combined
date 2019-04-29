## 原理1:AOP
1. 不需要运行Application类,可以在测试类中开户注解扫描
2. 在配置类中写上@EnableAspectJAutoProxy后,就可以使用aop
3. aop的执行流程是:先找到通知(before或者after等),然后找连接点(pointcut),连接点中设置
    切面位置
4. 区分是jdk的代理还是cglib代理:
    第一种:
        在dao.query();一句前加断点,发现是jdkProxy
        IndexDao dao =  annotationConfigApplicationContext.getBean(IndexDao.class);
        dao.query();
    第二种:
        impl不再实现dao接口,同时getBean的名称在component中设置
        @Component("dao")
        public class IndexDaoImpl {
            //@Override......
        IndexDaoImpl dao = (IndexDaoImpl) annotationConfigApplicationContext.getBean("dao");
        dao.query();
        这样在dao.query();一句前加断点,发现是cglibProxy
    结论,如果有接口,且@EnableAspectJAutoProxy注解不设置proxyTargetClass =true的话,就默认使用jdkProxy
    否则没有接口的话就用cglib
5. 源代码执行流程:
    ...-->Object singletonObject = this.singletonObjects.get(beanName);--->
    singletonObjects就是Spring的IOC容器,而proxyTargetClass =true注解的选择时间就是下面的执行:
    
    先创建一个基本类final Object bean = instanceWrapper.getWrappedInstance();
    再initializeBean进行创建代理类具体是spring的后置处理器:
        beanProcessor.postProcessAfterInitialization
    而getBeanPostProcessors()是有spring的七个处理器
    下面有一个createProxy().getPaoxy(classLoader);
    其返回的是一个createAopProxy对象
    而AopProxy接口有三个实现方法,分别是
        jdkDynamicAopProxy
        ObjenesisCglibAopProxy
    至于采用哪一种就有一个判断:
        if (config.isOptimize() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
        			Class<?> targetClass = config.getTargetClass();
        			if (targetClass == null) {
        				throw new AopConfigException("TargetSource cannot determine target class: " +
        						"Either an interface or a target is required for proxy creation.");
        			}
        			if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
        				return new JdkDynamicAopProxy(config);
        			}
        			return new ObjenesisCglibAopProxy(config);
        		}
        		else {
        			return new JdkDynamicAopProxy(config);
        		}
    再下面有一个getProxyClassLoader()将代理对象动态加载到这里面
6. 看源码技巧:
    看spring一个实现时,可以打断点,然后对这个方法参数赋值比如beanName.equals("dao")
   
7. 不用启动    