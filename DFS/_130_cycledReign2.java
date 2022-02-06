package DFS;

//思路，入口是最外侧的O，使用dfs进行搜索标记
public class _130_cycledReign2 {
    int [][]board_flag;
    public void solve(char[][] board) {
        //获取行与列
        int m=board.length;
        int n=board[0].length;
        //标记初始化
        board_flag=new int[m][n];
        //访问最外层所有的'O'
         for (int row=0;row<m;row++){
             if(board_flag[row][0]!=-1&&board[row][0]=='O')
                 dfs(row,0,m,n,board);
             if(n-1!=0&&board_flag[row][n-1]!=-1&&board[row][n-1]=='O')
                 dfs(row,n-1,m,n,board);
         }
        for (int column=0;column<n;column++){
            if(board_flag[0][column]!=-1&&board[0][column]=='O')
                dfs(0,column,m,n,board);
            if(m-1!=0&&board_flag[m-1][column]!=-1&&board[m-1][column]=='O')
                dfs(m-1,column,m,n,board);
        }
        //将所有的符合条件的O变成X
        for (int row=0;row<m;row++){
            for (int column=0;column<n;column++){
                if(board[row][column]=='O'&&board_flag[row][column]!=-1)
                    board[row][column]='X';
            }
        }
    }

    public void dfs(int row,int column,int m,int n,char[][] board){
        if(row>=0&&row<m&&column>=0&&column<n&&board[row][column]=='O'&&board_flag[row][column]==0){
            //进行标记
            board_flag[row][column]=-1;
            //往上⬆️
            if(row-1>=0){
                dfs(row-1,column,m,n,board);
            }
            //往下⬇️
            if(row+1<m){
                dfs(row+1,column,m,n,board);
            }
            //往左⬅️
            if(column-1>=0){
                dfs(row,column-1,m,n,board);
            }
            //往右➡️
            if(column+1<n){
                dfs(row,column+1,m,n,board);
            }
        }
    }
    public static void main(String args[]){
        char [][]board={{'O','O'},{'O','O'}};
        _130_cycledReign2 reign2=new _130_cycledReign2();
        reign2.solve(board);
    }
}
