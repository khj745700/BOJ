import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int swapSize;
    static char[] nums;
   	static int max;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
            nums = String.valueOf(sc.nextInt()).toCharArray();
			swapSize = sc.nextInt();
            max = 0;
            backtracking(0, 0);
            System.out.printf("#%d %d \n", test_case, max);
		}
	}
    
    static void backtracking(int count, int start) {
      	int x;
     	if(count == swapSize) {
			x = Integer.parseInt(new String(nums));
            max = Math.max(max, x);
            return;
        }
        for(int i = start; i < nums.length; i++){
            for(int j = i +1; j < nums.length; j++) {
                char temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                backtracking(count +1, i);
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
       	}
    }
        
}