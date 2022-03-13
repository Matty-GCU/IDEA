package textbook.chapter03.assemble.annotation3;

public class Parrot {

    String name;

    public Parrot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
