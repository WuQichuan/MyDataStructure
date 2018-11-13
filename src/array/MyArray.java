package array;

/**
 * @author WuQiChuan
 * @Description: 自我封装的数据结构：动态数组
 * @Date: Created in: 2018/9/20 21:42
 * @Version: 1.0
 */
public class MyArray<E> {

    //用来存放数据的数组
    private E[] data;
    //数组的大小
    private int size;

    /**
     * @description:有参数的构造函数，数组初始化为指定的长度capacity
     * @author WuQiChuan
     * @date 2018/9/20 21:48
     * @param capacity 数组的最大长度
     * @return
     * @version: 1.0
     */
    public MyArray(int capacity){
        data =  (E[])new Object[capacity];
        size = 0;
    }
    /**
     * @description:无参数的构造函数，数组默认最大长度设置为50
     * @author WuQiChuan
     * @date 2018/9/20 21:49
     * @param
     * @return
     * @version: 1.0
     */
    public MyArray(){
        this(50);
    }
    /**
     * @description:获取数组的元素个数
     * @author WuQiChuan
     * @date 2018/9/20 21:50
     * @param
     * @return int
     * @version: 1.0
     */
    public int getSize(){
        return this.size;
    }
    /**
     * @description:获取数组的容量
     * @author WuQiChuan
     * @date 2018/9/20 21:51
     * @param
     * @return int
     * @version: 1.0
     */
    public int getCapacity(){
        return this.data.length;
    }
    /**
     * @description: 两个参数的插入方法，将元素插入到index位置
     * @author WuQiChuan
     * @date 2018/9/20 22:04
     * @param index 元素插入的下标, e 需要插入的元素
     * @return void
     * @version: 1.0
     */
    public void add(int index,E e){
        //首先检查数组容量情况，如果已满，进行二倍扩容
        if(size == data.length){
           resize(2*data.length);
        }
        //检查参数合法性，是否为负数，是否大于了数组的大小
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. index < 0 || index > size"+"\n"+"添加失败，添加位置小于0或者大于数组大小");
        }
        //从后遍历，将待插入元素指定位置之后得元素全部后移一个位置
        for(int i = size - 1;i >= index; i--){
            //将数组元素向后一位赋值
            data[i+1] = data[i];
        }
        //将元素放置到指定位置
        data[index] = e;
        //数组大小+1
        size++;
    }

    /**
     * @description:重载方法，一个参数的插入方法。将指定元素插入数组末尾
     * @author WuQiChuan
     * @date 2018/9/20 22:14
     * @param e 指定的元素
     * @return void
     * @version: 1.0
     */
    public void add(E e){
        //调用指定插入下标的方法，插入位置为数组末尾
        add(size,e);
    }

    /**
     * @description:从数组中删除index位置的元素并返回该元素
     * @author WuQiChuan
     * @date 2018/9/20 23:03
     * @param index index索引位置
     * @return E 泛型
     * @version: 1.0
     */
    public E remove(int index){
        //检查参数合法性，是否为负数，是否大于了数组的大小
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. Index id illegal"+"\n"+"删除失败，参数不合法");
        }
        E ret = data[index];
        //将index位置之后得数组元素都向前移动1个位置
        for(int i = index +1; i<size;i++){
            //将数组元素后一位覆盖前一位
            data[i - 1] = data[i];
        }
        size --;
        //手动清掉loitering obiects
        data[size] = null;
        //如果数组大小不足内数组总长度四分之一，则将数组容量缩减为原来一半
        //懒式缩容，给与预留空间，放置复杂度震荡
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * @description:移除数组的最后一个元素并返回该元素
     * @author WuQiChuan
     * @date 2018/9/29 19:26
     * @param
     * @return E
     * @version: 1.0
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * @description:移除数组第一个元素并返回该元素
     * @author WuQiChuan
     * @date 2018/9/29 21:32
     * @param
     * @return E
     * @version: 1.0
     */
    public E removeFirst(){
        return remove(  0);
    }

    /**
     * @description:获取数组最后一个元素
     * @author WuQiChuan
     * @date 2018/9/29 19:29
     * @param
     * @return E
     * @version: 1.0
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * @description:获得数组第一个元素
     * @author WuQiChuan
     * @date 2018/9/29 19:30
     * @param
     * @return E
     * @version: 1.0
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * @description:从数组中删除元素e,删除成功返回true，删除失败返回false
     * @author WuQiChuan
     * @date 2018/9/20 23:09
     * @param e 待删除的元素e
     * @return boolean
     * @version: 1.0
     */
    public boolean removeElement(E e){
        //查找数组中是否含有元素e
        int index = find(e);
        //返回Index索引不为-1说明含有元素e，进行删除
        if(index != -1){
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * @description:改变数组index位置的元素
     * @author WuQiChuan
     * @date 2018/9/20 22:33
     * @param index 指定的下标, e 元素
     * @return void
     * @version: 1.0
     */
    public void set(int index,E e){
        //检查参数合法性，是否为负数，是否大于了数组的大小
        if(index < 0 || index > size){
            throw new IllegalArgumentException("MySet failed. index < 0 || index > size"+"\n"+"Set失败，添加位置小于0或者大于数组大小");
        }
        //覆盖指定位置的元素
        data[index] = e;
    }

    /**
     * @description:获取index索引位置的元素
     * @author WuQiChuan
     * @date 2018/9/20 22:40
     * @param index index索引
     * @return E 泛型
     * @version: 1.0
     */
    public E get(int index){
        //检查参数合法性，是否为负数，是否大于了数组的大小
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. Index id illegal"+"\n"+"获取数组元素失败，参数不合法");
        }
        return data[index];
    }
    /**
     * @description:判断数组是否为空，true说明为空，false说明数组有元素
     * @author WuQiChuan
     * @date 2018/9/20 22:42
     * @param
     * @return boolean
     * @version: 1.0
     */
    public boolean isEmpty(){
        //size == 0 说明数组为空
        return size == 0;
    }

    /**
     * @description:查找数组是否含有元素e，如果有返回true，如果没有返回false
     * @author WuQiChuan
     * @date 2018/9/20 22:44
     * @param e 查找的元素
     * @return boolean
     * @version: 1.0
     */
    public boolean contains(E e){
        for(int i = 0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * @description:查找数组元素e所在的索引，如果存在则返回对应的索引，如果不存在则返回-1
     * @author WuQiChuan
     * @date 2018/9/20 22:47
     * @param e 查找的元素
     * @return int
     * @version: 1.0
     */
    public int find(E e){
        for(int i = 0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * @description: 改变数组容量方法，创建新的数组，指定新的容量，将旧数组复制到新数组中并本类旧数组指向新数组
     * @author WuQiChuan
     * @date 2018/9/27 21:37
     * @param newCapacity 新数组的容量
     * @return void
     * @version: 1.0
     */
    private void resize(int newCapacity){
        //创建一个新的数组
        E[] newData = (E[]) new Object[newCapacity];
        //将旧数组内容复制到新数组中
        for (int i = 0; i < size ;i++){
            newData[i] = data[i];
        }
        //将本类的数组指向新数组，完成数组容量变更
        data = newData;
    }


    /**
     * @description:重写toString
     * @author WuQiChuan
     * @date 2018/9/20 22:32
     * @param
     * @return java.lang.String
     * @version: 1.0
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Arry : size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        //遍历存储数据的数组并拼接内容
        for(int i = 0; i < size;i++){
            res.append(data[i]);
            if(i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }


}
