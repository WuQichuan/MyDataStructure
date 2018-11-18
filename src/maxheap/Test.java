package maxheap;

import java.util.Random;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: 2018/11/15 09:18
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0 ; i < n ;i++){
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = maxHeap.extractMax();
        }
        for(int i = 1;i<n;i++){
            System.out.println(arr[i-1]);
            if(arr[i-1] < arr[i]){

                System.out.println("最大堆有问题");
            }
        }
        System.out.print("测试完成");
    }
}
