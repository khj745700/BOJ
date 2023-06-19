package 프로그래머스.스택큐다리를지나는트럭;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    //현재 브릿지의 무게
    private int nowWeight;

    //브릿지의 최대무게
    private int maxWeight;

    //브릿지 길이
    private int bridgeLength;

    //브릿지 수용량
    private int capacity;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //class 상태 초기화
        init(weight, bridge_length);

        LinkedList<Integer> trucks = new LinkedList<>();

        for (int truck_weight : truck_weights) {
            trucks.add(truck_weight);
        }
        Queue<Integer> start_truck = new LinkedList<>(trucks);

        //배열로 선언한 이유? 현재 시간과 무게를 다루기 위함 { count, truck_weight }
        Queue<int[]> in_bridge = new LinkedList<>();

        // 여기까진 설명 안해줘도 된다 생각합니다



        //start_truck은 출발해야 하는 트럭이 없을때까지 달림
        while(!start_truck.isEmpty()){
            // 달릴 첫번째 놈
            int target = start_truck.peek();

            //만약 트럭이 다리를 달릴수 있는지 판단
            if(determinAddTruck(target)){

                //달릴 수 있다면 큐에서 젤 앞에 녀석 제거
                start_truck.poll();

                //브릿지에 추가
                in_bridge.add(new int[] {1, target});

                //트럭 추가했음을 알림
                addTruck(target);
            }

            //조건식과 상관없이 매 초마다 증가하기 때문에 plusCount 메서드 실행
            answer = plusCount(in_bridge, answer);
        }

        while(!in_bridge.isEmpty()){
            answer = plusCount(in_bridge,answer);
        }

        return answer + 1;
    }

    private boolean determinAddTruck(int truck_weight){
        if (nowWeight + truck_weight > maxWeight){
            return false;
        }else return capacity + 1 <= bridgeLength;
    }

    private void addTruck(int truck_weight){
        nowWeight += truck_weight;
        capacity++;
    }

    private int plusCount(Queue<int[]> in_bridge, int nowCount) {

        boolean existEnd = false;
        int target = 0;


        //queue 내부에 반복문을 돌려서, 탈출해야 할 녀석이 있으면 있다고 알림.
        for (int[] data : in_bridge) {
            if(data[0] == bridgeLength){
                target = data[1];
                existEnd = true;
            }
            data[0] ++;
        }

        //탈출할 녀석이 있으면 그녀석은 제일 먼저 들어온 녀석일 것이므로
        if(existEnd) {

            //제일 앞에서 뺌
            in_bridge.poll();

            //현재 수용량을 한 칸 뺌
            --capacity;

            //현재 브릿지의 무게에서 타겟을 뺌.
            nowWeight-=target;
        }
        return ++nowCount;
    }

    private void init(int weight, int bridge_length) {
        nowWeight = 0;
        maxWeight = weight;
        bridgeLength = bridge_length;
        capacity = 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2,10, new int[] {7,4,5,6}));
        System.out.println(solution.solution(100,100, new int[] {10}));
        System.out.println(solution.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10, 10}));
    }
}
