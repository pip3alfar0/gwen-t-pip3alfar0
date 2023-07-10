package cl.uchile.dcc
package gwent.controller.states

import gwent.player.Player
import gwent.controller.GameController


/** Class representing the start of the game.
 *
 * A `StartGame` is a type of [[GameState]].
 * This start represent the first things to do in the game.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class StartGame(context: GameController) extends GameState(context) {

  /** The player decides which card it's going to be played */
  override def toPlayerTurn(): Unit = {
    context.state = new PlayerTurn(context)
  }

  /** The computer plays randomly */
  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
  }

}


