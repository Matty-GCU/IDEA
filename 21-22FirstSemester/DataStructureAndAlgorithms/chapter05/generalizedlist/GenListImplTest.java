package chapter05.generalizedlist;

public class GenListImplTest {
    public static void main(String[] args) {
        GenListImpl<String> a = GenListCreator.create("G(d,L(a,b),T(c,L(a,b)))");
        GenListImpl<String> b = GenListCreator.create("E()");
        GenListImpl<String> c = GenListCreator.create("L(a,b)");
        GenListImpl<String> d = GenListCreator.create("T(c,L(a,b))");

        System.out.println(a.getName());
        System.out.println(b.getName());

        System.out.println(a.depth());
        System.out.println(b.depth());
        System.out.println(c.depth());
        System.out.println(d.depth());

        System.out.println(b.isEmpty());
        System.out.println(c.isEmpty());
    }
}
