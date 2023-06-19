package 프로그래머스.스택큐올바른괄호;

import java.util.Stack;

public class Solution {

    boolean solution(String s) {
        char[] data = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        if(data[0] == ')'){
            return false;
        }

        for(int i = 0; i < data.length; i++){
            if(data[i]=='('){
                charStack.push('(');
            }
            else{
                if(charStack.isEmpty()){
                    return false;
                }
                if(charStack.peek() == '('){
                    charStack.pop();
                }else{
                    return false;
                }
            }
        }

        return charStack.isEmpty();
    }
}
