package OtherPractice.Shopee;

public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * <p>
     * <p>
     * 计算用户逾期扣分数
     *
     * @param dpdInfo string字符串  用户逾期记录，'N': 没有逾期，正常  'Y'：有逾期
     * @return int整型
     * <p>
     * 给定一个字符串来表示一个用户的账单逾期记录，这个记录仅包含以下两个字符：
     * <p>
     * 'N': 没有逾期，正常
     * <p>
     * 'Y'：有逾期
     * <p>
     * 如“YNN”表示用户逾期一次，“NNN”表示用户没有逾期，“NNYYYYYNNYY”表示用户最大连续逾期5次；
     * 0～3 -10
     * 3～7 -15
     * 7～∞ -25
     */
    public int calDPDScore(String dpdInfo) {
        char[] input = dpdInfo.toCharArray();
        if (input.length == 0) return 0;
        int maxY=0;
        int currentY = 0;
        int sumDelete = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'Y') {
                currentY++;
            } else {
                //当前遇到了N
                if (currentY != 0) {
                    maxY=Math.max(currentY,maxY);
                    currentY = 0;
                }
            }
        }
        maxY=Math.max(currentY,maxY);
        if (maxY > 0 && maxY <= 3) {
            sumDelete = 10;
        } else if (maxY > 3 && maxY <= 7) {
            sumDelete = 15;
        } else if (maxY > 7) {
            sumDelete = 25;
        }
        return sumDelete;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.calDPDScore("NNYYYYYNNYY"));
    }
}