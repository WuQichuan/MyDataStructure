package maxheap;

import array.MyArray;

/**
 * @author WuQiChuan
 * @Description: 最大堆----使用数组实现
 * @Date: 2018/11/14 21:35
 * @Version: 1.0
 */
public class MaxHeap <T extends Comparable<T>>{
    private MyArray<T> data;
    public MaxHeap(int capacity){
        data = new MyArray<>(capacity);
    }

    public MaxHeap(){
        data = new MyArray<>();
    }

    /**
     * @description 对于给定数组，变成用数组表示的最大堆
     * @author WuQiChuan
     * @param: [arr]
     * @return:
     * @date: 2018/11/15 9:41
     * @version: 1.0
     */
    public MaxHeap(T arr[]){
        data = new MyArray<>(arr);
        //找到最后几点的父亲节点，依次向前执行下沉操作就可以调整出最大堆
        for(int i = parent(arr.length - 1);i>=0;i--){
            siftDown(i);
        }
    }
    /**
     * @description 获取堆中元素个数
     * @author WuQiChuan
     * @param:
     * @return: int
     * @date: 2018/11/14 21:38
     * @version: 1.0
     */
    public int size(){
        return data.getSize();
    }

    /**
     * @description 判断是否为空
     * @author WuQiChuan
     * @param:
     * @return: boolean
     * @date: 2018/11/14 21:39
     * @version: 1.0
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * @description 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @author WuQiChuan
     * @param: index
     * @return: int
     * @date: 2018/11/14 21:42
     * @version: 1.0
     */
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("0索引位置没有父节点");
        }
        return (index - 1) / 2;
    }

    /**
     * @description 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
     * @author WuQiChuan
     * @param: [index]
     * @return: int
     * @date: 2018/11/14 21:45
     * @version: 1.0
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * @description 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
     * @author WuQiChuan
     * @param: [index]
     * @return: int
     * @date: 2018/11/14 21:45
     * @version: 1.0
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * @description 向堆中添加元素
     * @author WuQiChuan
     * @param: [t]
     * @return: void
     * @date: 2018/11/14 21:54
     * @version: 1.0
     */
    public void add(T t){
        data.add(t);
        siftUp(data.getSize() - 1);
    }

    /**
     * @description 元素上浮，调整新加入的元素位置使其满足最大堆性质
     * @author WuQiChuan
     * @param: [k]
     * @return: void
     * @date: 2018/11/14 21:54
     * @version: 1.0
     */
    private void siftUp(int k){
        //如果索引位置>0，并且该索引位置的父节点元素比该索引位置节点元素小的话则进入循环
        while(k>0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            //将该节点元素和其父亲节点交换
            data.swap(k,parent(k));
            //索引标记K上移
            k = parent(k);
        }
    }

    /**
     * @description 查看堆中最大元素
     * @author WuQiChuan
     * @param:
     * @return: T
     * @date: 2018/11/14 22:06
     * @version: 1.0
     */
    public T findMax(){
        if(data.getSize() == 0){
            throw  new IllegalArgumentException("堆中没有元素");
        }
        return data.get(0);
    }

    public T extractMax(){
        T ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * @description 元素下沉，调整新变动的元素位置使其满足最大堆的性质
     * @author WuQiChuan
     * @param: [k]
     * @return: void
     * @date: 2018/11/15 9:27
     * @version: 1.0
     */
    private void siftDown(int k){
        //判断左孩子是否越界，越界说明该节点到最后了
        while(leftChild(k) < data.getSize()){
            //获取左孩子索引位置
            int j = leftChild(k);
            //判断是是否存在右孩子，和右孩子是否大于左孩子
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                //说明右孩子大于左孩子，则j 保存右孩子位置的索引
                j = rightChild(k);
            }
            //经过上面的代码，data[j]变为该节点左右孩子的最大值、

            //如果该节点元素大于其左右孩子则结束循环
            if(data.get(k).compareTo(data.get(j)) >= 0 ){
                break;
            }
            //说明该节点小于其左后孩子其中的最大值，则将该节点和左右孩子中的最大值交换
            data.swap(k,j);
            //k 下沉
            k = j;
        }
    }

    /**
     * @description 取出堆中最大元素，并替换成新的元素t
     * @author WuQiChuan
     * @param: [t]
     * @return: T
     * @date: 2018/11/15 9:30
     * @version: 1.0
     */
    public T replace(T t){
        //取出堆定元素用于返回
        T ret = findMax();
        //替换堆顶部元素
        data.set(0,t);
        //堆顶元素下沉调整位置
        siftDown(0);
        return ret;
    }

}
