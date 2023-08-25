package leetcode.RemoveDulicatesFromSortedArrayTwo;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
            if(map.get(num) <= 2) {
                nums[idx] = num;
                idx++;
            }
        }

        return idx;
    }
}
