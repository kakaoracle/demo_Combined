package ehcache.demo;

import ehcache.demo.service.EhcacheService;
import ehcache.demo.serviceimpl.EhcacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class EhcacheServiceTest  {
    static EhcacheService ehcacheService=new EhcacheServiceImpl();
    public static void main(String[] args) throws  InterruptedException{
        testCache();
    }
    public static void testTimestamp() throws  InterruptedException{
        System.out.println("第一次调用"+ehcacheService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehcacheService.getTimestamp("param"));
        Thread.sleep(4000);
        System.out.println("再过4秒之后调用：" + ehcacheService.getTimestamp("param"));


    }

    public static void testCache() {
        String key = "zhangsan";
        String value = ehcacheService.getDataFromDB(key); // 从数据库中获取数据...
        ehcacheService.getDataFromDB(key); // 从缓存中获取数据，所以不执行该方法体
        ehcacheService.removeDataAtDB(key); // 从数据库中删除数据
        ehcacheService.getDataFromDB(key); // 从数据库中获取数据...（缓存数据删除了，所以要重新获取，执行方法体）
    }
}
