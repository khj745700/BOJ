import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int start = 1;
        int count = 0;
        for(int i = 0; i < order.length; i++) {
            while(stack.isEmpty() || stack.peek() < order[i]){
                stack.addFirst(start++);
            }
            
            if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.removeFirst();
                count++;
            }else {
                break;
            }
        }
        return count;
    }
}