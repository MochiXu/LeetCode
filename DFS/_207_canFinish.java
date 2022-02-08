package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class _207_canFinish {
    public HashMap<Integer, Integer> courseStatus=new HashMap<>();//-1未访问过，0正在访问，1已经访问完毕
    public LinkedList<Integer> stack = null;
    int length = 0;
    int failure = -1;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        length = prerequisites.length;
        if (length == 0) return true;

        //初始化 课程状态
        for (int i = 0; i < length; i++) {
            if (!courseStatus.containsKey(prerequisites[i][0])) courseStatus.put(prerequisites[i][0], -1);
            if (!courseStatus.containsKey(prerequisites[i][1])) courseStatus.put(prerequisites[i][1], -1);
        }
        //初始化 stack
        stack = new LinkedList<>();

        //深度优先搜索
        LinkedList<Integer> keys = new LinkedList<>();
        for (int key : courseStatus.keySet()) {
            keys.add(key);
        }
        while (keys.size()!=0) {
            int key=keys.pollFirst();
            if(courseStatus.get(key)==-1)
                dfs(key,prerequisites);
        }
        //返回
        if (failure==1)return false;
        if (stack.size()>numCourses)return false;
        else return true;


    }

    //A-->B 选修A之前需要选修B  B-->A
    public void dfs(int course, int[][] prerequisites) {
        if (courseStatus.get(course) == -1) {
            //未访问过
            courseStatus.put(course, 0);
            for (int i = 0; i < length; i++) {
                if (prerequisites[i][0] == course) {
                    //深度优先搜索邻接点
                    dfs(prerequisites[i][1], prerequisites);
                }
            }
            //深度优先搜索完毕之后，相当于回溯到了此节点，那么入栈并标记状态
            stack.add(course);
            courseStatus.put(course, 1);
        } else if (courseStatus.get(course) == 0) {
            //正在访问
            failure = 1;
        } else if (courseStatus.get(course) == 1) {
            //访问过了
            //~~
        }
    }
}
