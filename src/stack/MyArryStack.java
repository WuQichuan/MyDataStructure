package stack;

import Array.MyArray;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: Created in:2018/9/27 22:56
 * @Version: 1.0
 */
public class MyArryStack<E> implements IMyStack{
    MyArray<E> array;

    /**
     * @description:有参数的构造方法，创建指定容量的数组
     * @author WuQiChuan
     * @date 2018/9/27 22:58
     * @param capacity 栈的容量
     * @return
     * @version: 1.0
     */
    public MyArryStack(int capacity){
        array = new MyArray<>(capacity);
    }

    /**
     * @description:无参的构造方法，创建默认容量的数组
     * @author WuQiChuan
     * @date 2018/9/27 22:59
     * @param
     * @return
     * @version: 1.0
     */
    public MyArryStack(){
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

    @Override
    public void push(Object o) {
        //用于泛型擦去的原因，此处只能用过Object来转换成E类型
        E e = (E) o;
        array.add(e);
    }



    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast() ;
    }

    /**
     * @description: 获得栈的容量
     * @author WuQiChuan
     * @date 2018/9/27 23:01
     * @param
     * @return int
     * @version: 1.0
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : [");
        for (int i = 0; i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(" , ");
            }
        }
        res.append("] Stack TOP");
        return res.toString();
    }
}
