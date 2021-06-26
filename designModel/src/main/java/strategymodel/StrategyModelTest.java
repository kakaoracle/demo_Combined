package strategymodel;

public class StrategyModelTest {
    public static void main(String[] args) {
        // 传入参数不管是early,还是late都能用同一套方法处理,比如这次传early
        String inPut = "early";
        // 中心就是遍历枚举类,val相同时执行对应的实例
        for (ExEnum item:ExEnum.values()) {
            if (inPut.equals(item.getVal())) {
                item.exHandler.exceptionHandler();
            }
        }
    }
}
