package templateModel;

/**
 * wtc自己的包装的平台的框架
 */
public abstract class WTCQuartz extends Quartz{
    @Override
    public void execute() {
        System.out.println("wtc工程执行前操作");
        wtcExecute();
        System.out.println("wtc工程执行后操作");
    }

    public abstract void wtcExecute();

}
