import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> task = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int end = 0;
        int jobsIdx = 0;
        int answer = 0;
        while(count < jobs.length){
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end){
                task.add(jobs[jobsIdx++]);
            }

            if(task.isEmpty()){
                end = jobs[jobsIdx][0];
            }else{
                int[] temp = task.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return answer/count;
    }
}