package strategymodel;

public class StrategyModelTest {
    public static void main(String[] args) {
        // 传入参数不管是early,还是late都能用同一套方法处理,比如这次传early
        String inPut = "early";

        for (ExEnum item:ExEnum.values()) {
            if (inPut.equals(item.getVal())) {
                item.exHandler.exceptionHandler();
            }
        }
    }
}
