package Queue;

import Array.MyArray;

/**
 * @author WuQiChuan
 * @Description:数组队列
 * @Date: Created in:2018/9/29 21:38
 * @Version: 1.0
 */
public class MyArrayQueue<E> implements IQueue {
    //存储结构用的动态数组（自我封装版本）
    private MyArray<E> array;

    /**
     * @description:有参构造方法，创建指定容量的数组
     * @author WuQiChuan
     * @date 2018/9/29 21:41
     * @param capacity 指定的容量
     * @return
     * @version: 1.0
     */
    public MyArrayQueue(int capacity){
        array = new MyArray<>(capacity);
    }

    /**
     * @description:无参的构造方法，创建默认容量的数组
     * @author WuQiChuan
     * @date 2018/9/29 21:41
     * @param
     * @return
     * @version: 1.0
     */
    public MyArrayQueue(){
        array = new MyArray<>();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * @description:获取队列容量的方法
     * @author WuQiChuan
     * @date 2018/9/29 21:43
     * @param
     * @return int
     * @version: 1.0
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(Object o) {
        //用于泛型擦去的原因，此处只能用过Object来转换成E类型
        E e = (E) o;
        //入队就是将元素添加到数组末尾（后进）
        array.add(e);
    }

    @Override
    public Object dequeue() {
        //出队就是将数组最前面的移除（先出）
        return array.removeFirst();
    }

    @Override
    public Object getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue : Front [");
        for (int i = 0; i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(" , ");
            }
        }
        res.append("] Queue tail");
        return res.toString();
    }
}
