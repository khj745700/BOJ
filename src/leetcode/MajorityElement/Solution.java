package leetcode.MajorityElement;


import java.util.ArrayDeque;

public class Solution {
    public int majorityElement(int[] nums) {
        boolean find = false;
        int val = 0;
        while(!find) {
            int randomVal = (int) (Math.random() * nums.length);
            val = nums[randomVal];
            if(isMajorElement(nums,val)){
                find = true;
            }
        }
        return val;
    }

    boolean isMajorElement(int[] arr, int  val) {
        int count = 0 ;
        for(int i = 0 ; i < arr.length; i++) {
            if(val == arr[i]){
                count++;
            }
        }

        return count > arr.length / 2;
    }
}
