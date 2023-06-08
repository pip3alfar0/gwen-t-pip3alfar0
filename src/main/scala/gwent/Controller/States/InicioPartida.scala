package cl.uchile.dcc
package gwent.Controller.States

import gwent.Jugador.Jugador
import gwent.Controller.GameController


/** Class representing the start of the game.
 *
 * A `StartGame` is a type of [[EstadoJuego]].
 * This start represent the first things to do in the game.
 *
 * @param context The context of the game.
 * @author Felipe Alfaro
 */
class InicioPartida(context: GameController) extends EstadoJuego(context) {

  /** The player decides which card it's going to be played */
  override def toJugadorJuega(): Unit = {
    context.estado = new JugadorJuega(context)
    //context.jugar()
  }

  /** debe jugar aleatoriamente*/
  override def toComputadorJuega(): Unit = {
    context.estado = new ComputadorJuega(context)
    //context.jugar()
  }

}


