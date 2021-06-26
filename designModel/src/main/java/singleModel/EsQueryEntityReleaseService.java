package singleModel;

public class EsQueryEntityReleaseService {
    // 让构造方法无法被外界实例化
    private EsQueryEntityReleaseService() {
    }

    // 单例
    private volatile static EsQueryEntityReleaseService esQueryEntityReleaseService = null;

    // 双重检查加锁 懒汉式
    public static EsQueryEntityReleaseService getInstance() {
        if (esQueryEntityReleaseService == null) {
            synchronized (EsQueryEntityReleaseService.class) {
                if (esQueryEntityReleaseService == null) {
                    esQueryEntityReleaseService = new EsQueryEntityReleaseService();
                }
            }
        }
        return esQueryEntityReleaseService;
    }


}
