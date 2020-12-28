enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun main(args: Array<String>) {
    val color = readLine()!!
    println(Rainbow.valueOf(color.toUpperCase()).ordinal + 1)
}