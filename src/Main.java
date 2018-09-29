import Array.MyArray;
import stack.MyArryStack;

public class Main {


    public static void main(String[] args) {
        //动态数组
        MyArray myArray = new MyArray<String>(11);
        //栈
        MyArryStack<String> arryStack = new MyArryStack<String>();
        for (int i=10;i<20;i++){
            arryStack.push(i+"haha");
        }
        System.out.println(arryStack);
        arryStack.pop();
        String peek = arryStack.peek();
        System.out.println(peek);

    }

}
