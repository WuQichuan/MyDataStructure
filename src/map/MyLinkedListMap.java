package map;

/**
 * @author WuQiChuan
 * @Description: 基于链表实现MAP映射
 * @Date: 2018/11/12 16:58
 * @Version: 1.0
 */
public class MyLinkedListMap<K,V> implements MyMap<K,V> {
    //节点
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key,V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString()+" ："+value.toString();
        }
    }
    //虚拟头结点
    private Node dummyHead;
    //集合的大小
    private int size;
    /**
     * @description 构造方法
     * @author WuQiChuan
     * @param: []
     * @return:
     * @date: 2018/11/12 17:03
     * @version: 1.0
     */
    public MyLinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }
    /**
     * @description 私有方法，根据Key 寻找节点
     * @author WuQiChuan
     * @param: key
     * @return: map.MyLinkedListMap<K,V>.Node
     * @date: 2018/11/12 17:05
     * @version: 1.0
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur!=null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        //如果不存在该Key则添加新的节点
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else{
            //否则将该Key节点的Value替换
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        //遍历链表，找到待删除节点的前一个节点
        while (prev.next != null){
            if(prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }
        //如果prev.next不为空说明找到了，则删除待删除节点，返回待删除节点的value
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        //说明没找到，返回空
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        //不存在key报异常
        if(node == null){
            throw  new  IllegalArgumentException(key+"不存在！");
        }
        //存在该key则替换新的值
        node.value = newValue;

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
