import java.util.*

enum class Country(val Currency:String){
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar")
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val first = scanner.next()
    val second = scanner.next()

    runCatching {
        println(Country.valueOf(first).Currency == Country.valueOf(second).Currency)
    }.onFailure { println(false) }
}