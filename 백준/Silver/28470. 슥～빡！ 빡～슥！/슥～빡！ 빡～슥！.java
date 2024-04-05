import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] attack;
	static int[] shield;
	static int[] rate;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	attack = new int[N];
    	shield = new int[N];
    	rate = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N; i++) {
    		attack[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N; i++) {
    		shield[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0 ; i < N; i++) {
    		rate[i] = (int)(Float.parseFloat(st.nextToken()) * 10);
    	}
    	
    	double sum = 0;
    	
    	for(int i = 0; i < N; i++) {
    		sum = Math.max(sum + Math.floor(attack[i] * rate[i] / 10)- shield[i], sum - Math.floor(shield[i] * rate[i] / 10) + attack[i]);
    	}
    	System.out.printf("%d", Math.round(sum));
    }
}