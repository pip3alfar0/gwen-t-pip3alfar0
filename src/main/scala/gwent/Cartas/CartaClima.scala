package cl.uchile.dcc
package gwent
import cl.uchile.dcc.gwent.Cartas.Cartas

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

  // recibe una carta y un tablero, y agrega en la zona del tablero la carta
  def add(): Unit = {

  }

  /**
   *
   * @param j
   */
  override def Jugar(j: Jugador): Unit = {
    
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
