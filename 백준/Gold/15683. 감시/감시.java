import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    static int[][] map;
    static int[][] view;
    static int MIN = Integer.MAX_VALUE;
    static List<Camera> cameras;
    static int wall = 0;
    static int totalCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        view = new int[N][M];
        cameras = new ArrayList<>();
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] != 6) {
                    cameras.add(new Camera(j, i, 1, map[i][j]));
                }
                if(map[i][j] == 6) {
                    wall++;
                }
            }
        }
        backtracking(0);
        System.out.println(MIN);
    }

    static void backtracking(int cameraNum) {
        if(cameraNum == cameras.size()) {
            MIN = Math.min(count(), MIN);
            return;
        }

        for(int i = 1 ; i <= 4; i++) {
            Camera camera = cameras.get(cameraNum);
            int cameraSort = camera.sort;
            switch (cameraSort) {
                case 1:
                    setCamera1(i, camera.x, camera.y, 1);
                    backtracking(cameraNum + 1);
                    setCamera1(i, camera.x, camera.y, -1);
                    break;
                case 2:
                    camera2(i, camera.x, camera.y, 1);
                    backtracking(cameraNum + 1);
                    camera2(i, camera.x, camera.y, -1);
                    break;
                case 3:
                    camera3(i, camera.x, camera.y, 1);
                    backtracking(cameraNum + 1);
                    camera3(i, camera.x, camera.y, -1);
                    break;
                case 4:
                    camera4(i, camera.x, camera.y, 1);
                    backtracking(cameraNum + 1);
                    camera4(i, camera.x, camera.y, -1);
                    break;
                case 5:
                    camera5(camera.x, camera.y, 1);
                    backtracking(cameraNum + 1);
                    camera5(camera.x, camera.y, -1);
            }
        }
    }

    static int count() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(view[i][j] == 0) {
                    count++;
                }

            }
        }
        //System.out.println(count - wall);
        return count - wall;
    }


    static void camera5(int x, int y, int c) {
        setCamera1(1, x, y, c);
        setCamera1(2, x, y, c);
        setCamera1(3, x, y, c);
        setCamera1(4, x, y, c);
    }

    static void camera4(int vector, int x, int y, int c) {
        if (vector == 1) {
            setCamera1(1, x, y, c);
            setCamera1(2, x,y,c);
            setCamera1(3,x,y,c);
        }

        if(vector == 2) {
            setCamera1(2, x,y,c);
            setCamera1(3, x,y,c);
            setCamera1(4, x,y,c);
        }
        if(vector == 3) {
            setCamera1(3, x,y,c);
            setCamera1(4, x,y,c);
            setCamera1(1, x,y,c);
        }
        if(vector == 4) {
            setCamera1(4, x,y,c);
            setCamera1(1, x,y,c);
            setCamera1(2, x,y,c);
        }
    }

    static void camera3(int vector, int x, int y, int c) {
        if(vector == 1) {
            setCamera1(1, x, y, c);
            setCamera1(3, x, y, c);
        }

        if(vector == 2) {
            setCamera1(2,x,y,c);
            setCamera1(4,x,y,c);
        }

        if(vector == 3){
            setCamera1(4, x, y, c);
            setCamera1(1, x, y, c);
        }


        if(vector == 4){
            setCamera1(2, x, y, c);
            setCamera1(3, x, y, c);
        }
    }

    static void camera2(int vector, int x, int y, int c) {
        if(vector == 1 || vector == 2) {
            setCamera1(1, x, y, c);
            setCamera1(2, x, y, c);
        }
        if(vector == 3 || vector == 4) {
            setCamera1(3, x, y, c);
            setCamera1(4, x, y, c);
        }
    }


    static void setCamera1(int vector, int x, int y, int c) {
        //오른쪽
        if(vector == 1) {
            for(int i = x; i < M; i++) {
                if(map[y][i] == 6) {
                    break;
                }
                view[y][i] += c;
            }
        }

        //왼쪽
        if(vector == 2) {
            for(int i = x; i >= 0; i--) {
                if(map[y][i] == 6) {
                    break;
                }
                view[y][i] += c;
            }
        }

        //위
        if(vector == 3) {
            for(int i = y; i >= 0; i--) {
                if(map[i][x] == 6) {
                    break;
                }
                view[i][x] += c;
            }
        }

        //아래
        if(vector == 4) {
            for(int i = y; i < N; i++) {
                if(map[i][x] == 6) {
                    break;
                }
                view[i][x] += c;
            }
        }
    }
    static class Camera {
        int x;
        int y;
        int vector;
        int sort;
        public Camera(int x, int y, int vector, int sort) {
            this.x = x;
            this.y = y;
            this.vector = vector;
            this.sort = sort;
        }
    }
}