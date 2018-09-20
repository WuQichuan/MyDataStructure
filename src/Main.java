import Array.MyArray;

public class Main {


    public static void main(String[] args) {
        MyArray myArray = new MyArray<String>(11);
        for (int i=10;i<20;i++){
            myArray.add(i);
        }
        System.out.println(myArray);
        myArray.add(1,"哈哈哈哈");
        System.out.println("-------------------");
        System.out.println(myArray);
        myArray.set(2,"henke");
        System.out.println("-------------------");
        System.out.println(myArray);
    }

}
