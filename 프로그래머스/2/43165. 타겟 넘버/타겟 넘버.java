class Solution {
    int[] numbers = null;
    int count = 0;
    int target = 0;
    public int solution(int[] numbers, int target) {
        count = 0;
        this.numbers = numbers;
        this.target = target;
        count(0, 0);
        return count;
    }
    
    
    public void count(int start, int sum) {
        if(start == numbers.length) {
            if(sum == target){
                count++;
            }
            return;
        }
        
        count(start+1, sum + numbers[start]);
        count(start+1, sum - numbers[start]);
    }
}