package cl.uchile.dcc
package gwent.cards.effects.unit

import gwent.cards.Card
import gwent.cards.unit.UnitCard
import gwent.cards.effects.AbstractEffect

/** It's a class that represents the unit card effect called Morale Booster
 *
 * */
case class MoraleBooster() extends AbstractEffect {

  /** The power of all the cards on the board's section where the card was played increment 1 */
  override def apply(self: Card, target: List[UnitCard]): Unit = {
    for (c <- target) {
      c.currentPower += 1
    }
  }

}
