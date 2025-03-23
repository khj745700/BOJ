import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var input = br.readLine()
    br.close()

    var list = ArrayList<String>()

    for(i in 1 until input.length) {
        for (j in i + 1 until input.length) {
            list.add(makeString(input, i, j))
        }
    }
    list.sort()
    print(list[0])
}


fun makeString(s: String, firstIdx: Int, secondIdx: Int): String {
    var firstString = s.substring(0, firstIdx)
    var secondString = s.substring(firstIdx, secondIdx)
    var thirdString = s.substring(secondIdx, s.length)

    return firstString.reversed() + secondString.reversed() + thirdString.reversed()
}