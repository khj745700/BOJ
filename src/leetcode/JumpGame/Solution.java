package leetcode.JumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

    private boolean canJump(int depth, int[] nums) {
        if(depth >= nums.length) {
            return true;
        }
        if(nums[depth] == 0) {
            return false;
        }
        return canJump(depth, nums);

    }
}
