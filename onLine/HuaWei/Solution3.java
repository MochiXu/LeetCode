package onLine.HuaWei;

import java.util.Scanner;

public class Solution3 {
    private int red_r_d=0;
    private int red_r_u=0;
    private int red_H=0;
    private int red_L=0;
    private int blue_r_d=0;
    private int blue_r_u=0;
    private int blue_H=0;
    private int blue_L=0;
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int column=scanner.nextInt();
        int row=scanner.nextInt();
        int[][] grid=new int[row][column];
        int step=0;
        while (scanner.hasNext()){
            int target=scanner.nextInt()-1;
            if (target>column) {
                System.out.println(step+1+",error");
                return;
            }
            target++;
            if (step%2==0){
                //红方落子
                for (int i=row-1;i>=0;i--){
                    if (grid[i][target]==0){
                        grid[i][target]=1;
                        break;
                    }
                }
                //判断红方是否胜利
                Solution3 s=new Solution3();
                if (s.getRed(grid,row,column)==1){
                    System.out.println(step+1+","+"red");
                    return;
                }
            }else {
                //蓝方子
                for (int i=row-1;i>=0;i--){
                    if (grid[i][target]==0){
                        grid[i][target]=-1;
                        break;
                    }
                }
                //判断蓝方是否胜利
                Solution3 s=new Solution3();
                if (s.getBlue(grid,row,column)==1){
                    System.out.println(step+1+","+"blue");
                    return;
                }
            }
            step++;
        }
    }
    public int getRed(int[][] grid,int row,int column){
        //首先判断RD方向
        int[][] visitedRD=new int[row][column];
        int[][] visitedRU=new int[row][column];
        int[][] visitedH=new int[row][column];
        int[][] visitedL=new int[row][column];
        red_r_d=0;
        red_r_u=0;
        red_H=0;
        red_L=0;
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (visitedRD[i][j] == 0) {
                        getStatus_right_down(visitedRD, grid, row, column, i, j);
                    }
                }
                if (red_r_d >= 4) return 1;//胜利
//                red_r_d=0;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (visitedRU[i][j] == 0) {
                        getStatus_right_up(visitedRU, grid, row, column, i, j);
                    }
                }
                if (red_r_u >= 4) return 1;//胜利
//                red_r_u=0;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (visitedL[i][j] == 0) {
                        getStatus_L(visitedL, grid, row, column, i, j);
                    }
                }
                if (red_L >= 4) return 1;//胜利
//                red_L=0;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (visitedH[i][j] == 0) {
                        getStatus_H(visitedH, grid, row, column, i, j);
                    }
                }
                if (red_H >= 4) return 1;//胜利
//                red_H=0;
            }
        }
        red_r_d=0;
        red_r_u=0;
        red_H=0;
        red_L=0;

        return -1;
    }
    //判断红方是否获胜，红色为1，遍历grid，当red_r_d++
    public void getStatus_right_down(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==1){
            visited[i][j]=1;//标记已经访问
            red_r_d++;
            //朝右下
            if (i+1<row&&j+1<colum){
                getStatus_right_down(visited,grid,row,colum,i+1,j+1);
            }
            //朝左上
            if (i-1>=0&&j-1>=0){
                getStatus_right_down(visited,grid,row,colum,i-1,j-1);
            }
        }
    }
    public void getStatus_right_up(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==1){
            visited[i][j]=1;//标记已经访问
            red_r_u++;
            //朝右上
            if (i-1>=0&&j+1<colum){
                getStatus_right_up(visited,grid,row,colum,i-1,j+1);
            }
            //朝左下
            if (i+1<row&&j-1>=0){
                getStatus_right_up(visited,grid,row,colum,i+1,j-1);
            }
        }
    }
    public void getStatus_H(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==1){
            visited[i][j]=1;//标记已经访问
            red_H++;
            //朝右
            if (j+1<colum){
                getStatus_H(visited,grid,row,colum,i,j+1);
            }
            //朝左
            if (j-1>=0){
                getStatus_H(visited,grid,row,colum,i,j-1);
            }
        }
    }
    public void getStatus_L(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==1){
            visited[i][j]=1;//标记已经访问
            red_L++;
            //朝上
            if (i-1>=0){
                getStatus_L(visited,grid,row,colum,i-1,j);
            }
            //朝下
            if (i+1<row){
                getStatus_L(visited,grid,row,colum,i+1,j);
            }
        }
    }

    public int getBlue(int[][] grid,int row,int column){
        //首先判断RD方向
        int[][] BvisitedRD=new int[row][column];
        int[][] BvisitedRU=new int[row][column];
        int[][] BvisitedH=new int[row][column];
        int[][] BvisitedL=new int[row][column];
        blue_r_d=0;
        blue_r_u=0;
        blue_H=0;
        blue_L=0;
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (BvisitedRD[i][j] == 0) {
                        BgetStatus_right_down(BvisitedRD, grid, row, column, i, j);
                    }
                }
                if (blue_r_d >= 4) return 1;//胜利
//                red_r_d=0;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (BvisitedRU[i][j] == 0) {
                        BgetStatus_right_up(BvisitedRU, grid, row, column, i, j);
                    }
                }
                if (blue_r_u >= 4) return 1;//胜利
//                red_r_u=0;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (BvisitedH[i][j] == 0) {
                        BgetStatus_H(BvisitedH, grid, row, column, i, j);
                    }
                }
                if (blue_H >= 4) return 1;//胜利
//                red_L=0;
            }
        }
        for (int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    if (BvisitedL[i][j] == 0) {
                        BgetStatus_L(BvisitedL, grid, row, column, i, j);
                    }
                }
                if (blue_L >= 4) return 1;//胜利
//                red_H=0;
            }
        }
        blue_r_d=0;
        blue_r_u=0;
        blue_H=0;
        blue_L=0;

        return -1;
    }

    public void BgetStatus_right_down(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==-1){
            visited[i][j]=1;//标记已经访问
            blue_r_d++;
            //朝右下
            if (i+1<row&&j+1<colum){
                BgetStatus_right_down(visited,grid,row,colum,i+1,j+1);
            }
            //朝左上
            if (i-1>=0&&j-1>=0){
                BgetStatus_right_down(visited,grid,row,colum,i-1,j-1);
            }
        }
    }
    public void BgetStatus_right_up(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==-1){
            visited[i][j]=1;//标记已经访问
            blue_r_u++;
            //朝右上
            if (i-1>=0&&j+1<colum){
                BgetStatus_right_up(visited,grid,row,colum,i-1,j+1);
            }
            //朝左下
            if (i+1<row&&j-1>=0){
                BgetStatus_right_up(visited,grid,row,colum,i+1,j-1);
            }
        }
    }
    public void BgetStatus_H(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==-1){
            visited[i][j]=1;//标记已经访问
            blue_H++;
            //朝右
            if (j+1<colum){
                BgetStatus_H(visited,grid,row,colum,i,j+1);
            }
            //朝左
            if (i-1>=0){
                BgetStatus_H(visited,grid,row,colum,i-1,j);
            }
        }
    }
    public void BgetStatus_L(int[][]visited,int[][] grid,int row,int colum,int i,int j){
        if(i>=0&&i<row&&j>=0&&j<colum&&visited[i][j]==0&&grid[i][j]==-1){
            visited[i][j]=1;//标记已经访问
            blue_L++;
            //朝上
            if (i-1>=0){
                BgetStatus_L(visited,grid,row,colum,i-1,j);
            }
            //朝下
            if (i+1<row){
                BgetStatus_L(visited,grid,row,colum,i+1,j);
            }
        }
    }
}
