data class City(val name: String) {
    var defaultDegree = mapOf("Moscow" to 5, "Hanoi" to 20, "Dubai" to 30)
    var degrees: Int = defaultDegree[name] ?: 0
        set(value) {
            field = if (value !in -92..57) defaultDegree[name] ?: 0 else value
        }
}        

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val list = listOf(firstCity, secondCity, thirdCity)
    val coldest = list.filter { it.degrees == list.minOf { it.degrees } }

    print(if (coldest.size == 1) coldest.first().name else "neither")
}
