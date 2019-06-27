
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {
    public static void main(String[] args) {
        CacheManager cacheManager=CacheManager.create("./src/main/resources/ehcache.xml");
        Cache cache=cacheManager.getCache("helloworldcache");
        Element element=new Element("key1","----------------hhhhhhhhhhhh");
        cache.put(element);

        Element value=cache.get("key1");
        System.out.println(value);
        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();

    }
}
