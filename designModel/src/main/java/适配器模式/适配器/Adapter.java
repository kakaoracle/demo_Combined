package 适配器模式.适配器;

import 适配器模式.德标和国标接口.DB;
import 适配器模式.德标和国标接口.GB;

public class Adapter implements DB {
    private GB gb;

    public Adapter() {
    }

    public Adapter(GB gb) {
        this.gb = gb;
    }

    @Override
    public void dbpower() {
        gb.gbpower();
    }
}
