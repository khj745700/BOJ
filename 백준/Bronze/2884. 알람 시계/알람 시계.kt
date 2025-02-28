import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalTime
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st  = StringTokenizer(br.readLine())
    var h = st.nextToken().toInt()
    var m = st.nextToken().toInt()

    var time = LocalTime.of(h, m)

    time = time.minusMinutes(45);
    print("${time.hour} ${time.minute}")
}

