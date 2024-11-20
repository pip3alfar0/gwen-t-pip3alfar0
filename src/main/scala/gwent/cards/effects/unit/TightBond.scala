package cl.uchile.dcc
package gwent.cards.effects.unit

import gwent.cards.Card
import gwent.cards.unit.UnitCard
import gwent.cards.effects.AbstractEffect

/** It's a class that represents the unit card effect called Close Bond
 *
 * */
case class TightBond() extends AbstractEffect {

  /** Duplicates the current power of all the cards on the board's section where the card was played 
   * who are called exactly as the played card */
  override def apply(self: Card, target: List[UnitCard]): Unit = {
    for (c <- target) {
      if (self.name == c.name) {
        c.previousPower = c.currentPower
        c.currentPower *= 2
        c.unitEffect += (c.currentPower - c.previousPower)
      }
    }
  }

}
