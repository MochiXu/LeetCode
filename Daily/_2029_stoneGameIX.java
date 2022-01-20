package Daily;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。
 * 给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。
 * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones中移除任一石子。
 * <p>
 * 如果玩家移除石子后，导致 所有已移除石子 的价值总和 可以被 3 整除，那么该玩家就 输掉游戏 。
 * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
 * 假设两位玩家均采用最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。
 * <p>
 * 分析：Alice获胜，一定要使得Bob移出石子后sum%3=0，避免自己移出石子后sum%3=0
 * Bob获胜，一定要避免移出石子后sum%3=0，且要坚持到全部移出
 */

/**
 * 博弈问题
 * <p>
 * 所有的石头均可被替换为价值为0、1、2的石头
 * 1.若有偶数个0，和任意的1、2
 * 每次挑选到0均可视为易手操作，即偶数个0相当于不存在
 * 也就是相当于任意的1与2
 * 1.1的个数不为0，2的个数为0：A先手则A必输
 * 2.1的个数为0，2的个数不为0：A先手则A必输
 * 3.1与2的个数均不为0：A选择数量不是最多的那类石头，则A必定赢（B首先会凑出来3）！！！此处是需要好好理解的地方
 * 2.若有奇数个0，和任意的1、2
 * 也就是相当于A有一次易手操作，那么A要在必输的情况下进行易手
 * 1.1的个数不为0，2的个数为0：A需要直接易手，则B必输
 * 2.1的个数为0，2的个数不为0：A需要直接易手，则B必输[如果1与2同时为0，那么A输了]
 * 3.1与2的个数均不为0：若1与2的数量差大于2的话，那么A必定赢，如果1与2的数量差小于2的话，那么A必输
 */

/**
 * 代码需要好好优化
 * */
public class _2029_stoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        int stone_0 = 0, stone_1 = 0, stone_2 = 0;
        for (int i = 0; i < stones.length; i++) {
            switch (stones[i] % 3) {
                case 0: {
                    stone_0++;
                    break;
                }
                case 1: {
                    stone_1++;
                    break;
                }
                case 2: {
                    stone_2++;
                    break;
                }
            }
        }
        if (stone_0 % 2 == 0) {
            if ((stone_1 != 0 && stone_2 == 0) || (stone_1 == 0 && stone_2 != 0)) return false;
            return !(stone_1==0&&stone_2==0);
        } else {
            if (stone_1 == 0 || stone_2 == 0) {
                if (stone_1 == 0 && stone_2 == 0) return false;
                return Math.abs(stone_1 - stone_2) > 2;
            } else return Math.abs(stone_1 - stone_2) > 2;
        }

    }

    public static void main(String args[]) {
        _2029_stoneGameIX test = new _2029_stoneGameIX();
        int[] a = {3};
        System.out.println(test.stoneGameIX(a));
    }
}
