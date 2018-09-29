package stack;

/**
 * @author WuQiChuan
 * @Description:自我封装的数据结构：栈
 * 简单说明：栈，先进后出，先进的进入栈底部，每次只能从栈顶取出元素
 * @Date: Created in:2018/9/27 22:27
 * @Version: 1.0
 */
public interface IMyStack<E> {
    /**
     * @description:获取栈的大小
     * @author WuQiChuan
     * @date 2018/9/27 22:30
     * @param
     * @return int
     * @version: 1.0
     */
    int getSize();

    /**
     * @description: 查看栈是否为空
     * @author WuQiChuan
     * @date 2018/9/27 22:30
     * @param
     * @return boolean
     * @version: 1.0
     */
    boolean isEmpty();

    /**
     * @description:入栈方法：向栈中添加一个元素e
     * @author WuQiChuan
     * @date 2018/9/27 22:31
     * @param e
     * @return void
     * @version: 1.0
     */
    void push(E e);

    /**
     * @description:出栈方法：移除栈顶元素e
     * @author WuQiChuan
     * @date 2018/9/27 22:54
     * @param
     * @return E
     * @version: 1.0
     */
    E pop();

    /**
     * @description:查看栈顶元素e
     * @author WuQiChuan
     * @date 2018/9/27 22:55
     * @param
     * @return E
     * @version: 1.0
     */
    E peek();
}
