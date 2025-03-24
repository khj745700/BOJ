import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var n = br.readLine().toInt()
    init(n)
    for(i in 7 .. n) {
        if(!primes[i]) {
            continue
        }
        if(find(i)){
            bw.append(i.toString())
            bw.newLine()
        }
    }
    bw.flush()
}

lateinit var primes: Array<Boolean>;

fun init(n: Int) {
    primes = Array<Boolean>(n+1) {true}
    primes[0] = false
    primes[1] = false
    for(i in 2..n) {
        if(primes[i] == true) {
            for(ii in i + i .. n step i) {
                primes[ii] = false
            }
        }
    }
}
fun find(x: Int): Boolean {
    val set = HashSet<Int>()

    var target = x
    while (target != 1) {
        var sum= 0
        for(i in 1 .. getMaxIdx(target)) {
            sum += digitSquare(target, i)
        }
        if(set.contains(sum)) {
            return false
        }
        set.add(sum)
        target = sum
    }
    return true
}


fun getMaxIdx(x: Int): Int {
    var count = 1
    var target = x;
    while(target/10 != 0) {
        target /= 10
        count++
    }

    return count
}

fun digitSquare(n: Int, i:Int): Int {
    var value = (n % 10.0.pow(i)).toInt()
    value = value / 10.0.pow(i-1).toInt()
    return value * value
}
