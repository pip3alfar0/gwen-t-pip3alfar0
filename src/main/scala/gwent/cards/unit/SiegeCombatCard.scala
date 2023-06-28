package cl.uchile.dcc
package gwent.cards.unit

import gwent.cards.unit.AbstractUnitCard
import gwent.player.Player
import gwent.board.Board

import cl.uchile.dcc.gwent.cards.effects.Effect

/** Class representing a siege combat unit card in the game.
 *
 * A `SiegeCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `SiegeCombatCard` with a specified name, description, and
 *              power.
 * @param name The name of the Card.
 * @param description The description of the card.
 * @param power The initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 * @author Felipe Alfaro
 */

class SiegeCombatCard(name: String, description: String, 
                      power: Int, effect: Effect) extends AbstractUnitCard(name, description, power, effect) {

  /** Play a siege combat card and added to the siege combat card zone.
   *
   * Play a siege combat card and added to the siege combat card zone is defined as the original list of siege combat cards in that zone plus the played siege combat card.
   *
   * This function modifies the list of siege combat cards that are in the siege combat zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Play(j: Player, t: Board): Unit = {
    j.boardSection.PlaySiege(this)
  }

  override def equals(obj: Any): Boolean = obj match {
    case other: SiegeCombatCard =>
      super.equals(other)
    case _ => false
  }

}
