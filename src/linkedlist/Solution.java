package linkedlist;

/**
 *
 * LeetCodeCode 第203号问题
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }

        //递归调用
        ListNode res = removeElements(head.next,val);
        if(head.val == val){
            return res;
        }else{
            head.next = res;
            return head;
        }

    }
}
