package kaka;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String name;

    private ClassLoader classLoader;

    @Override
    protected Class<?> findClass(String name) {
        // 注意类加载器加载的都是class不是java文件
        byte[] data1 = getBytes("/Users/kaka/Documents/githubRepository/demo_Combined/jvm_java/classloaderdemo/target/classes/kaka/Test1.class");

        Class<?> clazz = this.defineClass(name, data1, 0, data1.length);
        return  clazz;
    }

    public MyClassLoader(ClassLoader classLoader, String name) {
        super(classLoader);
        this.name = name;
    }

    // 第一种情况,直接调用自己的类加载器,此时由于不是通过Bootstrap加载器,因此不允许访问Object类
    /*@Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return findClass(name);
    }*/

    // 第二种情况:获取到了系统的类加载器,但此时getsystemclassloader默认获取的是app加载器,因此
    // 最后打印的也是app加载器
    /*@Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        ClassLoader system = getSystemClassLoader();
        Class<?> clazz = null;
        try {
            clazz = system.loadClass(name);
        } catch (ClassNotFoundException e) {

        }

        if (clazz != null) {
            return clazz;
        }

        return findClass(name);
    }*/
    // 第三种情况,用getsystenclassloader.getparent,此时获取的是extextion,有两个特点
    // 一是加载不到用户的类,二是向上可以加载到Object类,解决了这个矛盾,因此可以走下支
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        ClassLoader system = getSystemClassLoader().getParent();
        Class<?> clazz = null;
        try {
            clazz = system.loadClass(name);
        } catch (ClassNotFoundException e) {

        }

        if (clazz != null) {
            return clazz;
        }

        return findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // myClassLoader是自定义的,因此父加载器是application加载器
        MyClassLoader myClassLoader = new MyClassLoader(MyClassLoader.class.getClassLoader(), "MyClassLoader");
        Class<?> clazz = myClassLoader.loadClass("kaka.Test1");
        System.out.println(clazz.getClassLoader());
    }


    public byte[] getBytes(String filePath)  {
        InputStream is = null;
        byte[] data = null;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File(filePath));
            int c = 0;
            while ((c=is.read()) != -1){
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


}