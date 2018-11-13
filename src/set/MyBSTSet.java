package set;

import tree.MyBinarySearchTree;

/**
 * @author WuQiChuan
 * @Description: 基于二分搜索树实现的Set集合
 * @Date: 2018/11/12 14:38
 * @Version: 1.0
 */
public class MyBSTSet<T extends Comparable<T>> implements MySet<T>{
    private MyBinarySearchTree<T> bst;
    public MyBSTSet(){
        bst = new MyBinarySearchTree<T>();
    }
    @Override
    public void add(T t) {
        bst.add(t);
    }

    @Override
    public void remove(T t) {
        bst.remove(t);
    }

    @Override
    public boolean contains(T t) {
        return bst.contains(t);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
