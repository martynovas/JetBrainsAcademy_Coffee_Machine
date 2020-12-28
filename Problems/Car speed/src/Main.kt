import java.util.*

fun check(speed: Int, limit: Int = 60) :String =
    if (speed <= limit) "Within the limit" else "Exceeds the limit by ${speed - limit} kilometers per hour"

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val speed = scanner.nextLine().toInt()
    val limit = scanner.nextLine()
    val result = if (limit == "no limit") check(speed) else check(speed, limit.toInt())
    println(result)
}