fun concat(s1: String, s2: String, s3: String, sp: String = " "): String = s1 + sp + s2 + sp + s3
fun main() {
    val s1 = readLine()!!
    val s2 = readLine()!!
    val s3 = readLine()!!
    val s4 = readLine()!!

    if (s4 == "NO SEPARATOR")
        println(concat(s1, s2, s3))
    else
        println(concat(s1, s2, s3, s4))
}