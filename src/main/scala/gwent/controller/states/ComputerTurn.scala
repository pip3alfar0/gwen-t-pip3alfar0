package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController

/** Class representing the computer's turn.
 *
 * A `ComputerTurn` is a type of [[GameState]].
 * This state represents the computer's turn, he decide if he play or pass.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class ComputerTurn(context: GameController) extends GameState(context) {

  /** The computer decided to pass */
  override def toOtherTurn(): Unit = {
    context.state = new OtherTurn(context)
  }

  /** The computer played a card, so it's the player's turn */
  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  override def pass(): Unit = {
    toOtherTurn()
  }

  override def changeTurn(): Unit = {
    toPlayerTurn()
  }

  override def isInComputerTurn: Boolean = {
    true
  }

}
