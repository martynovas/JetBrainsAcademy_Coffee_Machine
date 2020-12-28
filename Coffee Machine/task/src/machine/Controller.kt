package machine

object Controller {
    private fun fillWater(answer: String): String {
        water = answer.toInt()
        status = Status.ASK_MILK
        return ""
    }

    private fun fillMilk(answer: String): String {
        milk = answer.toInt()
        status = Status.ASK_BEANS
        return ""
    }

    private fun fillBeans(answer: String): String {
        beans = answer.toInt()
        status = Status.ASK_CUPS
        return ""
    }

    private fun fillCups(answer: String): String {
        disposableCups = answer.toInt()
        machine.fill(water, milk, beans, disposableCups)
        status = Status.ASK_ACTION
        return "\n"
    }

    private fun changeAction(answer: String): String {
        Action.values().find { it.actionName == answer }!!.let {
            status = it.nextStatus
            return it.action.invoke()
        }
    }

    private fun makeCoffe(answer: String): String {
        val result: CoffeMachine.MakeCoffeResult? =
                when (answer) {
                    "1" -> machine.makeCoffe(CoffeMachine.TypeOfCoffe.ESPRESSO)
                    "2" -> machine.makeCoffe(CoffeMachine.TypeOfCoffe.LATE)
                    "3" -> machine.makeCoffe(CoffeMachine.TypeOfCoffe.CAPPUCCINO)
                    else -> null
                }
        status = Status.ASK_ACTION
        return resultMessage[result] ?: ""
    }

    enum class Status(val question: String, val action: (anser: String) -> String) {
        ASK_ACTION("Write action (buy, fill, take, remaining, exit):", Controller::changeAction),
        ASK_WATER("Write how many ml of water do you want to add:", Controller::fillWater),
        ASK_MILK("Write how many ml of milk do you want to add:", Controller::fillMilk),
        ASK_BEANS("Write how many grams of coffee beans do you want to add:", Controller::fillBeans),
        ASK_CUPS("Write how many disposable cups of coffee do you want to add:", Controller::fillCups),
        ASK_COFFE("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:", Controller::makeCoffe),
        EXIT("exit", Controller::fillWater)
    }

    private fun remaining() = "\nThe coffee machine has:\n" +
            "${machine.water} of water\n" +
            "${machine.milk} of milk\n" +
            "${machine.beans} of coffee beans\n" +
            "${machine.disposableCups} of disposable cups\n" +
            "\$${machine.money} of money\n\n"

    enum class Action(val actionName: String, val action: () -> String, val nextStatus: Status) {
        REMAINIG("remaining", Controller::remaining, Status.ASK_ACTION),
        FILL("fill", { "\n" }, Status.ASK_WATER),
        BUY("buy", { "\n" }, Status.ASK_COFFE),
        TAKE("take", { "\nI gave you \$${machine.takeMoney()}\n" }, Status.ASK_ACTION),
        EXIT("exit", { "" }, Status.EXIT)
    }

    private val resultMessage = mapOf(
            CoffeMachine.MakeCoffeResult.NOT_WATER to "Sorry, not enough water!\n\n",
            CoffeMachine.MakeCoffeResult.NOT_MILK to "Sorry, not enough milk!\n\n",
            CoffeMachine.MakeCoffeResult.NOT_BEANS to "Sorry, not enough beans!\n\n",
            CoffeMachine.MakeCoffeResult.NOT_CUPS to "Sorry, not enough disposable cups!\n\n",
            CoffeMachine.MakeCoffeResult.DONE to "I have enough resources, making you a coffee!\n\n"
    )

    private val machine = CoffeMachine(400, 540, 120, 9, 550)
    private var status = Status.ASK_ACTION

    val isWork
        get() = status != Status.EXIT

    private var water: Int = 0
    private var milk: Int = 0
    private var beans: Int = 0
    private var disposableCups: Int = 0

    fun getQuestion() = status.question

    fun sendAnswer(answer: String): String {
        return status.action.invoke(answer)
    }
}