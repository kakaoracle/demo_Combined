package apply;

public class EchoServiceImpl implements EchoService {
    @Override
    public void echo(String msg) {
        System.out.println(msg);
    }
}
