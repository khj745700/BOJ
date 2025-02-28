import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toInt()

    for(i in 1..9) {
        println("$n * $i = ${n*i}")
    }
}