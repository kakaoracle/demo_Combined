package 适配器模式;

import 适配器模式.德标和国标接口.DB;
import 适配器模式.德标和国标接口.DBimpl;
import 适配器模式.德标和国标接口.GB;
import 适配器模式.德标和国标接口.GBimpl;
import 适配器模式.适配器.Adapter;

/**
 * @description:用适配器来实现
 * @author: DeZhao Chen
 * @create: 2019-04-09 12:22
 **/
public class AdapterDemo2 {
    //用途:充电
    public static void main(String[] args) {
        GB gbimpl = new GBimpl();
        Adapter adapter = new Adapter(gbimpl);
        adapter.dbpower();//国标充电

        DB dBimpl = new DBimpl();
        dBimpl.dbpower();//德标充电
    }
}







































