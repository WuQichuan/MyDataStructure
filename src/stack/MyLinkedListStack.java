package stack;

import LinkedList.MyLinkedList;

/**
 * @author WuQiChuan
 * @Description: 自我封装的数据结构：栈(使用链表实现)
 * @Date: Created in:2018/10/7 21:23
 * @Version: 1.0
 */
public class MyLinkedListStack<E> implements IMyStack {

    //使用链表实现栈
    private MyLinkedList<E> list;

    /**
     * @description: 构造方法，初始化链表
     * @author WuQiChuan
     * @date 2018/10/7 21:26
     * @param
     * @return
     * @version: 1.0
     */
    public MyLinkedListStack(){
        list = new MyLinkedList<>();
    }
    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(Object o) {
        //用于泛型擦去的原因，此处只能用过Object来转换成E类型
        E e = (E) o;
        list.addFirst(e);

    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack Top: [");
        res.append(list);
        res.append("] ");
        return res.toString();
    }

    //用来测试的主函数
    /*public static void main(String[] args) {
        MyLinkedListStack<Integer> myLinkedListStack = new MyLinkedListStack<>();
        for(int i = 0 ;i < 10 ; i++ ){
            myLinkedListStack.push(i);
            System.out.println(myLinkedListStack);
            if(i%3 == 2){
                myLinkedListStack.pop();
                System.out.println(myLinkedListStack);
            }
        }
    }*/
}
