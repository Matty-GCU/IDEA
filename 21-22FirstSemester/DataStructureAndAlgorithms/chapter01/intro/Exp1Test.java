package chapter01.intro;

/**
 * 20210908数据结构上机实验
 * 20210909修改了【超出size-1】和【跳不出while】的错误
 */
public class Exp1Test {

    public static void main(String[] args) {
        Exp1Array array1 = new Exp1Array();
//        array1.print1(array1.random1(10, 10));
//        array1.print1(array1.random2(10, 10));
        array1.print2(array1.random1(10, 10));
        array1.print2(array1.random2(10, 10));
        array1.print2(array1.random3(10, 10));
    }
}

