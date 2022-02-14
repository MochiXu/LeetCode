package DFS;
import DFS.Nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 注意这类题，一般都有那种递归的思想，可以通过这个函数的参数和返回值的类型观察出来
 * 不是说用了dfs就是好的递归了，好的递归是同时结合dfs的
 * 这个思路参考了官方题解，注意在刚克隆节点之后，就得把它加到map里面
 * */
public class _133_cloneGraph2 {
    //使用HashMap存储未克隆-->克隆
    private HashMap<Node,Node> hashMap=new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node==null)return null;
        //如果hashMap中已经存储了这个node，那么直接返回这个node的克隆
        if (hashMap.containsKey(node))
            return hashMap.get(node);
        //在hashMap没有存储这个node的时候，进行克隆，并且设置邻接关系
        Node cloneNode=new Node(node.val,new ArrayList<>());
        for (int i=0;i<node.neighbors.size();i++){
            cloneNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }
        hashMap.put(node,cloneNode);
        return cloneNode;
    }
}
