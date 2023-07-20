package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** Class representing the end of the game.
 *
 * A `EndGame` is a type of [[GameState]].
 * This state represents the moment when at least one of the player have zero gems, the player with at least one gem won.
 * If non on the players have gems, it's a tie.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class EndGame(context: GameController) extends GameState(context) {

  override def isInEndGame: Boolean = {
    true
  }
  
}
