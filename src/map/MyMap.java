package map;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: 2018/11/12 16:49
 * @Version: 1.0
 */
public interface MyMap<K,V> {
    /**
     * @description 向映射中添加一个键值对元素
     * @author WuQiChuan
     * @param: key, value
     * @return: void
     * @date: 2018/11/12 16:51
     * @version: 1.0
     */
    void add(K key,V value);

    /**
     * @description 移除key为制定Key的元素并返回value
     * @author WuQiChuan
     * @param: key
     * @return: V
     * @date: 2018/11/12 16:52
     * @version: 1.0
     */
    V remove(K key);

    /**
     * @description 查看映射中是否含有该key的元素，有返回true
     * @author WuQiChuan
     * @param: key
     * @return: boolean
     * @date: 2018/11/12 16:52
     * @version: 1.0
     */
    boolean contains(K key);
    /**
     * @description 在映射中通过Key获取value
     * @author WuQiChuan
     * @param: key
     * @return: V
     * @date: 2018/11/12 16:53
     * @version: 1.0
     */
    V get(K key);
    /**
     * @description 为映射中该key赋新值
     * @author WuQiChuan
     * @param: key, newValue
     * @return: void
     * @date: 2018/11/12 16:54
     * @version: 1.0
     */
    void set(K key,V newValue);
    /**
     * @description 获取映射的大小
     * @author WuQiChuan
     * @param:
     * @return: int
     * @date: 2018/11/12 16:54
     * @version: 1.0
     */
    int getSize();

    /**
     * @description 判断映射是否为空
     * @author WuQiChuan
     * @param: []
     * @return: boolean
     * @date: 2018/11/12 16:55
     * @version: 1.0
     */
    boolean isEmpty();
}
