package chapter02.linearlist.linked;

/**
 * 为什么要另写一个对照课本的版本，而不用自己的版本？因为他的时间复杂度是O(N)而我自己写的是O(N*N)！
 */
public class Josephus2 {
    public Josephus2(int n, int startIndex, int distance) {
        //这个检查照例都是有的
        if(startIndex < 0 || startIndex >= n || distance <= 0 || distance >= n) {
            throw new IllegalArgumentException();
        }
        //此时0<=startIndex<n && 0<distance<n
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        //头插入，O(N)，妙啊！
        for(int i = n - 1; i >= 0; i--) {
            list.insert(0, (char)('A' + i));
        }
        System.out.println(list);
        //front指向下标为startIndex-1的结点，O(N)
        Node<Character> front = list.head;
        for(int i = 0; front != null && i < startIndex; i++) {
            front = front.next;
        }
        //删除。O(N)
        while(n > 1) {
            for(int i = 1; i < distance; i++) {
                front = front.next;
                if(front == null) {
                    front = list.head.next;
                }
            }
            //若front指向尾结点，说明要删的是第1个结点，所以把front指向头结点；同时可以避免执行front.next.next报空指针异常
            if(front.next == null) {
                front = list.head;
            }
            System.out.print("删除" + front.next.data);
            front.next = front.next.next;
            System.out.println(", " + list);
            n--;
        }
        System.out.println("被赦免者：" + list.get(0));
    }
}
