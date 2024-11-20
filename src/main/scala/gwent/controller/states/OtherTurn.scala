package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** Class representing the moment when one of the players passed his turn.
 *
 * A `OtherTurn` is a type of [[GameState]].
 * This state represents the turn of the player who did not pass.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class OtherTurn(context: GameController) extends GameState(context) {

  /** The two players passed */
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

