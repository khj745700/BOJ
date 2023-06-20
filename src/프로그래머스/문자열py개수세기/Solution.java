package 프로그래머스.문자열py개수세기;

public class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();

        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
        return ps == ys;
    }
}
