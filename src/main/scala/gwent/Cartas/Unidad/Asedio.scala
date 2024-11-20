package cl.uchile.dcc
package gwent.Cartas.Unidad

import gwent.Cartas.Unidad.AbstractCartaUnidad

import gwent.Jugador.Jugador
import gwent.Tablero.Tablero

/** Class representing a siege combat unit card in the game.
 *
 * A `SiegeCombatCard` is a type of [[AbstractCartaUnidad]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `SiegeCombatCard` with a specified name, description, and
 *              power.
 * @param nombre The name of the Card.
 * @param descripcion The description of the card.
 * @param fuerza The initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 * @author Felipe Alfaro
 */

class Asedio(nombre: String, descripcion: String, fuerza: Int) extends AbstractCartaUnidad(nombre, descripcion, fuerza) {

  /** Play a siege combat card and added to the siege combat card zone.
   *
   * Play a siege combat card and added to the siege combat card zone is defined as the original list of siege combat cards in that zone plus the played siege combat card.
   *
   * This function modifies the list of siege combat cards that are in the siege combat zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Jugar(j: Jugador, t: Tablero): Unit = {
    j.seccionTablero.jugarAsedio(this)
  }

  override def equals(obj: Any): Boolean = obj match {
    case other: Asedio =>
      super.equals(other)
    case _ => false
  }

}
