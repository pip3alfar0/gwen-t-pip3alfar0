package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class ComputadorJuega(context: GameController) extends GameState(context) {

  override def toOtherTurn(): Unit = {
    context.state = new OtherTurn(context)
  }

  override def toPlayerTurn(): Unit = {
    context.state = new PlayPlayer(context)
  }

  override def doAction(): Unit = {
    context.PlayComputer()
  }

}
