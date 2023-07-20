package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** Class representing the player's turn.
 *
 * A `PlayerTurn` is a type of [[GameState]].
 * This state represents the player's turn, he decide if he play or pass.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class PlayerTurn(context: GameController) extends GameState(context) {

  /** The player decided to pass */
  override def toOtherTurn(): Unit = {
    context.state = new OtherTurn(context)
  }

  /** The player played a card, so it's the computer's turn */
  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }

  override def pass(): Unit = {
    toOtherTurn()
  }

  override def changeTurn(): Unit = {
    toComputerTurn()
  }

  override def isInPlayerTurn: Boolean = {
    true
  }

}
