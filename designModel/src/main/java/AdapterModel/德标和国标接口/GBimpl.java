package AdapterModel.德标和国标接口;

public class GBimpl implements GB {

    @Override
    public void gbpower() {
        System.out.println("---使用国标充电");
    }
}
