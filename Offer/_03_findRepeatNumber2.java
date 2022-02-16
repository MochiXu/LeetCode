package Offer;

import java.util.HashMap;
import java.util.HashSet;

public class _03_findRepeatNumber2 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i : nums){
            if (hashSet.contains(i))
                return i;
            else hashSet.add(i);
        }
        return -1;
    }
}
