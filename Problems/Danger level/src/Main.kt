enum class DangerLevel(val lv:Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    fun getLevel() = lv
}