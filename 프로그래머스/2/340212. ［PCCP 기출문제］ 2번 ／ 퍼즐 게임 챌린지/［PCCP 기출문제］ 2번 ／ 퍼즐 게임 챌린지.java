class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        long l = 1;
        long r = 1000000;
        
        long answer = Long.MAX_VALUE;
        while(l < r) {
            long mid = (l + r) / 2;
            long time = getTime(diffs, Long.valueOf(mid).intValue(), times);
            if(time <=limit) {
               answer = Math.min(answer, mid);
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        
        return Long.valueOf(answer).intValue();
    }
    
    
    public long getTime(int[] diffs, int level, int[] times) {
        long time = times[0];
        
        for(int i = 1; i < diffs.length; i++) {
            
            if(level < diffs[i]) {
                int gap = diffs[i] - level;
                time += ( times[i] + times[i-1]) * gap + times[i];
            }else {
                time += times[i];
            }
        }
        
        return time;
    }
    
    /**
    1. n개의 퍼즐을 제한 시간 내에 풀어야함.
    
    2. 각 퍼즐은 난이도와 소요시간이 정해져 있음.
    3. 현재 퍼즐의 난이도 = diff
    4. 소요시간 = time_cur
    5. 이전 퍼즐의 소요 시간 = time_prev
    6. 나의 숙련도 = level
    
    1. diff 보다 레벨이 크면 퍼즐 틀리지 않고 time_cur 만큼 시간 사용하여 해결
    2. diff > level 이라면 diff-level 번 틀림. 틀릴 때마다 time_cur 만큼 시간 사용. 추가로 time_prev 만큼의 시간을 사용해서 이전 퍼즐 다시 풀고 와야 함. 다시 풀때는 난이도 상관없이 안틀림. idff-level 번 틀린 이후에 다시 퍼즐을 풀면 time_cur 만큼의 시간을 사용하여 퍼즐을 해결함.
    */
}