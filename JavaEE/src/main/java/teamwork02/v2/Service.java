package teamwork02.v2;

public class Service {
    public static void main(String[] args) {
        Component sw=new sword();
        Component sh=new shield();
        sw.attack();
        sh.defend();
        sh.attack();
        sw.defend();
    }
}
