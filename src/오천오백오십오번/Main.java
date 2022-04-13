package 오천오백오십오번;
import java.io.*;




public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String find = br.readLine();
            int loopCount = Integer.parseInt(br.readLine());
            int findLength = find.length();
            int count = 0;
            String[] data = new String[loopCount];
            for(int i = 0 ; i < loopCount; i++){
                data[i] = br.readLine();
            }
            for(int i = 0 ; i < loopCount; i++){
                for(int j = 0 ; j < data[i].length(); j++){
                    int k = 0;
                    if(find.charAt(0) == data[i].charAt(j)){
                        for(k = 1 ; k< findLength; k++){
                            if(find.charAt(k) != data[i].charAt((j+k)%data[i].length())){
                                break;
                            }
                        }
                    }
                    if(k == findLength){
                        count++;
                        break;
                    }
                }
            }
            bw.append(Integer.toString(count));
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}