package cl.uchile.dcc
package gwent.Controller.States

import gwent.Player.Player
import gwent.Controller.GameController


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
    //context.jugar()
  }

  /** debe jugar aleatoriamente*/
  override def toComputerTurn(): Unit = {
    context.state = new ComputerTurn(context)
    //context.jugar()
  }

}


