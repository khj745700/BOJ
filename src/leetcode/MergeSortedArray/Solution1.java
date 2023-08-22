package leetcode.MergeSortedArray;


import java.util.ArrayDeque;
import java.util.Queue;

public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        Queue<Integer> nums1Elements = new ArrayDeque<>();
        Queue<Integer> nums2Elements = new ArrayDeque<>();

        fill(nums1Elements, nums1, m);
        fill(nums2Elements, nums2, n);

        int idx  = 0 ;
        while(!nums1Elements.isEmpty() && !nums2Elements.isEmpty()) {
            int num1 = nums1Elements.peek();
            int num2 = nums2Elements.peek();

            if(num1 > num2) {
                temp[idx++] = nums2Elements.poll();
            }

            if(num1 <= num2) {
                temp[idx++] = nums1Elements.poll();
            }
        }

        while(!nums1Elements.isEmpty()) {
            temp[idx++] = nums1Elements.poll();
        }

        while(!nums2Elements.isEmpty()) {
            temp[idx++] = nums2Elements.poll();
        }

        System.arraycopy(nums1, 0, nums2, 0, nums1.length);

    }

    public void fill(Queue<Integer>queue, int[] arr, int size) {
        for(int i = 0 ; i < size; i++){
            queue.add(arr[i]);
        }
    }
}
