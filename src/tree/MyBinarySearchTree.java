package tree;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * @description: 先序遍历，给外部调用的
     * @author WuQiChuan
     * @date 2018/10/11 19:21
     * @param
     * @return void
     * @version: 1.0
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * @description: 先序遍历（递归），内部调用，先序遍历以Node为根的二分搜索树
     * @author WuQiChuan
     * @date 2018/10/11 19:21
     * @param node
     * @return void
     * @version: 1.0
     */
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.t);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * @description: 中序遍历，给外部调用的
     * @author WuQiChuan
     * @date 2018/10/11 19:25
     * @param
     * @return void
     * @version: 1.0
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * @description: 中序遍历（递归），内部调用，中序遍历以Node为根的二分搜索树
     * @author WuQiChuan
     * @date 2018/10/11 19:26
     * @param node
     * @return void
     * @version: 1.0
     */
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.t);
        inOrder(node.right);
    }

    /**
     * @description: 后序遍历，给外部调用的
     * @author WuQiChuan
     * @date 2018/10/11 19:36
     * @param
     * @return void
     * @version: 1.0
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * @description: 后序遍历（递归），内部调用，后序遍历以Node为根的二分搜索树
     * @author WuQiChuan
     * @date 2018/10/11 19:36
     * @param node
     * @return void
     * @version: 1.0
     */
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.t);
    }

    /**
     * @description: 二分搜索树层序遍历 ，广度优先算法
     * @author WuQiChuan
     * @date 2018/10/15 19:58
     * @param
     * @return void
     * @version: 1.0
     */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.t);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right !=null){
                queue.offer(cur.right);
            }
        }
    }

    /**
     * @description: 返回二分搜索树最小元素，给外部调用
     * @author WuQiChuan
     * @date 2018/10/15 20:07
     * @param
     * @return T
     * @version: 1.0
     */
    public T minInum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is Empty");
        }

        return minInum(root);
    }

    /**
     * @description: 返回当前节点下的最小元素，递归方法
     * @author WuQiChuan
     * @date 2018/10/15 20:07
     * @param node
     * @return T
     * @version: 1.0
     */
    private T minInum(Node node){
        //递归结束条件，左子树为空，返回当前节点元素
        if(node.left == null){
            return node.t;
        }
        //否则递归去左子树寻找
        return minInum(node.left);
    }

    /**
     * @description: 返回二分搜索树最大元素，给外部调用
     * @author WuQiChuan
     * @date 2018/10/15 20:07
     * @param
     * @return T
     * @version: 1.0
     */
    public T maxInum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is Empty");
        }
        return maxInum(root);
    }

    /**
     * @description: 返回当前节点下的的最大元素，递归方法
     * @author WuQiChuan
     * @date 2018/10/15 20:07
     * @param node
     * @return T
     * @version: 1.0
     */
    private T maxInum(Node node){
        //递归结束条件，左子树为空，返回当前节点元素
        if(node.right == null){
            return node.t;
        }
        //否则递归去左子树寻找
        return maxInum(node.right);
    }

    /**
     * @description: 删除二分搜索树的最小元素
     * @author WuQiChuan
     * @date 2018/10/15 20:41
     * @param
     * @return T
     * @version: 1.0
     */
    public T removeMin(){
        T ret = minInum();
        root = removeMin(root);
        return ret;
    }

    /**
     * @description: 递归删除当前节点下的最小元素
     *
     *       4          4
     *     /          /
     *    3          3
     *   /          /
     *  1         2
     *   \
     *    2
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

    /**
     * @description: 删除二分搜索树的最大元素
     * @author WuQiChuan
     * @date 2018/10/15 20:41
     * @param
     * @return T
     * @version: 1.0
     */
    public T removeMax(){
        T ret = minInum();
        root = removeMax(root);
        return ret;
    }

    /**
     * @description: 递归删除当前节点下的最大元素
     * @author WuQiChuan
     * @date 2018/10/15 21:45
     * @param node
     * @return tree.MyBinarySearchTree<T>.Node
     * @version: 1.0
     */
    private Node removeMax(Node node){
        //递归结束条件，左子树为空说明当前节点为最小
        if(node.right == null){
            //把最小节点的右子树保存
            Node leftChild = node.left;
            node.left = null;
            size--;
            //返回最小节点的右子树
            return leftChild;
        }
        //最小节点的上一个节点的左子树连接到最小节点的右子树上

        node.right = removeMax(node.right);
        return node;
    }
}
