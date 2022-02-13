package Linked_list;
/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 思路：感觉本质就是一个加法运算
 *      A和B相加，个位数放在新生成的C节点上，如果有十位数（不可能存在百位数），那就将十位数和A和B一起相加，继续这样操作就行
 * */
public class _2_addTwoNumbers {
    public int dec_number=0;//设置十位数为0
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //题目中说明了链表中节点都是大于等于1的，所以不用边界判断了

        ListNode l3=new ListNode(-1);//l3作为头节点
        ListNode cur=l3;
        //处理公共部分
        while (l1!=null&&l2!=null){
            int sum= l1.val+l2.val+dec_number;
            dec_number=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int sum= l1.val+dec_number;
            dec_number=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            l1=l1.next;
        }
        while (l2!=null){
            int sum= l2.val+dec_number;
            dec_number=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;
            l2=l2.next;
        }
        if (dec_number!=0){
            cur.next=new ListNode(dec_number);
        }
        return l3.next;
    }
}
