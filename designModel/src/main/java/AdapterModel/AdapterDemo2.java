package AdapterModel;

import AdapterModel.德标和国标接口.DB;
import AdapterModel.德标和国标接口.DBimpl;
import AdapterModel.德标和国标接口.GB;
import AdapterModel.德标和国标接口.GBimpl;
import AdapterModel.适配器.Adapter;

/**
 * @description:用适配器来实现
 * @author: DeZhao Chen
 * @create: 2019-04-09 12:22
 **/
public class AdapterDemo2 {
    //用途:充电
    public static void main(String[] args) {
        DB dBimpl = new DBimpl();
        dBimpl.dbpower();//德标充电

        GB gbimpl = new GBimpl();
        Adapter adapter = new Adapter(gbimpl);
        adapter.dbpower();//国标充电


    }
}







































