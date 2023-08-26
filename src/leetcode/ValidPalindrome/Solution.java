package leetcode.ValidPalindrome;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {

    public boolean isPalindrome(String s) {
        int head = 0;
        char[] chars = s.toCharArray();
        int rear = chars.length - 1;
        char rearChar = '\0';
        char headChar = '\0';
        while(head <= rear) {
            headChar = chars[head];
            rearChar = chars[rear];
            if(!Character.isLetterOrDigit(headChar)){
                ++head;
                continue;
            }
            if(!Character.isLetterOrDigit(rearChar)){
                ++rear;
                continue;
            }
            headChar = Character.toLowerCase(chars[head]);
            rearChar = Character.toLowerCase(chars[rear]);
            head++;
            rear++;
            if(headChar != rearChar){
                return false;
            }
        }
        return true;
    }


//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase();
//        s = preProcessing(s);
//        ArrayDeque<Character> arrayDeque = new ArrayDeque<>(s.length());
//        for (char c : s.toCharArray()) {
//            arrayDeque.addFirst(c);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(Object c : arrayDeque.toArray()){
//            sb.append(c);
//        }
//
//        return s.equals(sb.toString());
//    }

//    public boolean isPalindrome(String s) {
//        s = s.toLowerCase();
//        s = preProcessing(s);
//        StringBuilder sb = new StringBuilder(s);
//        sb = sb.reverse();
//        return s.equals(sb.toString());
//    }

    public String preProcessing(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c) || Character.isDigit(c)){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean isLetter(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
