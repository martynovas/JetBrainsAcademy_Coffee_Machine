class Player(val id: Int, val name: String, val hp: Int) {
    companion object {
        var sequenceId = 0
        val defaultHp = 100

        fun create(name: String): Player{
            sequenceId++
            return Player(sequenceId,name, defaultHp)
        }
    }
}