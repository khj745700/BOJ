import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //서로 다른 재료 3개를 순서대로 넣어 최고 품질의 폭탄.
    //넣을 수 있는 재료의 후보는 10개 이하.
    //3개를 고른 뒤, 순서를 정해 잘 넣어야 함. ==> 순열?

    //각 칸에는 품질을 나타내는 숫자와 원소를 나타내는 색
    // 초기에 모든 칸의 품질은 0, 원소는 흰색.
    // i행 j열에는 2가지 정보가 있음.
    // 재료는 4 X 4 모양으로 생김.

    //1. 효능 : 가마 한 칸의 품질을 바꾸는 -9 이상 9이하의 정수 xij
    //2. 원소 : 가마 한 칸의 원소를 바꿀 수 있는 색 ci,j (R G B Y W)
    //  -> 재료를 가마에 넣을 때는 5X5를 벗어 날 수 없음. 기울여 넣기도 안됨.


    //1. 재료가 위치하지 않는 가마의 격자칸은 아무런 변화가 생기지 않음.
    //2. 재료가 위치한 가마의 격자칸에 있는 품질과 원소값은 바뀔 수 있음.
        // 격자의 품질은 재료의 효능이 더해짐. 더한 뒤의 값이 음수인 경우 0으로, 9초과 인 경우 9로.
        // 격자의 색은 재료의 원소가 흰색인 경우 그대로, 아닌 경우 재료의 원소와 같은 색으로 칠해짐.
    //폭탄의 품질은 7R + 5B + 3G + 2Y

    static int N;
    static List<char[][]> colors;
    static List<int[][]> qualities;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colors = new ArrayList<>();
        qualities = new ArrayList<>();
        max = Integer.MIN_VALUE;
        for(int i = 0; i  < N; i++) {
            char[][] color = new char[4][4];
            int[][] quality = new int[4][4];
            for(int j = 0 ; j < 4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 4; k++) {
                    quality[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j = 0 ; j < 4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 0 ; k < 4; k++) {
                    color[j][k] = st.nextToken().charAt(0);
                }
            }

            colors.add(color);
            qualities.add(quality);

        }

        for(int i = 0 ; i < 3; i++) {
            for(int j = 0; j < N; j++) {
                char[][] color = colors.get(j + i * N);
                int[][] quantity = qualities.get(j + i * N);
                color = setRotation(color);
                colors.add(color);
                quantity = setRotation(quantity);
                qualities.add(quantity);
            }
        }
        char[][] colorMap = new char[5][5];
        for(int i = 0; i < 5; i++) {
            Arrays.fill(colorMap[i], 'W');
        }
        backtracking(0, colorMap, new int[5][5]);
        System.out.println(max);
    }

    static void printC(char[][] c) {
        for(int i = 0 ; i < 4; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        System.out.println();
    }

    static void printQ(int[][] c) {
        for(int i = 0 ; i < 4; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
        System.out.println();
    }

    static boolean[] visited = new boolean[10];
    static void backtracking(int depth, char[][] cloneColorMap, int[][] cloneQuantityMap) {
        if(depth == 3){
            int sum = 0;
            for(int i = 0; i < 5; i++) {
                for(int j = 0 ; j < 5; j++) {
                    int val = cloneQuantityMap[i][j];
                    switch(cloneColorMap[i][j]) {
                        case 'R':
                            val *= 7;
                            break;
                        case 'G':
                            val *= 3;
                            break;
                        case 'B':
                            val *= 5;
                            break;
                        case 'Y':
                            val *= 2;
                            break;
                        default:
                            val = 0;
                            break;
                    }
                    sum += val;
                }
            }
            max = Math.max(max, sum);
            return;
        }
        char[][] cloneC;
        int[][] cloneQ;
        for(int i = 0 ; i < N; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            //왼쪽 위

            for(int j = 0; j <4; j++) {
                cloneC = cloneColorMap(cloneColorMap);
                cloneQ = cloneQuantityMap(cloneQuantityMap);
                setColor(0, 0, cloneC, i + j * N);
                setQuantity(0,0, cloneQ, i + j * N);
                backtracking(depth + 1, cloneC, cloneQ);
            }

            for(int j = 0; j <4; j++) {
                cloneC = cloneColorMap(cloneColorMap);
                cloneQ = cloneQuantityMap(cloneQuantityMap);
                setColor(1, 0, cloneC, i + j * N);
                setQuantity(1,0, cloneQ, i + j * N);
                backtracking(depth + 1, cloneC, cloneQ);
            }

            for(int j = 0; j <4; j++) {
                cloneC = cloneColorMap(cloneColorMap);
                cloneQ = cloneQuantityMap(cloneQuantityMap);
                setColor(0, 1, cloneC, i + j * N);
                setQuantity(0,1, cloneQ, i + j * N);
                backtracking(depth + 1, cloneC, cloneQ);
            }

            for(int j = 0; j <4; j++) {
                cloneC = cloneColorMap(cloneColorMap);
                cloneQ = cloneQuantityMap(cloneQuantityMap);
                setColor(1, 1, cloneC, i + j * N);
                setQuantity(1,1, cloneQ, i + j * N);
                backtracking(depth + 1, cloneC, cloneQ);
            }

            visited[i] = false;
        }

    }
    static void setColor(int w, int h, char[][] color, int idx) {
        char[][] target = colors.get(idx);
        for(int i = h; i < h + 4; i++) {
            for(int j = w; j < w + 4; j++) {
                if(target[i-h][j-w] == 'W') {
                    continue;
                }
                color[i][j] = target[i-h][j-w];
            }
        }
    }

    static char[][] setRotation(char[][] color) {
        char[][] clone = new char[4][];
        for(int i = 0; i < 4; i++) {
            clone[i] = color[i].clone();
        }

        for(int i = 0; i < 2; i++) {
            char[] temp = clone[i];
            clone[i] = clone[3-i];
            clone[3-i] = temp;
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0 ; j < i ; j++) {
                char temp = clone[i][j];
                clone[i][j] =clone[j][i];
                clone[j][i] = temp;
            }
        }

        return clone;
    }

    static int[][] setRotation(int[][] color) {
        int[][] clone = new int[4][];
        for(int i = 0; i < 4; i++) {
            clone[i] = color[i].clone();
        }

        for(int i = 0; i < 2; i++) {
            int[] temp = clone[i];
            clone[i] = clone[3-i];
            clone[3-i] = temp;
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0 ; j < i ; j++) {
                int temp = clone[i][j];
                clone[i][j] =clone[j][i];
                clone[j][i] = temp;
            }
        }

        return clone;
    }

    static void setQuantity(int w, int h, int[][] quantity, int idx) {
        int[][] target = qualities.get(idx);
        for(int i = h; i < h + 4; i++) {
            for(int j = w; j < w + 4; j++) {
                int val = quantity[i][j] + target[i-h][j-w];
                if(val < 0) {
                    val = 0;
                }
                if (val > 9) {
                    val = 9;
                }
                quantity[i][j] = val;
            }
        }
    }


    static char[][] cloneColorMap(char[][] colorMap) {
        char[][] temp = new char[5][];
        for(int i = 0; i < 5; i++) {
            temp[i] = colorMap[i].clone();
        }

        return temp;
    }

    static int[][] cloneQuantityMap(int[][] quantityMap) {
        int[][] temp = new int[5][];
        for(int i = 0; i < 5; i++) {
            temp[i] = quantityMap[i].clone();
        }

        return temp;
    }
}
