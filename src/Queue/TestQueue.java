package Queue;

/**
 * @author WuQiChuan
 * @Description:测试队列
 * @Date: Created in:2018/9/29 21:49
 * @Version: 1.0
 */
public class TestQueue {
    public static void main(String[] args) {
        MyLoopQueue<Integer> queue = new MyLoopQueue<>();
        for(int i = 0 ;i < 10 ; i++ ){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
