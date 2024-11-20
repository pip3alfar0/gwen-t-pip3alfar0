package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController


class EndGame(context: GameController) extends GameState(context) {

  // jugador que le queden gemas gana, si ninguno tiene es empate
  /*
  override def doAction(): Unit = {
    context.finalGemCount()
  }
  */
  
}
