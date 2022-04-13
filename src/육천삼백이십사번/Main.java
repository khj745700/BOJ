package 육천삼백이십사번;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++){
            bw.append("URL #"+(i+1));
            bw.newLine();

            StringBuilder protocol = new StringBuilder("Protocol = ");
            StringBuilder host = new StringBuilder("Host     = ");
            StringBuilder port = new StringBuilder("Port     = ");
            StringBuilder path = new StringBuilder("Path     = ");
            String input = br.readLine();

        }
    }
}
/*
3
ftp://acm.baylor.edu:1234/pub/staff/mr-p
http://www.informatik.uni-ulm.de/acm
gopher://veryold.edu
 */
/*
URL #1
Protocol = ftp
Host     = acm.baylor.edu
Port     = 1234
Path     = pub/staff/mr-p

URL #2
Protocol = http
Host     = www.informatik.uni-ulm.de
Port     = <default>
Path     = acm

URL #3
Protocol = gopher
Host     = veryold.edu
Port     = <default>
Path     = <default>
*/