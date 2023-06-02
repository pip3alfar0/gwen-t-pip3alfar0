package cl.uchile.dcc
package gwent.Cartas

import gwent.Cartas.Cartas

import gwent.Jugador.Jugador
import gwent.Tablero.Tablero

import java.util.Objects

/** It's a class representing a weather card in the game.
 *
 *
 * @param nombre The name of the Card.
 * @param descripcion The description of the card.
 *
 * @example
 * {{{
 *   val carta2 = new CartaClima("carta2", "a")
 * }}}
 *
 * @author Felipe Alfaro
 * */

class CartaClima(val nombre: String, val descripcion: String) extends Cartas {
  
  /** Player play a weather card and added to the weather zone.
   *
   * Play a weather card and added to the weather zone is defined as the original list of weather cards in that zone
   * plus the played weather card.
   *
   * This function modifies the list of weather cards that are in the weather zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Jugar(j: Jugador, t: Tablero): Unit = {
    t.jugarClima(j, this)
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[CartaClima], nombre, descripcion)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CartaClima]) {
      val other = obj.asInstanceOf[CartaClima]
      (this eq other) || nombre == other.nombre && descripcion == other.descripcion
    } else {
      false
    }
  }

}
