package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

class FinalRound(context: GameController) extends GameState(context) {

  override def toEndGame(): Unit = {
    context.state = new EndGame(context)
  }

  override def toAnotherRound(): Unit = {
    context.state = new AnotherRound(context)
  }
  
}

