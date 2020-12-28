package machine

class CoffeMachine(water:Int, milk:Int, beans:Int, disposableCups:Int, money:Int) {
    enum class TypeOfCoffe(val caffeNname:String, val water:Int, val milk:Int, val beans:Int, val cost:Int){
        CAPPUCCINO("Cappuccino",200,100,12,6),
        ESPRESSO("Espresso",250,0,16,4),
        LATE("Latte",350,75,20,7)
    }

    enum class MakeCoffeResult{
        NOT_WATER,
        NOT_MILK,
        NOT_BEANS,
        NOT_CUPS,
        DONE
    }

    var water:Int = water
        private set
    var milk:Int = milk
        private set
    var beans:Int = beans
        private set
    var disposableCups:Int = disposableCups
        private set
    var money:Int = money
        private set

    fun fill(addWater:Int, addMilk:Int, addBeans:Int, addDisposableCups:Int) {
        water += addWater
        milk += addMilk
        beans += addBeans
        disposableCups += addDisposableCups
    }

    fun makeCoffe(coffe:TypeOfCoffe) =
            when{
                water < coffe.water -> MakeCoffeResult.NOT_WATER
                milk < coffe.milk -> MakeCoffeResult.NOT_MILK
                beans < coffe.beans -> MakeCoffeResult.NOT_BEANS
                disposableCups < 1 -> MakeCoffeResult.NOT_CUPS
                else -> {
                    water -= coffe.water
                    milk  -= coffe.milk
                    beans -= coffe.beans
                    money += coffe.cost
                    disposableCups -= 1
                    MakeCoffeResult.DONE
                }
            }

    fun takeMoney():Int = money.also { money = 0 }

}