package map;

/**
 * @author WuQiChuan
 * @Description: 基于二分搜索树实现MAP映射
 * @Date: 2018/11/13 12:44
 * @Version: 1.0
 */
public class MyBSTMap<K extends Comparable<K>,V> implements MyMap<K,V> {
    //二分搜索树的内部节点
    private class Node{
        private K key;
        private V value;
        //左孩子
        public Node left;
        //右孩子
        public Node right;
        public Node(K key , V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
    //根节点
    private Node root;
    //二分搜索树有多少个元素
    private int size;
    public MyBSTMap(){
        root = null;
        size = 0;
    }
    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }


    /**
     * @description: 内部调用的向二分搜索树中添加元素
     * 将k-v节点添加到Node为根的接点上
     * @author WuQiChuan
     * @date 2018/10/9 21:18
     * @param node, key，value
     * @return Node
     * @version: 1.0
     */
    private Node add(Node node, K key, V value){
        //递归终止，当传入节点为空的时候，新建一个节点保存元素
        if(node == null){
            size++;
            return new Node(key, value);
        }
        //key小于Node，则添加到左子树
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key, value);
        }
        //key大于Node，则添加到右子树
        if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key, value);
        }
        //如果key相等，则把该key节点的value变成新的value
        if(key.compareTo(node.key) == 0){
            node.value = value;
        }
        return node;
    }

    /**
     * @description 返回以node为根节点的二分搜索树中，key所在的节点
     * @author WuQiChuan
     * @param: node, key
     * @return: map.MyBSTMap<K,V>.Node
     * @date: 2018/11/13 13:00
     * @version: 1.0
     */
    private Node getNode(Node node,K key){
        if(node == null){
            return null;
        }
        //如果key小于node,key则去左子树
        if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
            //如果key大于node.key则去右子树
        }else if(key.compareTo(node.key) > 0){
            return getNode(node.right,key);
        }else{
            //否则说明key = node.key，返回node
            return node;
        }
    }


    /**
     * @description: 返回当前节点下的最小元素，递归方法
     * @author WuQiChuan
     * @date 2018/10/15 20:07
     * @param node
     * @return T
     * @version: 1.0
     */
    private Node minInum(Node node){
        //递归结束条件，左子树为空，返回当前节点元素
        if(node.left == null){
            return node;
        }
        //否则递归去左子树寻找
        return minInum(node.left);
    }


    /**
     * @description: 递归删除当前节点下的最小元素
     *
     * @author WuQiChuan
     * @date 2018/10/15 20:41
     * @param node
     * @return tree.MyBinarySearchTree<T>.Node
     * @version: 1.0
     */
    private Node removeMin(Node node){
        //递归结束条件，左子树为空说明当前节点为最小
        if(node.left == null){
            //把最小节点的右子树保存
            Node rightChild = node.right;
            size--;
            node.right = null;
            //返回最小节点的右子树
            return rightChild;
        }
        //最小节点的上一个节点的左子树连接到最小节点的右子树上

        node.left = removeMin(node.left);
        return node;
    }
    @Override
    public V remove(K key) {
        return null;
    }
    private Node remove(Node node,K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }else{//node.key == key,说明要删除node
            //待删除节点左子树为空
            if(node.left == null){
                Node rightChild = node.right;
                node.right =null;
                size--;
                return rightChild;
            }
            //待删除节点右子树为空
            if(node.right == null){
                Node leftChild = node.left;
                node.left =null;
                size--;
                return leftChild;
            }
            //待删除节点左右子树都不为空
            //找到比待删除节点大的最小节点(后继)，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minInum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if(node == null){
            throw  new  IllegalArgumentException(key+"不存在！");
        }
        node.value = newValue;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
