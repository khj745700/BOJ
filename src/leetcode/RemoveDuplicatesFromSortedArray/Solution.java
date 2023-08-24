package leetcode.RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int before = 0, save = 1, target = 1;

        if (nums.length == 1) {
            return nums.length;
        }

        while(target < nums.length && save < nums.length) {
            if (nums[save] <= nums[before]) {
                if(nums[target] <= nums[before]) {
                    target++;
                }else {
                    swap(nums, save, target);
                    save++;
                    before++;
                }
            } else {
                save ++;
                before ++;
            }
        }
        return before + 1;
    }

    void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
