package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController


class PlayerTurn(context: GameController) extends GameState(context) {

  /** The player decided to pass */
  override def toOtherTurn(): Unit = {
    context.state = new OtherTurn(context)
  }

  /** The player played a card, so it's the computer's turn */
  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }

  /** The player decides if he want to play a card or pass. If he choose to play, he decides which card it's going to be played */
  override def doAction(): Unit = {
    println("Do you want to play or pass?")
    val decision: String = scala.io.StdIn.readLine()
    if (decision == "Play") {
      context.PlayPlayer()
    } else {
      println("You passed. It's the opponent's turn")
      context.passPlayer()
    }
  }

}
