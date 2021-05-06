package com.hello.aspectj;

public class ApiTest {
    public void hi(){
        System.out.println("Hi Aspect");
    }

    public static void main(String[] args) {
        ApiTest apiTest = new ApiTest();
        apiTest.hi();
    }
}
