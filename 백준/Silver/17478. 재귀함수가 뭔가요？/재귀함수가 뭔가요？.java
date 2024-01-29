
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static int depth;
	static String recur_start = "\"재귀함수가 뭔가요?\"\n";
	static String recur1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static String recur2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String recur3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String recur_close = "라고 답변하였지.\n";
	static String bracket = "____";
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		depth = Integer.parseInt(br.readLine());
		bw.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(0);
		bw.flush();
	}
	
	
	static void recursive(int dep) throws IOException {
		bw.append(bracket.repeat(dep));
		bw.append(recur_start);
		if(dep == depth) {
			bw.append(bracket.repeat(dep));
			bw.append(answer);
			bw.append(bracket.repeat(dep));
			bw.append(recur_close);
			return;
		}else {
			bw.append(bracket.repeat(dep));
			bw.append(recur1);
			bw.append(bracket.repeat(dep));
			bw.append(recur2);
			bw.append(bracket.repeat(dep));
			bw.append(recur3);
		}
		recursive(dep+1);
		bw.append(bracket.repeat(dep));
		bw.append(recur_close);
	}
	
}
