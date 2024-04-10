import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 있음.
    //톱니는 N극 또는 S극 중 하나를 나타냄.
    //톱니바퀴 회전은 한칸을 기준으로 함. 회전은 시계방향과 반시계방향이 있음.
    //회전 시킬 방향을 결정해야함.
    //회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 서로 닿은 톱니의 극이 다르다면,
    //B는 A가 회전한 방향과 반대방향으로 회전함.
    //같으면 회전하지 않음.

    //점수 토탈은 각 톱니의 12시 방향임.
    //입력은12시부터 시계방향 순서로.
    //빡 구현 시뮬 문제.

    static int[][] wheels;
    static int N;
    static int[][] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new int[4][8];

        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            for(int j = 0 ; j < 8; j++) {
                wheels[i][j] = input.charAt(j) - '0';
            }
        }

        N = Integer.parseInt(br.readLine());
        inputs = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++) {
                inputs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation();
        int answer = 0;
        for(int i = 0 ; i < 4; i++) {
            answer += wheels[i][0] * Math.pow(2, i);
        }
        System.out.println(answer);
    }

    static void simulation() {
        int step = 0;

        while(step != N) {
            int[] now = inputs[step];

            int cur = now[0] - 1;
            int move = now[1];

            boolean[] canRotate = new boolean[4];
            int[] moveRotate = new int[4];

            canRotate[cur] = true;
            moveRotate[cur] = move;
            //오른쪽 체크
            for(int i = cur + 1; i < 4; i++) {
                                                    //이전 휠 => 햔재 기준 d
                canRotate[i] = rightWheels(wheels[i-1], wheels[i]);
                if(canRotate[i]){
                    moveRotate[i] = -moveRotate[i-1];
                }else {
                    break;
                }
             }
            //왼쪽 체크
            for(int i = cur -1; i >= 0; i--) {
                                //현재 휠 기준 오른쪽
                canRotate[i] = rightWheels(wheels[i], wheels[i+1]);
                if(canRotate[i]){
                    moveRotate[i] = -moveRotate[i+1];
                }else {
                    break;
                }
            }

            for(int i = 0;  i < 4; i++) {
                if(!canRotate[i] || moveRotate[i] == 0) {
                    continue;
                }
                if(moveRotate[i] == 1) {
                    rotateRight(wheels[i]);
                }else {
                    rotateLeft(wheels[i]);
                }
            }

            step++;

        }
    }

    //반시계 방향
    static void rotateLeft(int[] wheel) {
        for(int i = 0; i < 7; i++) {
            int temp = wheel[i];
            wheel[i] = wheel[i + 1];
            wheel[i + 1] = temp;
        }
    }

    //시계방향
    static void rotateRight(int[] wheel) {
        for(int j = 7; j >= 1; j--) {
            int temp = wheel[j];
            wheel[j] = wheel[j - 1];
            wheel[j - 1] = temp;
        }
    }

    static boolean leftWheels(int[] mine, int[] left) {
        return getWheelsLeft(mine) != getWheelsRight(left);
    }

    static boolean rightWheels(int[] mine, int[] right) {
        return getWheelsRight(mine) != getWheelsLeft(right);
    }

    static int getWheelsLeft(int[] wheel) {
        return wheel[6];
    }

    static int getWheelsRight(int[] wheel) {
        return wheel[2];
    }
}
