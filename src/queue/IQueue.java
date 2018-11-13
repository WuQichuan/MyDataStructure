package queue;

/**
 * @author WuQiChuan
 * @Description:自我封装数据结构：队列
 * 简单说明，先进先出。
 * @Date: Created in:2018/9/29 21:33
 * @Version: 1.0
 */
public interface IQueue<E> {
    /**
     * @description:获取队列大小
     * @author WuQiChuan
     * @date 2018/9/29 21:35
     * @param
     * @return int
     * @version: 1.0
     */
    int getSize();

    /**
     * @description:判断队列是否为空，为空返回true，否则返回false
     * @author WuQiChuan
     * @date 2018/9/29 21:35
     * @param
     * @return boolean
     * @version: 1.0
     */
    boolean isEmpty();

    /**
     * @description:入队
     * @author WuQiChuan
     * @date 2018/9/29 21:36
     * @param e
     * @return void
     * @version: 1.0
     */
    void enqueue(E e);

    /**
     * @description:出队
     * @author WuQiChuan
     * @date 2018/9/29 21:36
     * @param
     * @return E
     * @version: 1.0
     */
    E dequeue();

    /**
     * @description:获取队首元素
     * @author WuQiChuan
     * @date 2018/9/29 21:36
     * @param
     * @return E
     * @version: 1.0
     */
    E getFront();
}
