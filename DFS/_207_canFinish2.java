package DFS;
/**
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 思路：之前的过程没有理解到所有课程的数目和对应课程之间的依赖关系
 * 课程号相当于数组下标
 * 如果不是需要完整的输出拓扑排序的节点，那么其实也不需要使用Stack进行节点的存储[Stack在每次dfs完毕，回溯的时候存储节点]
 */
public class _207_canFinish2 {
    Boolean failure=false;//默认Stack DFS的过程中没有遇到已经访问过的节点
    int []visited;//设置标记访问状态，-1未访问，0正在访问，1已经访问
    int [][]preCourses;
    int length=0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        length=prerequisites.length;
        if (length==0)
            return true;
        //初始化访问状态
        visited=new int[numCourses];
        for (int i=0;i<numCourses;i++){
            visited[i]=-1;
        }
        //将prerequisites设置为全局变量，减少dfs内存消耗
        preCourses=prerequisites;
        //dfs访问过程
        for(int i=0;i<numCourses;i++){
            if (visited[i]==-1){
                dfs(i);
            }
        }
        return !failure;
    }
    public void dfs(int course){
        if (visited[course]==-1){
            //该节点未访问，则更新访问位，并进行邻接点的dfs
            visited[course]=0;
            for (int i = 0;i<length;i++){
                if(preCourses[i][1]==course){
                    dfs(preCourses[i][0]);
                }
            }
            //dfs访问完毕后，将回溯到该节点，更新访问位
            visited[course]=1;
        }
        if(visited[course]==0){
            //出现环路，则更新失败标记
            failure=true;
        }
    }
}
