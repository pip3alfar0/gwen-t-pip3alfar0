package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController


class OtherTurn(context: GameController) extends GameState(context) {

  override def toFinalRound(): Unit = {
    context.state = new FinalRound(context)
  }

  override def doAction(): Unit = {
    //context.Play()
  }

}

