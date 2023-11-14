import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static char[][] arr;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        arr = new char[8][];
        for(int test_case = 1; test_case <= T; test_case++) {
            count = Integer.parseInt(br.readLine());
            for(int i = 0; i < 8; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            ArrayList<Character> list = new ArrayList<>();
            int answer = 0;
            for(int i = 0 ; i <= 8 - count; i++) {
                for(int j = 0 ; j < 8; j++) {

                    addRow(j, i, list);
                    if(isPalindrome(list)) {
                        answer++;
                    }
                    list.clear();
                }
            }

            for(int i = 0 ; i < 8; i++) {
                for(int j = 0; j <= 8 - count; j++) {
                    addColumn(j, i, list);

                    if(isPalindrome(list)) {
                        answer++;
                    }
                    list.clear();
                }
            }

            System.out.printf("#%d %d \n", test_case, answer);

        }
    }

    static boolean isPalindrome(ArrayList<Character> list) {
        for(int i = 0, j = list.size()-1 ; i < list.size()/2 ; i++, j--) {
            if(!list.get(i).equals(list.get(j))) {
                return false;
            }
        }
        return true;
    }


    static void addColumn(int x, int y, ArrayList<Character> list) {
        for(int i = 0; i < count; i++) {
            list.add(arr[y][i + x]);
        }
    }

    static void addRow(int x, int y, ArrayList<Character> list) {
        for(int i = 0; i < count; i++) {
            list.add(arr[y+i][x]);
        }
    }
}
