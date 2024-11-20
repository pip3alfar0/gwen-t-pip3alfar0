package cl.uchile.dcc
package gwent.cards.unit

import gwent.cards.unit.AbstractUnitCard
import gwent.player.Player
import gwent.board.Board

import cl.uchile.dcc.gwent.cards.effects.Effect

/** Class representing a ranged combat unit card in the game.
 *
 * A `RangedCombatCard` is a type of [[AbstractUnitCard]].
 * These cards represent troops that engage in close combat on the battlefield.
 * As per the game's rules, these cards can only be placed in the close combat zone.
 *
 * @constructor Creates a new `RangedCombatCard` with a specified name, description, and
 *              power.
 * @param name The name of the Card.
 * @param description The description of the card.
 * @param power The initial power value of the card, which also corresponds to the
 *              strength of the troop it represents.
 * @author Felipe Alfaro
 */

class RangedCombatCard(name: String, description: String, 
                       power: Int, effect: Effect) extends AbstractUnitCard(name, description, power, effect) {

  /** Play a ranged combat card and added to the ranged combat card zone.
   *
   * Play a ranged combat card and added to the ranged combat card zone is defined as the original list of ranged combat cards in that zone plus the played ranged combat card.
   *
   * This function modifies the list of ranged combat cards that are in the ranged combat zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Play(j: Player, t: Board): Unit = {
    j.boardSection.PlayRanged(this)
  }

  override def equals(obj: Any): Boolean = obj match {
    case other: RangedCombatCard =>
      super.equals(other)
    case _ => false
  }

}
