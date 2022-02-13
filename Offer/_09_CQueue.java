package Offer;

import java.util.LinkedList;

//用两个栈实现队列
public class _09_CQueue {
    LinkedList<Integer> stack1=null;
    LinkedList<Integer> stack2=null;
    public _09_CQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (stack2.size()==0&&stack1.size()==0)
            return -1;
        if (stack2.size()==0){
            //将stack1转移到stack2
            while (stack1.size()!=0){
                stack2.addLast(stack1.pollLast());
            }
        }
        return stack2.pollLast();
    }
}
