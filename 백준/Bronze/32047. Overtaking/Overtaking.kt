import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var n = br.readLine().toInt()

    while (n != 0) {
        val redSt = StringTokenizer(br.readLine(), " ")
        val blueSt = StringTokenizer(br.readLine(), " ")

        var redSum = redSt.nextToken().toInt()
        var blueSum = blueSt.nextToken().toInt()
        var conflict = 0
        var redLeading = redSum > blueSum
        var blueLeading = redSum < blueSum

        for(i in 1 until n) {
            val startRed = redSum
            val startBlue = blueSum

            val speedRed = redSt.nextToken().toInt()
            val speedBlue = blueSt.nextToken().toInt()

            if(speedRed != speedBlue) {
                val crossTime = (startRed - startBlue).toDouble() / (speedRed - speedBlue).toDouble()

                if( 0 < crossTime && crossTime < 1 ) {
                    if(speedRed > speedBlue && blueLeading) {
                        conflict++
                        redLeading = true
                        blueLeading = false
                    }else if(speedBlue > speedRed && redLeading) {
                        conflict++
                        redLeading = false
                        blueLeading = true
                    }
                }
            }

            redSum += speedRed
            blueSum += speedBlue

            if(redSum > blueSum && blueLeading) {
                conflict++
                blueLeading = false
                redLeading = true
            } else if (blueSum > redSum && redLeading) {
                conflict++
                blueLeading = true
                redLeading = false
            }else if (redSum < blueSum) {
                blueLeading = true
                redLeading = false
            }else if (redSum > blueSum) {
                blueLeading = false
                redLeading = true
            }

        }
        bw.append(conflict.toString())
        bw.newLine()
        n = br.readLine().toInt()
    }
    bw.flush()
}