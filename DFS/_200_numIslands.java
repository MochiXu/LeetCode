package DFS;

public class _200_numIslands {
    int [][]mark;//-1表示未检测
    int num=0;
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        mark=new int[m][n];
        //初始化岛屿标记
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                mark[i][j]=-1;
            }
        }

        for(int row=0;row<m;row++){
            for (int column=0;column<n;column++){
                int mark1=mark[row][column];
                dfs(row,column,m,n,grid);
                int mark2=mark[row][column];
                if (mark1!=mark2)num++;
            }
        }
        return num;
    }
    public void dfs(int row,int column,int m,int n,char[][] grid){
        if(row>=0&&row<m&&column>=0&&column<n&&grid[row][column]=='1'&&mark[row][column]==-1){
            //访问逻辑
            mark[row][column]=1;//已经访问

            //⬅️
            if(column-1>=0){
                dfs(row,column-1,m,n,grid);
            }
            //➡️
            if(column+1<n){
                dfs(row,column+1,m,n,grid);
            }
            //⬆️
            if(row-1>=0){
                dfs(row-1,column,m,n,grid);
            }
            //⬇️
            if(row+1<m){
                dfs(row+1,column,m,n,grid);
            }
        }
    }

    public static void main(String args[]){
        char[][] grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        _200_numIslands numIslands=new _200_numIslands();
        System.out.println(numIslands.numIslands(grid));
    }
}
