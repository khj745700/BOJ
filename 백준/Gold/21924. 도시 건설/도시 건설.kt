import java.util.PriorityQueue

lateinit var parent: Array<Int>

fun main() {
    val br = System.`in`.bufferedReader()

    val (n ,m) = br.readLine()!!.split(" ").map { it.toInt() }

    parent = Array<Int>(n+1){it}

    val pq = PriorityQueue<Node>()
    var totalMoney = 0L
    for(i in 1..m) {
        val (u, v, w) = br.readLine()!!.split(" ").map { it.toInt() }
        pq.add(Node(u, v, w))
        totalMoney += w
    }

    var sum = 0L
    var count = 0
    while (pq.isNotEmpty()) {
        val cur = pq.remove()
        if(union(cur.u, cur.w)) {
            sum += cur.money
            count++
        }

    }

    if(count != n-1) {
        sum = -1
    }else {
        sum = totalMoney - sum
    }
    print(sum)
}

fun find(u: Int) : Int {
    if(u != parent[u]) {
        parent[u] = find(parent[u])
    }
    return parent[u]
}

fun union(a: Int, b: Int): Boolean {
    var findA = find(a)
    var findB = find(b)

    if (findA == findB) {
        return false
    }
    parent[findA] = findB
    return true
}


class Node(
    val u: Int,
    val w: Int,
    val money: Int
) : Comparable<Node>  {
    override fun compareTo(other: Node): Int {
        return money - other.money
    }

}