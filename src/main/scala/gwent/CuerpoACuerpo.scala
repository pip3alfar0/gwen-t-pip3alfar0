package cl.uchile.dcc
package gwent

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
 *
 * @author Felipe Alfaro
 */

class CuerpoACuerpo(nombre: String, descripcion: String, fuerza: Int) extends AbstractCartaUnidad(nombre, descripcion, fuerza) {
  
  override def equals(obj: Any): Boolean = obj match {
    case other: CuerpoACuerpo =>
      super.equals(other)
    case _ => false
  }

}
