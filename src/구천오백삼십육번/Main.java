package 구천오백삼십육번;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int testCase = Integer.parseInt(br.readLine());
            String animalSay = "";
            for(int i = 0 ; i < testCase; i++){
                String integrationSay =br.readLine();
                String[] arr = integrationSay.split(" ");
                animalSay = br.readLine();
                while(!animalSay.equals("what does the fox say?")){
                    String[] data =animalSay.split(" ");
                    for(int j = 0 ; j < arr.length; j++){
                        if(arr[j].equals(data[2])){
                            arr[j] = "";
                        }
                    }
                    animalSay = br.readLine();
                }
                for(int j = 0 ; j < arr.length; j++){
                    bw.append(arr[j]);
                    if(!arr[j].equals("")){
                        bw.append(" ");
                    }
                }
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
