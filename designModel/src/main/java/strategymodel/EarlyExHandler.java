package strategymodel;

public class EarlyExHandler implements ExHandler {
    public void exceptionHandler() {
        System.out.println("早到异常处理逻辑");
    }
}
