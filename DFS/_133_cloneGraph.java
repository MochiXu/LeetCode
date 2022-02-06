package DFS;
import DFS.Nodes.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * */
public class _133_cloneGraph {
    private Boolean[] visited=new Boolean[100];//默认值是false
    private HashMap<Integer,Node> hashMap=new HashMap<>();
    public Node cloneGraph(Node node) {
        //边界处理
        if(node==null)return null;

        for (int i=0;i<100;i++){
            visited[i]=false;
        }
        dfs(node);
        for (int i=0;i<100;i++){
            visited[i]=false;
        }
        //设置连接关系
        dfs2(node);
        return hashMap.get(node.val);
    }
    public void dfs(Node node){
        //若访问过了，则直接return
        if (visited[node.val])return;
        //若未访问，则设置访问标志，并进行复制，复制后放入HashMap并等待后续设置节点之间的连接关系
        visited[node.val]=true;
        Node newNode=new Node();
        newNode.val= node.val;
        hashMap.put(newNode.val,newNode);
        //dfs寻找其他节点
        List<Node> neighbors=node.neighbors;
        for (Node nodeNeighbor : neighbors){
            dfs(nodeNeighbor);
        }
    }

    public void dfs2(Node node){
        //如果访问过了，则直接return
        if (visited[node.val])return;
        //若未访问，则设置访问标志，并进行复制，复制后放入HashMap并等待后续设置节点之间的连接关系
        visited[node.val]=true;
        //设置连接关系
        List<Node> neighbors=node.neighbors;
        List<Node> temp_neighbors=new ArrayList<>();
        for (Node nodeNeighbor : neighbors){
            temp_neighbors.add(hashMap.get(nodeNeighbor.val));
        }
        hashMap.get(node.val).neighbors=temp_neighbors;

        //dfs寻找其他节点
        for (Node nodeNeighbor : neighbors){
            dfs2(nodeNeighbor);
        }
    }
    public static void main(String args[]){
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        List<Node>list1=new ArrayList<>();
        list1.add(node2);
        list1.add(node4);
        List<Node>list2=new ArrayList<>();
        list2.add(node1);
        list2.add(node3);
        List<Node>list3=new ArrayList<>();
        list3.add(node2);
        list3.add(node4);
        List<Node>list4=new ArrayList<>();
        list4.add(node1);
        list4.add(node3);
        node1.neighbors=list1;
        node2.neighbors=list2;
        node3.neighbors=list3;
        node4.neighbors=list4;


        _133_cloneGraph cloneGraph=new _133_cloneGraph();
        System.out.println(cloneGraph.cloneGraph(node1));
    }
}
