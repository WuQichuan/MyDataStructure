package tree;

/**
 * @author WuQiChuan
 * @Description: 自我封装数据结构：二分搜索树
 * @Date: Created in:2018/10/9 19:48
 * @Version: 1.0
 */
public class MyBinarySearchTree <T extends Comparable<T>>{
    //二分搜索树的内部节点
    private class Node{
        private T t;
        //左孩子
        public Node left;
        //又孩子
        public Node right;

        /**
         * @description: 构造函数，将节点类型传入
         * @author WuQiChuan
         * @date 2018/10/9 19:52
         * @param t
         * @return
         * @version: 1.0
         */
        public Node(T t){
            this.t = t;
            left = null;
            right = null;
        }
    }

    //根节点
    private Node root;
    //拥有多少个元素
    private int size;
    /**
     * @description: 构造方法
     * @author WuQiChuan
     * @date 2018/10/9 19:53
     * @param
     * @return
     * @version: 1.0
     */
    public MyBinarySearchTree(){
        root = null;
        size = 0;
    }

    /**
     * @description: 查看当前树有多少个元素
     * @author WuQiChuan
     * @date 2018/10/9 19:54
     * @param
     * @return int
     * @version: 1.0
     */
    public int size(){
        return size;
    }

    /**
     * @description: 判断树是否为空
     * @author WuQiChuan
     * @date 2018/10/9 19:55
     * @param
     * @return boolean
     * @version: 1.0
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * @description: 向二分搜索树中添加元素，用户调用的方法
     * @author WuQiChuan
     * @date 2018/10/9 21:17
     * @param t
     * @return void
     * @version: 1.0
     */
    public void add(T t){
        root = add(root,t);
    }

    /**
     * @description: 内部调用的向二分搜索树中添加元素
     * 将元素T添加到一Node为根的接点上，具体解读参考笔记
     * @author WuQiChuan
     * @date 2018/10/9 21:18
     * @param node, t
     * @return tree.MyBinarySearchTree<T>.Node
     * @version: 1.0
     */
    private Node add(Node node,T t){
        //递归终止，当传入节点为空的时候，新建一个节点保存元素
        if(node == null){
            size++;
            return new Node(t);
        }
        //t小于Node，则添加到左子树
        if(t.compareTo(node.t) < 0){
            node.left = add(node.left,t);
        }
        //t大于Node，则添加到右子树
        if(t.compareTo(node.t) > 0){
            node.right = add(node.right,t);
        }
        return node;
    }

    /**
     * @description: 查找二分搜索树中是否含有元素t ,用户调用的方法
     * @author WuQiChuan
     * @date 2018/10/9 21:54
     * @param t
     * @return boolean
     * @version: 1.0
     */
    public boolean contains(T t){
        return contains(root,t);
    }

    /**
     * @description: 内部调用方法，在以node为根节点的是否含有元素t，有返回true，没有返回false
     * @author WuQiChuan
     * @date 2018/10/9 21:55
     * @param node, t
     * @return boolean
     * @version: 1.0
     */
    private boolean contains(Node node,T t){
        //当遍历到节点为空说明递归结束，说明没找到元素，返回false
        if(node == null){
            return false;
        }
        //如果t == node.t 说明找到了
        if(t.compareTo(node.t) == 0){
            return  true;
        }else if (t.compareTo(node.t) < 0){
            //如果t < node.t 说明待查找元素在左子树
            //则递归调用查找去左子树查找
            return contains(node.left,t);
        }else{
            //如果 t > node.t 说明待查找元素在右子树
            //则递归调用查找去右子树查找
            return contains(node.right,t);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    public void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.t);
        preOrder(node.left);
        preOrder(node.right);
    }
}
