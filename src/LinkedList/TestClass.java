package LinkedList;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: Created in:2018/10/6 16:28
 * @Version: 1.0
 */
public class TestClass {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for(int i = 0;i<5;i++){
            myLinkedList.addFirst(i);
            System.out.println(myLinkedList);
        }
        myLinkedList.add(2,666);
        System.out.println(myLinkedList);
    }
}
