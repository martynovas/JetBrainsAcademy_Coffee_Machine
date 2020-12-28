import java.util.Scanner

enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val color = input.next()
    println(Rainbow.values().find { it.name == color.toUpperCase() } != null)
}