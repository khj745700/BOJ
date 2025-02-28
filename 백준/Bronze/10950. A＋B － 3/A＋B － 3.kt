import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()
    var n = br.readLine().toInt()

    for(i in 1..n) {
        var st = StringTokenizer(br.readLine())

        var n = st.nextToken().toInt()
        var m = st.nextToken().toInt()

        sb.append(n + m)
        sb.append('\n')
    }
    print(sb)
}