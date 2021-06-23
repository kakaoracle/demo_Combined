package AdapterModel.适配器;

import AdapterModel.德标和国标接口.DB;
import AdapterModel.德标和国标接口.GB;

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
