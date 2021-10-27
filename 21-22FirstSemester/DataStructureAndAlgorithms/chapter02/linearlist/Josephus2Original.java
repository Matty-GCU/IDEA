package chapter02.linearlist;

/**
 * 算法不可抄，写完再对照。
 * 原创，没有看课本。
 * O(N*N)
 */
public class Josephus2Original {
    public Josephus2Original(int n, int startIndex, int distance) {
        if(startIndex < 0 || startIndex >= n || distance <= 0 || distance >= n) {
            throw new IllegalArgumentException();
        }
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        //O(N*N)
        for(int i = 0; i < n; i++) {
            list.insert((char)((int)('A') + i));
        }
        System.out.println(list);
        //O(N*N)
        while(list.size > 1) {
            startIndex = (startIndex + (distance - 1)) % n;
            System.out.println("remove" + list.remove(startIndex) + ", " + list);
            n--;
        }
        //O(N)
        System.out.println("被赦免者是" + list.get(0));
    }
}
