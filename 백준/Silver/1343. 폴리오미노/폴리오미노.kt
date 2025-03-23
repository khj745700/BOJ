import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var input = StringBuilder(br.readLine())

    for(i in 0 until input.length) {
        if(input[i] == '.') continue
        if(input[i] == 'X') {
            var j = i;
            while(j < input.length && input[j] == 'X') {
               j++
            }

            if((j - i) % 2 == 1) {
                print("-1")
                return
            }

            if((j - i) % 4 == 0 ){
                for(ii in i until j) {
                    input[ii] = 'A'
                }
            }else {
                for(ii in i until j - 2) {
                    input[ii] = 'A'
                }
                input[j-2] = 'B'
                input[j-1] = 'B'
            }
        }
    }
    print(input)
}