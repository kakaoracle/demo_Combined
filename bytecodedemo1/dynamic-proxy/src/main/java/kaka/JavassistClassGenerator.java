package kaka;

import javassist.*;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class JavassistClassGenerator implements ClassGenerator{

    private void addField(ClassPool pool , CtClass ctClass , String name , String type , int modifier) throws Exception{
        // 添加成员变量
        CtField enameField = new CtField(pool.getCtClass("kaka.InvocationHandler"),name,ctClass);
        enameField.setModifiers(Modifier.PRIVATE);
        ctClass.addField(enameField);
    }

    @Override
    public Class<?> createClass(String packageName, String className, Class<?> inter) throws Exception {
        // ClassPool：CtClass对象的容器
        ClassPool pool = ClassPool.getDefault();
        // 通过ClassPool生成一个public新类
        CtClass ctClass = pool.makeClass(packageName + "."+className);
        // 添加接口
        ctClass.addInterface(pool.get(inter.getName()));
        // 添加 InvocationHandler 接口成员
        addField(pool, ctClass, "invocationHandler", "kaka.InvocationHandler", Modifier.PRIVATE);

        //添加构造函数    this.invocationHandler = invocationHandler;
        CtConstructor cons = new CtConstructor(new CtClass[]{pool.get("kaka.InvocationHandler")}, ctClass);
        // $0=this / $1,$2,$3... 代表方法参数
        cons.setBody("{$0.invocationHandler = $1;}");
        ctClass.addConstructor(cons);
        //------------ 添加方法-----------------
        for(Method method : inter.getDeclaredMethods()){
            // 方法名称
            String mName = method.getName();
            // 方法的类型
            CtClass returnType =  null ;
            if(method.getReturnType() == Void.class){
                returnType = CtClass.voidType ;
            }else{
                returnType = pool.get(method.getReturnType().getName());
            }
            // 获取参数
            Parameter[] ps = method.getParameters() ;
            if(ps != null && ps.length > 0){
                // 以逗号分隔的参数类型
                StringBuilder types = new StringBuilder();
                CtClass[] pCtClasses = new CtClass[ps.length];
                for(int i=0;i<pCtClasses.length;i++){
                    // 参数类型
                    pCtClasses[i] = pool.get(ps[i].getType().getName());
                    types.append(ps[i].getType().getName()+".class").append(",");
                }
                types.deleteCharAt(types.length()-1) ; // 删除最后一个字符 ,
                // 构造方法 对象
                CtMethod ctMethod = new CtMethod(returnType,mName, pCtClasses, ctClass);
                // 方法的修饰符
                ctMethod.setModifiers(method.getModifiers());
                // 添加方法的 代码
                ctMethod.setBody("{"
                        +  "java.lang.reflect.Method curMethod = Class.forName(\"" + inter.getName()+"\").getMethod(\""+mName+"\",new Class[]{"+types+"});"
                        +  "invocationHandler.invoke(this,curMethod, $args);"
                        +  "}");
                // 添加方法
                ctClass.addMethod(ctMethod);
            }else{
                // 空参数
                CtMethod ctMethod = new CtMethod(returnType,mName, null, ctClass);
                ctMethod.setModifiers(method.getModifiers());
                ctMethod.setBody("{"
                        +  "java.lang.reflect.Method curMethod = Class.forName(\"" + inter.getName()+"\").getMethod(\""+mName+"\",null);"
                        +  "this.invocationHandler.invoke(this,curMethod,null);"
                        +  "}");
                ctClass.addMethod(ctMethod);
            }
        }
        Object write = System.getProperties().get("com.kaka.saveGeneratedFiles");
        if(write != null && write.equals("true")){
            // 写入文件
            System.err.println("write class file");
            ctClass.writeFile();
        }
        return ctClass.toClass();
    }
}
