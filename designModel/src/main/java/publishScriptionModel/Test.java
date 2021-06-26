package publishScriptionModel;

public class Test {
    public static void main(String[] args) {
        IPublisher musciPublisher = new PublisherImp("music");
        new SubscriberImp("music");
        new SubscriberImp("book");
        //第一次调用线程池执行任务时，线程池需要消耗一定时间预热（大概40毫秒）
        musciPublisher.publishMessageByAsyn("线程池预热");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            // 可以同步执行，也可以异步执行
			musciPublisher.publishMessageByAsyn("来自musicPublisher的异步消息");
//            musciPublisher.publishMessageBySync("来自musicPublisher的同步消息");
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start)+"毫秒");
    }
}
