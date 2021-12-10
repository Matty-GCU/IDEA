package chapter05.generalizedlist;

public class GenListImplTest {
    public static void main(String[] args) {
        GenListImpl<String> a = GenListCreator.create("G(d,L(a,b),T(c,L(a,b)))");
        GenListImpl<String> b = GenListCreator.create("E()");
        GenListImpl<String> c = GenListCreator.create("L(a,b)");
        GenListImpl<String> d = GenListCreator.create("T(c,L(a,b))");
        System.out.println(b.isEmpty());
        System.out.println(c.isEmpty());
    }
}
