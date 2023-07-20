package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** Class representing the start of another round.
 *
 * A `AnotherRound` is a type of [[GameState]].
 * This state represents when the players still have at least one gem, so they are going to play another round.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class AnotherRound(context: GameController) extends GameState(context) {

  /** If the computer was the initial player, the player starts */
  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  /** If the player was the initial player, the computer starts */
  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }

  override def isInAnotherRound: Boolean = {
    true
  }

}
