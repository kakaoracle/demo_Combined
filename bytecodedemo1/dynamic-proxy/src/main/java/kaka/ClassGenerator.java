package kaka;

public interface ClassGenerator {
    public Class<?> createClass(String packageName , String className , Class<?> inter) throws Exception ;
}
