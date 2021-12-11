package chapter05.generalizedlist;

public class GenListImplTest2 {
    public static void main(String[] args) {
        //课本147页【例5.3】广义表的构造算法与基本操作
        String gListStr = "G(d,L(a,b),T(c,L(a,b)))";
        GenListImpl<String> graph = GenListCreator.create(gListStr);
        System.out.println("构造" + graph + ", size=" + graph.size + ", depth=" + graph.depth());
        GenListImpl<String> list = graph.get(1).child;
        graph.insert(0, list);
        //list成为共享子表，graph成为图（若广义表中有子表且包含共享元素，则构成图结构）
        System.out.println(graph.getName() + "头插入" + list + "\n" + graph);
        GenNode<String> p = list.remove(0);
        System.out.println(list.getName() + "头删除" + p + "\n" + graph);
    }
}
