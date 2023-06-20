package 프로그래머스.삼진법뒤집기;

public class Solution {
    public int solution(int n) {
        String str = Integer.toString(n,3);
        String reversed = new StringBuilder(str).reverse().toString();
        return Integer.parseInt(reversed, 3);
    }
}
