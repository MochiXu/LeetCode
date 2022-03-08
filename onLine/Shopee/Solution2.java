package onLine.Shopee;
//给定两个数字 (x, y)，允许以下两种计算：
//
//1.同时对两个数加1， 即 (x, y) -> (x+1, y+1)
//
//2.同时对两个数乘2，即 (x, y) -> (x*2, y*2)
//
//求要将 (x, y) 转换成 (X,Y)，至少需要多次计算，如果不能转换，返回-1
//
//
//
//注：x,y,X,Y > 0
public class Solution2 {
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
        long res=0;
        while (sourceX<targetX&&sourceY<targetY){
            //首先判断临界情况
            if(2*(sourceX+1)==targetX&&2*(sourceY+1)==targetY){
                return res+2;
            }
            else if (((sourceX+1)==targetX&&(sourceY+1)==targetY)||((sourceX*2)==targetX&&(sourceY*2)==targetY)){
                return res+1;
            }
            else if((sourceX*2+1)==targetX&&(sourceY*2+1)==targetY){
                return res+2;
            }
            else if(2*(sourceX+1)+1==targetX&&2*(sourceY+1)+1==targetY){
                return res+3;
            }
            else if (((sourceX+2)==targetX&&(sourceY+2)==targetY)||((sourceX*4)==targetX&&(sourceY*4)==targetY)){
                return res+2;
            }
            else if((sourceX*2+2)==targetX&&(sourceY*2+2)==targetY){
                return res+3;
            }




            //非临界情况
            else if(2*(sourceX+1)<targetX&&2*(sourceY+1)<targetY){
                sourceX*=2;
                sourceY*=2;
            }else {
                sourceX+=1;
                sourceY+=1;
            }
            res++;

        }
        return -1;
    }
    public static void main(String args[]){
        Solution2 solution2=new Solution2();
        System.out.println(solution2.GetMinCalculateCount(10,100,22,202));
    }
}
