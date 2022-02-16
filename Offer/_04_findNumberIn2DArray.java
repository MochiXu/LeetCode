package Offer;
/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：行与列均有序，则考虑使用两次二分法
 * */
public class _04_findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //边界判断
        if (matrix.length==0||matrix[0].length==0)return false;
        int row=matrix.length;
        int column=matrix[0].length;
        //在列上依次查询
        int upper=0;
        for (int i=0;i<row;i++){
            if (matrix[i][0]==target||matrix[i][column-1]==target)
                return true;
            else if (matrix[i][0]>target){
                break;
            }
            else if (matrix[i][column-1]<target){
                continue;
            }
            else {
                //在行上使用二分法
                int left=0,right=column-1;
                while (left<=right){
                    int mid=(left+right)/2;
                    if(matrix[i][mid]<target)
                        left=mid+1;
                    else if(matrix[i][mid]>target)
                        right=mid-1;
                    else return true;
                }
            }
        }


        return false;
    }

    public static void main(String args[]){
        _04_findNumberIn2DArray findNumberIn2DArray=new _04_findNumberIn2DArray();
        int[][] arr={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(arr,5));
    }
}
