package machine

import java.util.*



fun main() {
  val scanner = Scanner(System.`in`)

  while (Controller.isWork) {
    print(Controller.getQuestion())
    print(Controller.sendAnswer(scanner.nextLine()))
  }
}
