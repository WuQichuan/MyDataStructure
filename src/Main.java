import Array.MyArray;

public class Main {


    public static void main(String[] args) {
        MyArray myArray = new MyArray<String>(11);
        for (int i=10;i<60;i++){
            myArray.add(i);
        }
        System.out.println(myArray);
        for (int i=10;i<20;i++){
            myArray.remove(i);
        }
        System.out.println(myArray);

    }

}
