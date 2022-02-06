package DFS;
/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 思路：依次扫描（除最外层）所有的元素，判断O元素是否能够越界，不能越界则可被填充
 * */
public class _130_cycledReign {
    //设置是否访问过的标志
    //0表示未被访问，-1表示不可被更改，1表示可以被更改，2表示此次dfs正在访问
    int[][] board_b;
    Boolean flag=true;

    public void solve(char[][] board) {
        int m=board.length;//二维数组的行
        int n=board[0].length;//二维数组的列

        if (m==1||n==1)return;

        board_b=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                board_b[i][j]=0;
            }
        }
        for (int row=1;row<m-1;row++){
            for (int column=1;column<n-1;column++){

                if(board[row][column]=='O'&&board_b[row][column]==0){
                    //判断此O是否能够逃逸
                    dfs(row,column,m,n,board);
                    update(m,n);
                }
            }
        }
        for (int row=1;row<m-1;row++){
            for (int column=1;column<n-1;column++){

                if(board_b[row][column]==1){
                    board[row][column]='X';
                }
            }
        }
    }
    public void dfs(int row,int column,int m,int n,char[][] board){
        //board[row][column]节点已经被访问，则设置访问标志✅
        if(board_b[row][column]!=0)return;
        board_b[row][column]=2;
        if(column+1<n&&board[row][column+1]=='O'){
            //朝右走一步==>>
            if (column+1!=n-1){
                //没有达到边界，则可以继续dfs
                dfs(row,column+1,m,n,board);
            }else
            //达到了边界，说明此次dfs遍历到的所有节点都不能够被转换
            flag=false;
        }
        if(column-1>=0&&board[row][column-1]=='O'){
            //朝左走一步<<==
            if (column-1!=0){
                //没有达到边界，则可以继续dfs
                dfs(row,column-1,m,n,board);
            }else
            //达到了边界，说明此次dfs遍历到的所有节点都不能够被转换
            flag=false;
        }

        if(row-1>=0&&board[row-1][column]=='O'){
            //朝上侧走一步⬆️
            if (row-1!=0){
                //没有达到边界，则可以继续dfs
                dfs(row-1,column,m,n,board);

            }else
            //达到了边界，说明此次dfs遍历到的所有节点都不能够被转换
            flag=false;
        }

        if(row+1<m&&board[row+1][column]=='O'){
            //朝下侧走一步⬇️
            if (row+1!=m-1){
                //没有达到边界，则可以继续dfs
                dfs(row+1,column,m,n,board);
            }else
            //达到了边界，说明此次dfs遍历到的所有节点都不能够被转换
            flag=false;
        }


    }
    public void update(int m,int n){

        //每次dfs之后更新标志位
        for (int row=1;row<m-1;row++){
            for (int column=1;column<n-1;column++){
                if (board_b[row][column] == 2) {
                    board_b[row][column]=flag==true?1:-1;
                }
            }
        }
        //flag更改
        flag=true;

    }

    public static void main(String args[]){
//        char[][]  board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][]  board={{'O','X','O','O','O','X'},{'O','O','X','X','X','O'},{'X','X','X','X','X','O'},{'O','O','O','O','X','X'},{'X','X','O','O','X','O'},{'O','O','X','X','X','X'}};
        _130_cycledReign cycledReign=new _130_cycledReign();
        cycledReign.solve(board);
        System.out.println(board);
    }

}
