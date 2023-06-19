package 프로그래머스.이상한문자만들기;

public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;

        for (char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)){
                isUpper = true;
                sb.append(c);
            }else {
                if(isUpper) {
                    sb.append(Character.toUpperCase(c));

                }else {
                    sb.append(Character.toLowerCase(c));
                }
                isUpper = !isUpper;
            }
        }
        return sb.toString();
    }
}
