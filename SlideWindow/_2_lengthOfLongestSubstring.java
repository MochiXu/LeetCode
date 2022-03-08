package SlideWindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 滑动窗口通用解决方法
 * 1-滑动窗口位于最左侧，则进行最非重复字符串的判断，如果是非重复，则扩大滑动窗口
 * 2-当滑动窗口扩大到m的时候，发现是一个重复字符串，那么保持滑动窗口为m-1并往右移动
 * 3-往右移动的过程中，如果滑动窗口m+1是一个非重复的字符串，则扩大滑动窗口，直到滑动窗口不能扩大位置
 * 4-继续往右移动，等滑动窗口右侧边界遇到数组边界的时候，结束，返回滑动窗口长度
 *
 * 工具：
 * 判断滑动窗口内部元素是否是重复的hashmap
 *
 * */
public class _2_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2)return s.length();
        char[] str=s.toCharArray();

        HashSet<Character> set=new HashSet<>();//设置滑动窗口内的元素容器（非重复）
        int slideWindow=1;//设置初始滑动窗口的长度
        set.add(str[0]);//初始化元素容器内的元素

        for (int i=0;i<str.length-slideWindow;i++){
            //滑动窗口静止扩充阶段
            while (i+slideWindow<str.length&&!set.contains(str[i+slideWindow])&&set.size()==slideWindow){
                //i+slideWindow<str.length：边界判断
                //!set.contains(str[i+slideWindow])：新加入的元素并不存在set容器中
                //set.size()==slideWindow：说明当前滑动窗口内有重复元素，直接右移，不需要扩充。
                set.add(str[i+slideWindow]);
                slideWindow++;
            }
            //滑动窗口往右侧运动--（刷新set容器）
            set.clear();
            for (int j=i+1;j<slideWindow+i+1&&j<str.length;j++){
                set.add(str[j]);
            }
        }
        return slideWindow;
    }
    public static void main(String args[]){
        _2_lengthOfLongestSubstring sl=new _2_lengthOfLongestSubstring();
        System.out.println(sl.lengthOfLongestSubstring("ohvhjdml"));
    }
}
