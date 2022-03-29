package Linked_list;

public class _206_reverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode left=null;
        ListNode mid=head;
        ListNode right=head.next;
        while (mid!=null){
            //调整节点的关系
            mid.next=left;
            left=mid;
            mid=right;
            if (right!=null)right=right.next;
        }
        return left;
    }
}
