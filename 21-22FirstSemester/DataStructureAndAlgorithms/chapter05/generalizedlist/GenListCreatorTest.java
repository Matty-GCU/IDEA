package chapter05.generalizedlist;

public class GenListCreatorTest {
    public static void main(String[] args) {
        //使用课本147页的例子，方便对照
        GenListImpl<String> a = GenListCreator.create("G(d,L(a,b),T(c,L(a,b)))");
        System.out.println(a);
        System.out.println(a.size());

        //以下来自课本142的例子
        GenListImpl<String> b = GenListCreator.create("E()");
        GenListImpl<String> c = GenListCreator.create("L(a,b)");
        GenListImpl<String> d = GenListCreator.create("T(c,L(a,b))");
        System.out.println(b);
        System.out.println(b.size());
        System.out.println(c);
        System.out.println(c.size());
        System.out.println(d);
        System.out.println(d.size());
    }
}
