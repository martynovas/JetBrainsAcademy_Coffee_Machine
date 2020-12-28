class City(val name: String) {
    var population: Int = 0
        set(value) {
            field = when (value) {
                in Int.MIN_VALUE..0 -> 0
                in 50_000_000..Int.MAX_VALUE -> 50_000_000
                else -> value
            }
        }
}