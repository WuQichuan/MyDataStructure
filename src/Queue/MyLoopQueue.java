package Queue;

/**
 * @author WuQiChuan
 * @Description:循环队列
 * @Date: Created in:2018/10/5 16:16
 * @Version: 1.0
 */
public class MyLoopQueue<E> implements IQueue {
    //存储数据的数组
    private E[] data;
    //队首所在位置的索引
    private int front;
    //队尾下一个位置所在的索引
    private int tail;
    //队列的大小
    private int size;

    /**
     * @description:有参的构造方法，初始化指定容量的循环队列
     * @author WuQiChuan
     * @date 2018/10/5 16:23
     * @param capacity 指定的队列容量（最多容纳多少个元素）
     * @return
     * @version: 1.0
     */
    public MyLoopQueue(int capacity){
        //因为循环队列会浪费一个单位，所以初始化容量+1长度的数组
        data = (E[]) new Object[capacity + 1];
        //其他变量初始化
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * @description:无参的构造方法，默认初始化容量为10的循环队列
     * @author WuQiChuan
     * @date 2018/10/5 16:23
     * @param
     * @return
     * @version: 1.0
     */
    public MyLoopQueue(){
        this(10);
    }

    /**
     * @description:获取当前队列的容量（最多可容纳多少个元素）
     * @author WuQiChuan
     * @date 2018/10/5 16:26
     * @param
     * @return int
     * @version: 1.0
     */
    public int getCapacity(){
        //因为有意浪费一个空间，所以真实容量为数组长度减一
        return data.length - 1;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(Object o) {
        //用于泛型擦去的原因，此处只能用过Object来转换成E类型
        E e = (E) o;
        //如果尾索引+1并且和数组长度取余数（因为是循环）等于了头索引说明队列已满
        if((tail + 1) % data.length == front){
            //所以进行2倍扩容
            resize(getCapacity() * 2);
        }
        //将元素放置到队尾索引的位置
        data[tail] = e;
        //队尾索引后移，因为是循环，所以队尾索引移动到现在位置+1并和数组总长度取余的位置
        tail = (tail + 1) % data.length;
        //队列大小（所含元素个数）+1
        size ++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue,无法从空队列出队");
        }
        //获取队首索引位置元素并返回
        E ret = data[front];
        //队首索引位置元素置空便于回收
        data[front] = null;
        //队首索引后移，因为是循环，所以队尾索引移动到现在位置+1并和数组总长度取余的位置
        front = (front + 1) % data.length;
        //队列大小（所含元素个数）- 1
        size --;
        //如果数组大小不足内数组总长度四分之一，则将数组容量缩减为原来一半
        //懒式缩容，给与预留空间，放置复杂度震荡
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public Object getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty ,队列为空");
        }
        return data[front];
    }

    /**
     * @description:改变队列的容量方法
     * @author WuQiChuan
     * @date 2018/10/5 16:59
     * @param newCapacity 新的容量
     * @return void
     * @version: 1.0
     */
    private void resize(int newCapacity){
        //创建新的数组
        E[] newData = (E[]) new Object[newCapacity + 1];
        //循环遍历旧数组，将旧数组的头放到新数组的0索引位置并将整个数组复制到新数组中
        for (int i = 0; i<size;i++){
            //因为是循环的。所以头索引+i个偏移量在和数组总长度取余数这个位置的旧数组放到新数组的第i个位置
            newData[i] = data[(front + i) % data.length];
        }
        //指向新数组
        data = newData;
        //复制的时候将旧数组的头放到了新数组0索引位置，所以front现在为0
        front = 0;
        //只是改变数组容量，数组内数据量没变化
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Arry : size = %d , capacity = %d\n",size,getCapacity()));
        res.append("Queue : Front [");
        //遍历存储数据的数组并拼接内容
        //从队列首遍历到队列尾，遍历时候 i 是循环 + 1的，循环直到i = 尾部索引所以为止
        for(int i = front; i != tail;i = (i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length != tail){
                res.append(",");
            }
        }
        res.append("] Queue tail");
        return res.toString();
    }
}
