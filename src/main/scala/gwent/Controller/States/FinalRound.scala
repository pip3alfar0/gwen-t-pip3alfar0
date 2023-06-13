package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class FinalRound(context: GameController) extends GameState(context) {

  override def toEndGame(): Unit = {
    context.state = new EndGame(context)
  }

  override def toAnotherRound(): Unit = {
    context.state = new AnotherRound(context)
  }

}

