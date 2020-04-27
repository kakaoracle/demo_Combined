package JNI;
/*
* 写一个native方法,通过jni调用c/c++方法
* no modify
* */
public class HelloWorld {
    public native void sayHelloWorld();
    static {
        System.loadLibrary("sayHello");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHelloWorld();
    }
}
