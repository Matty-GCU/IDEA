package design.pattern.ch23.state.example2;

public class Client {
    public static void main(String[] args) {
        Switch switch1 = new Switch("开关1");
        Switch switch2 = new Switch("开关2");
        switch1.on();
        switch2.on();
        switch1.off();
        switch2.off();
    }
}
