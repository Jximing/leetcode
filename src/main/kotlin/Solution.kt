import com.sun.xml.internal.fastinfoset.util.StringArray

fun main(args: Array<String>) {
//    val generateMatrix = generateMatrix(2)
    println(getPermutation(3, 4) + "--->231")
    println(getPermutation(3, 3) + "--->213")
    println(getPermutation(3, 1) + "--->123")
    println(getPermutation(4, 9) + "--->2314")
}

fun getPermutation(n: Int, k: Int): String {
    var a = Array(n) { i -> (i + 1).toString() }
    return help(a, n, k)
}

fun help(a: Array<String>, n: Int, k: Int): String {
    val divisor = factorial(n)
    if (k == 0 || divisor * n == k) {
        return a.filter { x -> x != "0" }.reduceRight { z, c -> c + z }
    }
    if (k == 1) {
        return a.filter { x -> x != "0" }.reduce { z, c -> z + c }
    }
    val remainder = k % divisor
    var index = k / divisor
    if (remainder == 0)
        index --
    var x = 0
    var first = ""
    for (i in a.indices) {
        if (a[i] == "0") {
            continue
        }
        if (x == index) {
            first = a[i]
            a[i] = "0"
            break
        }
        x++
    }
    return first + help(a, n - 1, remainder)
}

fun factorial(n: Int): Int {
    var res = 1
    for (i in 1 until n) {
        res *= i
    }
    return res
}

fun generateMatrix(n: Int): Array<IntArray> {
    if (n == 1)
        return arrayOf(intArrayOf(0))
    val a = Array(n) { IntArray(n) }
    var row = 0
    var col = 0
    val size = n * n + 1
    var temp = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))
    var f = 0
    for (i in 1 until size) {
        a[row][col] = i
        var b = temp[f % 4]
        if (row + b[0] >= n || col + b[1] >= n || col + b[1] < 0) f++
        b = temp[f % 4]
        row += b[0]
        col += b[1]
        if (a[row][col] != 0) {
            row -= b[0]
            col -= b[1]
            f++
            b = temp[f % 4]
            row += b[0]
            col += b[1]
        }
    }
    return a
}