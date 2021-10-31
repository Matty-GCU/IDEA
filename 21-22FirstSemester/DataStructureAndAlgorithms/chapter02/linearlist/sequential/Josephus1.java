package chapter02.linearlist.sequential;

public class Josephus1 {
    /**
     * 时间复杂度：O(N*N)
     */
    public Josephus1(int n, int start, int distance) {
//        if(n <= 0 || start < 0 || start >= n || distance <= 0 || distance >= n) {
        //为什么不用判断n<=0？因为：start>=0时会走到第二个判断，此时如果n<=0，则一定有start>=n，然后进入if。
        if(start < 0 || start >= n || distance <= 0 || distance >= n) {
            throw new IllegalArgumentException("n=" + n + ", start=" + start + ", distance=" + distance);
        }
        System.out.println("Josephus1(" + n + "," + start + "," + distance + ")");
        SequentialList<String> seqList = new SequentialList<>(n);
        for(int i = 0; i < n; i++) {
            //时间复杂度：O(N*N)
            seqList.insert((char) ('A' + i) + "");
        }
        //时间复杂度：O(N*N)
        while(n > 1) {
            start = (start + (distance - 1)) % n;
            //时间复杂度：O(N)
            System.out.println("remove" + seqList.remove(start) + ", " + seqList);
            n--;
        }
        System.out.println("被赦免者是" + seqList.get(0));
    }

}
