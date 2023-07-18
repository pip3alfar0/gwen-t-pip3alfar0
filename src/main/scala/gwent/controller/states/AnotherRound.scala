package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController


class AnotherRound(context: GameController) extends GameState(context) {

  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }

  override def isInAnotherRound: Boolean = {
    true
  }

}
