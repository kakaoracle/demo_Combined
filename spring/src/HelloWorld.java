import java.util.List;

/**
 * @description:
 * @author: DeZhao Chen
 * @create: 2019-11-07 09:19
 **/
public class HelloWorld {
    private String name;
    private List<String> tracks;

    public HelloWorld(String name, List<String> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public HelloWorld(String s) {
    }

    public void getName() {
        System.out.println("hello"+name);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void getTracks() {
        for(String s :tracks){
            System.out.println(s);
        }
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
