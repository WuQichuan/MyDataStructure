package Queue;

import LinkedList.MyLinkedList;

/**
 * @author WuQiChuan
 * @Description: 使用链表实现队列
 * @Date: Created in:2018/10/7 21:46
 * @Version: 1.0
 */
public class MyLinkedListQueue<E> implements IQueue {
    //私有内部类，节点
    private class Node{
        public E e;
        public Node next;

        /**
         * @description:构造方法，初始化元素e和next
         * @author WuQiChuan
         * @date 2018/10/6 15:21
         * @param e 当前节点元素e, next 指向下一个节点
         * @return
         * @version: 1.0
         */
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        /**
         * @description:初始化当前节点元素e，next为空
         * @author WuQiChuan
         * @date 2018/10/6 15:22
         * @param e 当前节点元素e
         * @return
         * @version: 1.0
         */
        public Node(E e){
            this(e,null);
        }

        /**
         * @description:构造方法，e和next全初始化为空
         * @author WuQiChuan
         * @date 2018/10/6 15:23
         * @param
         * @return
         * @version: 1.0
         */
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //头结点，用作队列首，用来出队
    private Node head;
    //尾结点，用作队列为，用来入队
    private Node tail;
    //链表大小（链表中有多少个元素）
    private int size;
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object o) {
        //用于泛型擦去的原因，此处只能用过Object来转换成E类型
        E e = (E) o;
        //如果tail为空，说明队列为空
        if(tail == null){
            //则尾部添加一个节点，并且头也指向这个节点
            tail = new Node(e);
            head = tail;
        }else{
            //如果队列不空的话就在tail添加一个新节点并tail后移
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;

    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw  new IllegalArgumentException("Queue is Empty");
        }
        //删除节点为头节点
        Node delNode = head;
        //head后移
        head = head.next;
        //如果head后移之后为空，说明目前队列为空，则将tail也变为空
        if(head == null){
            tail = null;
        }
        //原头节点的Next变为空，就脱离这个链表了，就相当于出队
        delNode.next = null;
        size --;
        return delNode.e;
    }

    @Override
    public Object getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = head;
        res.append("Queue Front:");
        while (cur != null){
            res.append(cur +"->");
            cur = cur.next;
        }
        res.append("NULL,Tail");
        return res.toString();
    }
}
