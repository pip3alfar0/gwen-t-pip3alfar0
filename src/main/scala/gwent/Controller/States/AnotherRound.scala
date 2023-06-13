package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController


class AnotherRound(context: GameController) extends GameState(context) {

  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }
  
}
