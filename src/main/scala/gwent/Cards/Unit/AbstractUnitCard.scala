package cl.uchile.dcc
package gwent.Cards.Unit

import gwent.Cards.Card

import java.util.Objects

/** It's an abstract class representing a unity card in the game.
 * This card is defined by a name, a classification and strength.
 *
 * An `AbstractUnitCard` is a type of [[Card]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * The classification of the unit card can be CloseCombat, RangedCombat or SiegeCombat.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, description, and
 *              power.
 *   The name of the card.
 *  description The description of the card, explaining its specific abilities or
 *                    role in the game.
 *  power The base power of the card, indicating the contribution of this card to
 *              the player's total power when unaffected by any special conditions.
 * @author Felipe Alfaro
 * */

abstract class AbstractUnitCard protected(val name: String, val description: String, val power: Int) extends Card {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  var currentPower: Int = power

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractUnitCard], name, description, power)
  }
  
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractUnitCard]) {
      val other = obj.asInstanceOf[AbstractUnitCard]
      (this eq other) || name == other.name && description == other.description && power == other.power
    } else {
      false
    }
  }
  
}
