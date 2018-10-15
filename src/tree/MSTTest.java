package tree;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: Created in:2018/10/11 19:27
 * @Version: 1.0
 */
public class MSTTest {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> myBinarySearchTree = new MyBinarySearchTree<>();
        int[] nums = {5,3,6,8,4,2};
        for (int i:nums) {
            myBinarySearchTree.add(i);
        }
        //         5
        //       /   \
        //      3     6
        //     / \     \
        //    2   4     8
        System.out.println("先序遍历：");
        myBinarySearchTree.preOrder();
        System.out.println("中序遍历：");
        myBinarySearchTree.inOrder();
        System.out.println("后序遍历：");
        myBinarySearchTree.postOrder();
        System.out.println("层序遍历：");
        myBinarySearchTree.levelOrder();
    }
}
