package strategymodel;

public class LateExHandler implements ExHandler {
    public void exceptionHandler() {
        System.out.println("迟到异常处理逻辑");
    }
}
