package teamwork02.v1;

public class Service {
    public static void main(String[] args) {
        double sum=100;
        Components component1=new Component1();
        Components component2=new Component2();
        sum+=component1.buy();
        sum+=component2.sell();
        System.out.println(sum);
    }
}
