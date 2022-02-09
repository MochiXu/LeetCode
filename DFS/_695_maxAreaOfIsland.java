package DFS;
/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 思路：使用常规的DFS进行遍历即可，利用全局变量记录每次遍历过程中的岛屿面积，并更新最大面积
 * */
public class _695_maxAreaOfIsland {
    int[][] visited=null;//DFS访问状态数组，-1未访问，1访问过
    int current_area=0;
    int max_area=Integer.MIN_VALUE;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        visited=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                visited[i][j]=-1;
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (visited[i][j]==-1&&grid[i][j]==1){
                    dfs(grid,m,n,i,j);
                    if(current_area>max_area) max_area=current_area;
                    current_area=0;
                }
            }
        }
        if (max_area==Integer.MIN_VALUE)
            return 0;
        return max_area;
    }

    public void dfs(int[][] grid,int m, int n,int row, int column){
        if (row>=0&&row<m&&column>=0&&column<n&&visited[row][column]==-1&&grid[row][column]==1){
            visited[row][column]=1;
            current_area++;
            //➡️
            if (column+1<n){
                dfs(grid,m,n,row,column+1);
            }
            //⬅️
            if (column-1>=0){
                dfs(grid,m,n,row,column-1);
            }
            //⬆️
            if (row+1<m){
                dfs(grid,m,n,row+1,column);
            }
            //⬇️
            if (row-1>=0){
                dfs(grid,m,n,row-1,column);
            }
        }
    }

}
