package templateModel;

public class Test {
    public static void main(String[] args) {
        WTCBusiness wtcBusiness = new WTCBusiness();
        // 系统每次调用的是execute方法,wtc自己的业务处理写在自己的wtcexecute中,且wtcexecute方法在execute方法中,因此起到了作用
        wtcBusiness.execute();
    }
}
