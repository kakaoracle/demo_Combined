package templateModel;

/**
 * wtc使用wtc框架后的自定义的业务处理逻辑
 */
public class WTCBusiness extends WTCQuartz{
    @Override
    public void wtcExecute() {
        System.out.println("wtc自定义操作");
    }

}
