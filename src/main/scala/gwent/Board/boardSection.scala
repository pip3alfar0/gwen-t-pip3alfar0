package cl.uchile.dcc
package gwent.Board

import gwent.Cards.Card
import gwent.Cards.Unit.{SiegeCombatCard, CloseCombatCard, RangedCombatCard}

/** It's a class that represents a the player's section of the board. 
 * 
 * This player's section board is defined by a list of siege combat cards, a list of close combat cards and a list of ranged combat cards.
 *
 * @param ranged The list of ranged combat cards.
 * @param siege The list of siege combat cards.
 * @param close The list of close combat cards.
 *
 * @author Felipe Alfaro
 * */

class boardSection(var ranged: List[RangedCombatCard] = List(), var siege: List[SiegeCombatCard] = List(),
                   var close: List[CloseCombatCard] = List()) {

  /** Play a ranged combat card and added to the ranged combat card zone.
   *
   * Play a ranged combat card and added to the ranged combat card zone is defined as the original list of ranged combat cards in that zone plus the played ranged combat card.
   *
   * This function modifies the list of ranged combat cards that are in the ranged combat zone.
   *
   * @param card The played ranged combat card that will be added to the ranged combat zone.
   */
  def PlayRanged(card: RangedCombatCard): Unit = {
    ranged = card :: ranged
  }

  /** Play a siege combat card and added to the siege combat card zone.
   *
   * Play a siege combat card and added to the siege combat card zone is defined as the original list of siege combat cards in that zone plus the played siege combat card.
   *
   * This function modifies the list of siege combat cards that are in the siege combat zone.
   *
   * @param card The played siege combat card that will be added to the siege combat zone.
   */
  def PlaySiege(card: SiegeCombatCard): Unit = {
    siege = card :: siege
  }

  /** Play a close combat card and added to the close combat card zone.
   *
   * Play a close combat card and added to the close combat card zone is defined as the original list of close combat cards in that zone plus the played close combat card.
   *
   * This function modifies the list of close combat cards that are in the close combat zone.
   *
   * @param card The played close combat card that will be added to the close combat zone.
   */
  def PlayClose(card: CloseCombatCard): Unit = {
    close = card :: close
  }
  
}
