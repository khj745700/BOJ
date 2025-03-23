fun main() {
    val br = System.`in`.bufferedReader()

    var n = br.readLine().toInt()
    var i = 1;
    while(n != 0) {
        val map = HashMap<Int, Node>()

        for(i in 1..n) {
            map[i] = Node(br.readLine(), 2)
        }

        for( i in 0 until 2 * n - 1) {
           val id = br.readLine().split(" ")[0].toInt()
           map[id]?.let{ it.count-- }
            if(map[id]?.count == 0) {
                map.remove(id)
            }
        }

        for(node in map) {
            println("${i++} ${node.value.name}")
        }
        n = br.readLine().toInt()
    }
}

class Node(
    val name: String,
    var count: Int
)