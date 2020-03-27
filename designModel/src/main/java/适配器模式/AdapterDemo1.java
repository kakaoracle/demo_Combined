package 适配器模式;

import 适配器模式.德标和国标接口.DB;
import 适配器模式.德标和国标接口.DBimpl;
import 适配器模式.德标和国标接口.GB;
import 适配器模式.德标和国标接口.GBimpl;

/**
 * @description:原始格式,没有用到适配器Adapter类
 * @author: DeZhao Chen
 * @create: 2019-04-09 12:22
 **/
public class AdapterDemo1 {
    //用途:充电
    public static void main(String[] args) {
        DB db = new DBimpl();//德标充电
        db.dbpower();

        GB gb = new GBimpl();//国标充电
        gb.gbpower();
    }

}







































