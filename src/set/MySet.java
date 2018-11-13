package set;

/**
 * @author WuQiChuan
 * @Description: 自我封装数据结构：Set集合
 * @Date: 2018/11/12 14:33
 * @Version: 1.0
 */
public interface MySet<T> {
    /**
     * @description 向Set集合中添加一个元素，不允许重复的
     * @author WuQiChuan
     * @param: t
     * @return: void
     * @date: 2018/11/12 14:36
     * @version: 1.0
     */
    void add(T t);

    /**
     * @description 移除Set集合中的这个元素
     * @author WuQiChuan
     * @param: t
     * @return: void
     * @date: 2018/11/12 14:36
     * @version: 1.0
     */
    void remove(T t);

    /**
     * @description 判断Set集合中是否存在该元素
     * @author WuQiChuan
     * @param: t
     * @return: boolean
     * @date: 2018/11/12 14:37
     * @version: 1.0
     */
    boolean contains(T t);

    /**
     * @description 获取Set集合大小
     * @author WuQiChuan
     * @param:
     * @return: int
     * @date: 2018/11/12 14:37
     * @version: 1.0
     */
    int getSize();

    /**
     * @description 判断Set集合是否为空
     * @author WuQiChuan
     * @param: []
     * @return: boolean
     * @date: 2018/11/12 14:37
     * @version: 1.0
     */
    boolean isEmpty();
}
