package LinkedList;

/**
 * @author WuQiChuan
 * @Description:自我封装数据结构：链表
 * @Date: Created in:2018/10/6 15:18
 * @Version: 1.0
 */
public class MyLinkedList<E> {
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
        public Node(E e,Node next){
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

    //虚拟头结点，为空，虚拟头结点的next指向真正的头结点
    private Node dummyhead;
    //链表大小（链表中有多少个元素）
    private int size;

    /**
     * @description:构造方法，初始化链表
     * @author WuQiChuan
     * @date 2018/10/6 15:26
     * @param
     * @return
     * @version: 1.0
     */
    public MyLinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }

    /**
     * @description:获取当前链表有多少个元素
     * @author WuQiChuan
     * @date 2018/10/6 15:27
     * @param
     * @return int
     * @version: 1.0
     */
    public int getSize() {
        return size;
    }

    /**
     * @description:判断链表是否为空，空返回true,不空返回false
     * @author WuQiChuan
     * @date 2018/10/6 15:28
     * @param
     * @return boolean
     * @version: 1.0
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * @description: 在链表为Index索引的位置（从0开始），添加元素e
     * @author WuQiChuan
     * @date 2018/10/6 15:46
     * @param index, e
     * @return void
     * @version: 1.0
     */
    public void add(int index,E e){
        //判断Index是否合法
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("add failed,Illegal index");
        }

        //创建prev节点指虚拟节点
        Node prev = dummyhead;
        //遍历链表，直到找到了Index之前的节点
        //因为prev第一次指向的是虚拟头结点下一次才能指向真的头结点
        //所以遍历index次之后，指向的就是Index之前的节点
        for (int i = 0;i<index ;i++){
            //Prev不断后移，直到Prev成为index索引之前的一个节点
            prev = prev.next;
        }

        /*//创建新节点node
        Node node = new Node(e);
        //node的next指向prev的next，也就是连接到了index位置的节点
        node.next = prev.next;
        //prev的next再指向node，这样链表就添加节点并连接上了
        prev.next = node;*/

        //这行代码和上面注释掉的代码意思相同,可以自己体会下
        prev.next = new Node(e,prev.next);
        size++;

    }

    /**
     * @description: 向链表头部添加元素e
     * @author WuQiChuan
     * @date 2018/10/6 15:42
     * @param e
     * @return void
     * @version: 1.0
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * @description: 向链表末尾添加元素e
     * @author WuQiChuan
     * @date 2018/10/6 15:58
     * @param e
     * @return void
     * @version: 1.0
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * @description: 在链表为Index索引的位置（从0开始），删除元素e
     * @author WuQiChuan
     * @date 2018/10/7 21:13
     * @param index
     * @return E
     * @version: 1.0
     */
    public E remove(int index){
        //判断Index是否合法
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("remove failed,Illegal index");
        }
        //要找到待删除节点的前一个节点
        Node prev = dummyhead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        //delNode为待删除节点
        Node delNode = prev.next;
        //将待删除节点的前一个节点的next直接连接到待删除节点的next
        //也就是直接跳过待删除节点，就相当于删除了这个节点
        prev.next = delNode.next;
        //将待删除节点的next变为null，使其彻底脱离这个链表并便于回收
        delNode.next = null;
        size --;

        return delNode.e;
    }

    /**
     * @description:删除链表第一个元素
     * @author WuQiChuan
     * @date 2018/10/7 21:16
     * @param
     * @return E
     * @version: 1.0
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * @description:删除最后一个元素
     * @author WuQiChuan
     * @date 2018/10/7 21:17
     * @param
     * @return E
     * @version: 1.0
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * @description:获取链表第Index个元素
     * @author WuQiChuan
     * @date 2018/10/6 16:08
     * @param index
     * @return E
     * @version: 1.0
     */
    public E get(int index){
        //判断Index是否合法
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("get failed,Illegal index");
        }
        //将cur指向虚拟头结点的Next，也就是真的头结点
        Node cur = dummyhead.next;
        //cur不断后移index次，到达Index位置
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * @description:获取链表第一个元素
     * @author WuQiChuan
     * @date 2018/10/6 16:12
     * @param
     * @return E
     * @version: 1.0
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * @description:获取链表最后一个元素
     * @author WuQiChuan
     * @date 2018/10/6 16:14
     * @param
     * @return E
     * @version: 1.0
     */
    public E getLast(){
        //因为从0开始，大小-1才是索引位置
        return get(size - 1);
    }

    /**
     * @description: 修改链表第Index个元素为新的元素e
     * @author WuQiChuan
     * @date 2018/10/6 16:17
     * @param index, e
     * @return void
     * @version: 1.0
     */
    public void set(int index,E e){
        //判断Index是否合法
        if(index < 0 || index > size){
            throw  new IllegalArgumentException("set failed,Illegal index");
        }

        Node cur = dummyhead.next;
        //cur不断后移index次，到达Index位置
        for(int i = 0;i < index;i++){
            cur = cur.next;
        }
        //现在cur就是index索引位置的节点，将新的e赋值到这个节点的元素e上
        cur.e = e;
    }

    /**
     * @description: 查找链表中是否存在元素e，存在返回true，不存在返回false
     * @author WuQiChuan
     * @date 2018/10/6 16:22
     * @param e
     * @return boolean
     * @version: 1.0
     */
    public boolean contains(E e){
        Node cur = dummyhead.next;
        //因为最后一个节点的next是空，如果cur为空则说明链表遍历完毕
        while (cur != null){
            //如果存在返回false
            if(cur.e.equals(e)){
                return true;
            }
            //否则节点后移
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyhead.next;
        while (cur != null){
            res.append(cur +"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
