import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var x:Int = br.readLine().toInt()
    var y:Int = br.readLine().toInt()

    if(x > 0 && y > 0) {
        println(1)
    }
    if(x < 0 && y > 0) {
        println(2)
    }
    if(x < 0 && y < 0) {
        println(3)
    }
    if(x > 0 && y < 0) {
        println(4)
    }
}