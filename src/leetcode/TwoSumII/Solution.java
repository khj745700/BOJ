package leetcode.TwoSumII;

public class Solution {
    public int[] twoSum(int[] numbers, int target){
        int left = 0;
        int right = numbers.length - 1;

        while( numbers[left] + numbers[right] != target) {
            int val = numbers[left] + numbers[right];
            if(val < target) {
                ++left;
            }else if(val > target){
                --right;
            }
        }

        return new int[]{left + 1, right + 1};
    }
}
