package Offer;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 思路：尝试使用图的深拷贝使用到的思路
 * */
public class _35_copyRandomList {
    //map中存储未拷贝和拷贝的节点
    private HashMap<Node,Node> hashMap=new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head==null)return null;
        if (hashMap.containsKey(head)){
            return hashMap.get(head);
        }
        Node node=new Node(head.val);
        hashMap.put(head,node);
        node.next=copyRandomList(head.next);
        node.random=copyRandomList(head.random);

        return node;
    }

}
