package 适配器模式.德标和国标接口;

public class DBimpl implements DB {
    @Override
    public void dbpower() {
        System.out.println("---使用德标充电");
    }
}
