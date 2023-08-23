package leetcode.RemoveElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int rear = findLastIdx(nums, val);

        if(rear == -1) {
            return 0;
        }

        while (head < rear) {
            if(nums[head] == val) {
                swap(nums, head, rear);
                rear = findLastIdx(nums, val);
            }
            head++;
        }

        if(nums[head] != val) {
            head+=1;
        }

        return head;
    }

    public void swap(int[] arr, int idx1, int idx2) {
        if(idx1 == idx2) {
            return;
        }
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public int findLastIdx(final int[] nums, int val) {
        for(int i= nums.length - 1 ; i >= 0 ; i--){
            if(nums[i] != val){
                return i;
            }
        }
        return -1;
    }
}
