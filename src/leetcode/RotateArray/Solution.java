package leetcode.RotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        System.gc();
    }

    void reverse(int[] arr, int start, int end) {
        while(start < end){
            swap(arr, start++, end--);
        }
    }

    void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
