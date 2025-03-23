import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n: Int = parseInt(br.readLine())

    var crossCount: Int = 1
    var prevSumCount = 0

    // 현재 입력받은 값과 이전 값과 대각선의 개수의 합이 커질 때까지 합한다.
    while(prevSumCount + crossCount < n ) {
        prevSumCount += crossCount
        crossCount++
    }

    var child = if(crossCount % 2 == 1) crossCount else 1
    var parent = if(crossCount % 2 == 0) crossCount else 1
    while(prevSumCount+1 < n) {
        if(crossCount % 2 == 0) {
            parent--
            child++
            prevSumCount++
        }else {
            parent++
            child--
            prevSumCount++
        }
    }

    br.close()
    print("${child}/${parent}")
}