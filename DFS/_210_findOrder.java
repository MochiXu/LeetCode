package DFS;

import java.util.LinkedList;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，
 * 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *思路：流程和上一次的"207课程表"基本无差，只是需要使用栈存储一下拓扑排序的顺序，另外就是尝试优化一下DFS的内存消耗（其实按照题解的写法和207—2的写法查不了多少，个人感觉，有待验证）
 * */
public class _210_findOrder {
    int length=0;
    int[] visited=null;//-1表示未访问，0表示正在访问，1表示访问完成
    int[][] preCourse=null;//课程之间的依赖关系
    Boolean success=true;
    LinkedList<Integer> Stack=new LinkedList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        length=prerequisites.length;
        int[] seqArr ;

        visited=new int[numCourses];
        //标记课程访问状态
        for (int i=0;i<numCourses;i++){
            visited[i]=-1;
        }
        //更新课程之间的依赖关系
        preCourse=prerequisites;
        //进行dfs
        for (int i=0;i<numCourses;i++){
            if(visited[i]==-1)
                dfs(i);
        }
        if (success){
            seqArr=new int[numCourses];
            for (int i=0;i<numCourses;i++){
                seqArr[i]=Stack.pollLast();
            }
            return seqArr;
        }else{
            seqArr=new int[0];
            return seqArr;
        }
    }
    public void dfs(int course){
        if (visited[course]==-1){
            //未访问过，则进行访问
            visited[course]=0;
            for (int i=0;i<length;i++){
                if (preCourse[i][1]==course){
                    dfs(preCourse[i][0]);
                }
            }
            //回溯位置
            visited[course]=1;
            Stack.addLast(course);
        }else if(visited[course]==0){
            //正在访问，则更新失败状态

            success=false;
        }
    }
}
