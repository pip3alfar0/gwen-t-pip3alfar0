package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController


class OtherTurn(context: GameController) extends GameState(context) {

  override def toFinalRound(): Unit = {
    context.state = new FinalRound(context)
  }

  override def pass(): Unit = {
    toFinalRound()
  }

  override def changeTurn(): Unit = {
    context.currentPlayer_=(context.previousPlayer.get)
  }

  override def isInOtherTurn: Boolean = {
    true
  }
  
}

