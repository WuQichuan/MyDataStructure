package maxheap;

import queue.IQueue;

/**
 * @author WuQiChuan
 * @Description: 优先队列-----使用最大堆实现
 * @Date: 2018/11/15 09:50
 * @Version: 1.0
 */
public class MyPriorityQueue<T extends Comparable<T>> implements IQueue {
    private MaxHeap<T> maxHeap;
    public MyPriorityQueue(){
        maxHeap = new MaxHeap<>();
    }
    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(Object o) {
        T t = (T) o;
        maxHeap.add(t);
    }

    @Override
    public Object dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public Object getFront() {
        return maxHeap.findMax();
    }
}
