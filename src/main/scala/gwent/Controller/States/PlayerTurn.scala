package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController


class PlayerTurn(context: GameController) extends GameState(context) {

  override def toOtherTurn(): Unit = {
    context.state = new OtherTurn(context)
  }

  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }

  // tiene que jugar una carta, o pasar
  override def doAction(): Unit = {
    context.PlayPlayer()
  }

}

