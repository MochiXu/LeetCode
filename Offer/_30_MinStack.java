package Offer;
/***
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 */

public class _30_MinStack {
    public int[] stackArray=null;
    public int[] stackMinArray=null;
    int topIndex=0;
    int stackSize=0;

    public _30_MinStack() {
        stackArray=new int[2000];
        stackMinArray=new int[2000];
        for (int i=0 ;i<2000;i++){
            stackMinArray[i]=9999;
        }
    }

    public void push(int x) {
        if (stackSize!=0)
            stackMinArray[topIndex]= Math.min(stackMinArray[topIndex-1], x);
        else stackMinArray[topIndex]=x;
        stackSize++;
        stackArray[topIndex++]=x;
    }

    public void pop() {
        if (stackSize==0)return;
        stackMinArray[topIndex-1]=9999;
        stackSize--;
        topIndex--;
    }

    public int top() {
        if (stackSize==0)return -1;
        return stackArray[topIndex-1];
    }

    public int min() {
        if (stackSize==0)return -1;
        return stackMinArray[topIndex-1];
    }

    public static void main(String argsp[]){
        _30_MinStack minStack=new _30_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
