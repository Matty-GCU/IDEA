package chapter05.generalizedlist;

/**
 * GenListImpl<T>不能提供以字符串为参数的构造方法，因为那样构造的广义表应该是GenList<String>，不是GenList<T>。
 * 所以我们需要一个广义表实用类，给出由【广义表表示字符串】构造String型广义表的方法。
 * 已测试
 * @author Matty's PC
 */
public class GenListCreator {
    private static int i = 0;

    /**
     * 返回以【genListStr表示】创建的广义表
     * 已测试
     */
    public static GenListImpl<String> create(String genListStr) {
        i = 0;
        if(genListStr == null || genListStr.length() == 0) {
            return null;
        }
        return create2(genListStr, null);
    }

    /**
     * 返回以【genListStr表示】创建的广义表，data为表名
     * 已测试
     * 能懂，不过自己写比较困难
     */
    private static GenListImpl<String> create2(String str, String data) {
        if(data == null) {
            i = str.indexOf('(');
            data = str.substring(0, i);
//            System.out.println("如果data为null，则以第一个'('之前的字符串 " + data + " 作为表名");
//            System.out.println("///此时i= " + i + " str.charAt(i)= " + str.charAt(i) + " ///");
        }
        GenListImpl<String> genList = new GenListImpl<>(data);
        GenNode<String> p = genList.head;
        i++;
        while(i < str.length()) {
            switch(str.charAt(i)) {
                case ',':
                    i++;
                    break;
                case ')':
                    i++;
//                    System.out.println("----------遇到')'，说明当前广义表构造完成，返回广义表对象----------");
                    return genList;
                default:
                    int start = i;
                    //从start开始找原子/表名
                    while(i < str.length() && "(,)".indexOf(str.charAt(i)) == -1) {
                        i++;
                    }
                    data = str.substring(start, i);
//                    System.out.println("找到下一个原子数据域/下一个结点表名 " + data);
//                    System.out.println("***此时i= " + i + " str.charAt(i)= " + str.charAt(i) + " ***");
                    if(i < str.length() && str.charAt(i) == '(') {
//                        System.out.println("----------遇到'('，说明当前结点存在子表，进入子表的构造----------");
                        p.next = new GenNode<>(data, create2(str, data), null);
                    }
                    else {
                        p.next = new GenNode<>(data, null, null);
                    }
                    p = p.next;
                    genList.size++;
            }
        }
        return genList;
    }
}
