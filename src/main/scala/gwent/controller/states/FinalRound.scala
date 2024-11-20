package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** Class representing the end of the round.
 *
 * A `FinalState` is a type of [[GameState]].
 * This state represents the end of a round, in this state is where it's determined if another round is played or the game is over.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class FinalRound(context: GameController) extends GameState(context) {

  /** One of the players don't have any gems */
  override def toEndGame(): Unit = {
    context.state = new EndGame(context)
  }

  /** The players still have at least one gem */
  override def toAnotherRound(): Unit = {
    context.state = new AnotherRound(context)
  }

  override def isInFinalRound: Boolean = {
    true
  }
  
}

