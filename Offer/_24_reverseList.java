package Offer;
/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 思路：挨个的调整链表指针就行，空间复杂度肯定是O(1)，时间复杂度n，自己能够想得出来的比较好的方案了
 * */
public class _24_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode curPre=null;
        ListNode curNode=head;
        while (curNode!=null){
            ListNode originNext=curNode.next;
            curNode.next=curPre;
            curPre=curNode;
            curNode=originNext;
        }
        return curPre;
    }
}
