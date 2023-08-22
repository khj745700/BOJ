package leetcode.MergeSortedArray;


public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int mrgIdx = m + n - 1;

        while (idx2 != -1) {
            int num1 = (idx1 == -1 ? Integer.MIN_VALUE : nums1[idx1]);
            int num2 = nums2[idx2];

            if(num1 > num2) {
                nums1[mrgIdx--] = num1;
                nums1[idx1--] = 0;
            }

            if(num1 <= num2) {
                nums1[mrgIdx--] = num2;
                nums2[idx2--] = 0;
            }
        }
    }
}

