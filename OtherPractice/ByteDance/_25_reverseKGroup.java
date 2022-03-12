package OtherPractice.ByteDance;
/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *<br/>
 * 思路：对链表进行分段原地反转
 * */
public class _25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //设置一个头节点，不存储数据
        ListNode myHead=new ListNode();
        myHead.next=head;
        //设置当前节点curNode
        ListNode curNode=head;
        //定义需要反转的区间，闭区间
        ListNode start=null,end=null;
        //定义反转区间的pre
        ListNode intervalPre=myHead;
        int count=1;
        while (curNode!=null){
            //count=1说明遇到的是第一个需要反转的节点
            if (count==1){
                start=curNode;
            }
            //count=k说明遇到的是最后一个需要反转的节点
            if (count==k){
                end=curNode;
                //反转区间的下一个节点
                ListNode intervalNext=end.next;
                //反转逻辑
                this.reverseInner(start,end);
                intervalPre.next=end;
                start.next=intervalNext;
                intervalPre=start;
                //更新下一次循环
                count=0;
                curNode=intervalNext;//区间反转完毕，则next为区间的下一个节点
            }else {
                curNode=curNode.next;//区间未反转完毕，则next为cur的下一个节点
            }
            count++;
        }
        return myHead.next;
    }
    public void reverseInner(ListNode start,ListNode end){
        //原地反转单链表的逻辑
        ListNode cur=start.next;
        ListNode pre=start;
        while (pre!=end){
            ListNode originNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=originNext;
        }
    }
    public static void main(String args[]){
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        _25_reverseKGroup reverseKGroup=new _25_reverseKGroup();
        System.out.println(reverseKGroup.reverseKGroup(node,2));

    }
}
