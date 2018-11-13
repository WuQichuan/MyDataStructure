package linkedlist;

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
        myLinkedList.remove(2);
        System.out.println(myLinkedList);
        myLinkedList.removeFirst();
        System.out.println(myLinkedList);
        myLinkedList.removeLast();
        System.out.println(myLinkedList);

    }
}
