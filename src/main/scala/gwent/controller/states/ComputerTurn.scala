package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

class ComputerTurn(context: GameController) extends GameState(context) {

  override def toOtherTurn(): Unit = {
    context.state = new OtherTurn(context)
  }

  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  override def doAction(): Unit = {
    context.PlayComputer()
  }

}
