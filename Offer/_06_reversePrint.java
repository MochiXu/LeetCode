package Offer;


public class _06_reversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode pointA=head;
        int listLength=0;
        while (pointA!=null){
            listLength++;
            pointA=pointA.next;
        }
        int[] arr=new int[listLength];
        for (int i=listLength-1;i>=0;i--){
            arr[i]=head.val;
            head=head.next;
        }

        return arr;
    }

}
