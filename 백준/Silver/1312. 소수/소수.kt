import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var n = st.nextToken().toInt()

    a %= b
    var answer = 0
    for(i in 0 until n) {
        answer = (a * 10) / b
        a = (a * 10) % b

    }

    println(answer)
}