package cl.uchile.dcc
package gwent.Cartas.Unidad

import gwent.Cartas.Unidad.AbstractCartaUnidad

import gwent.Jugador.Jugador
import gwent.Tablero.Tablero

/** Class representing a close combat unit card in the game.
 *
 * A `CloseCombatCard` is a type of [[AbstractCartaUnidad]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `CloseCombatCard` with a specified name, description, and
 *              power.
 * @param nombre The name of the Card.
 * @param descripcion The description of the card.
 * @param fuerza The initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 * @author Felipe Alfaro
 */

class CuerpoACuerpo(nombre: String, descripcion: String, fuerza: Int) extends AbstractCartaUnidad(nombre, descripcion, fuerza) {

  /** Play a close combat card and added to the close combat card zone.
   *
   * Play a close combat card and added to the close combat card zone is defined as the original list of close combat cards in that zone plus the played close combat card.
   *
   * This function modifies the list of close combat cards that are in the close combat zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Jugar(j: Jugador, t: Tablero): Unit = {
    j.seccionTablero.jugarCuerpoACuerpo(this)
  }
  
  override def equals(obj: Any): Boolean = obj match {
    case other: CuerpoACuerpo =>
      super.equals(other)
    case _ => false
  }

}
