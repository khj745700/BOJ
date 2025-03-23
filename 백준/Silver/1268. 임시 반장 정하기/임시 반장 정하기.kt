import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    var n = br.readLine().toInt()

    var inputs = Array<Array<Int>>(n) { i -> Array(5) { 0 } }
    var students = Array<Int>(n) { 0 }

    for (i in 0 until n) {
        var st = StringTokenizer(br.readLine())
        for(j in 0 until 5) {
            inputs[i][j] = st.nextToken().toInt()
        }
    }

    var max = 0
    var id = 0
    for(i in 0 until n) {
        var set = HashSet<Int>()
        for(ii in 0 until n) {
            if(i == ii) {
                continue
            }

            for(iii in 0 until 5) {
                if(inputs[i][iii] == inputs[ii][iii]){
                    set.add(ii)
                }
            }
        }
        if(max < set.size) {
            id = i
            max = set.size
        }
    }

    print(id + 1)
}