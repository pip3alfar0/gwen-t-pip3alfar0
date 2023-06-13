package cl.uchile.dcc
package gwent.Cards.Unidad

import gwent.Cards.Unidad.AbstractUnitCard

import gwent.Player.Player
import gwent.Board.Board

/** Class representing a close combat unit card in the game.
 *
 * A `CloseCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `CloseCombatCard` with a specified name, description, and
 *              power.
 * @param name The name of the Card.
 * @param description The description of the card.
 * @param power The initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 * @author Felipe Alfaro
 */

class CloseCombatCard(name: String, description: String, power: Int) extends AbstractUnitCard(name, description, power) {

  /** Play a close combat card and added to the close combat card zone.
   *
   * Play a close combat card and added to the close combat card zone is defined as the original list of close combat cards in that zone plus the played close combat card.
   *
   * This function modifies the list of close combat cards that are in the close combat zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Play(j: Player, t: Board): Unit = {
    j.boardSection.PlayClose(this)
  }
  
  override def equals(obj: Any): Boolean = obj match {
    case other: CloseCombatCard =>
      super.equals(other)
    case _ => false
  }

}
