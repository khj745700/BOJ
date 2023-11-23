
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> left = new Stack();
        Stack<Character> right = new Stack();
        int[] wordCount = new int[26];

        char[] wordSequence = str.toCharArray();
        for(int i = 0 ; i < wordSequence.length; i++){
            ++wordCount[wordSequence[i]-'A'];
        }

        boolean flag = true;
        for(int i = 0; i < 26; i++){
            if(flag){
                if(wordCount[i] % 2 == 1){
                    flag = false;
                }
            }else{
                if(wordCount[i] % 2 == 1){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        boolean centerFlg = false;
        char center = 0;

        for(int j = 0 ; j < wordCount.length; j++){
            if(wordCount[j] > 0 &&wordCount[j] %2 == 0){
                for(int k = 0 ; k < wordCount[j]; k++){
                    if(k % 2 == 0){
                        left.push((char)('A'+j));
                    }else{
                        right.push((char)('A'+j));

                    }
                }
            }else if(wordCount[j] > 0 &&wordCount[j] %2 == 1){
                for(int k = 1 ; k < wordCount[j]; k++){
                    if(k % 2 == 0){
                        left.push((char)('A'+j));
                    }else{
                        right.push((char)('A'+j));
                    }
                }
                center = (char)('A'+j);
                centerFlg = true;
            }
        }
        if(centerFlg){
            left.push(center);
        }

        while(!right.isEmpty()){
            left.push(right.pop());
        }
        for(int i = 0 ; i < left.size(); i++){
            System.out.print(left.get(i));
        }
    }
}