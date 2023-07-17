package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.BoardSection
import gwent.cards.Card
import gwent.cards.effects.Effect
import gwent.cards.unit.UnitCard

/** It's an abstract class that represents the effects of the cards.
 * */
abstract class AbstractEffect extends Effect {
  
  /** Set the current power to 1 of some list of unit cards */
  def cPower(t: List[UnitCard]): Unit = {
    for (c <- t) {
      c.previousPower = c.currentPower
      c.currentPower = 1
      c.weatherEffect = 1
    }
  }

  /** Applies the clear weather effect to a List of cards */
  def cClear(t: List[UnitCard]): Unit = {
    for (c <- t) {
      // asked if the card has any weather effect
      if (c.weatherEffect != 0) {
        c.previousPower = c.currentPower
        c.currentPower = c.power + c.unitEffect
        c.weatherEffect = 0
      }
    }
  }

  /** Method apply for the weather effects */
  def apply(self: Card, target1: BoardSection, target2: BoardSection): Unit = {
    // do nothing for now
  }

  /** Method apply for the unit effects */
  def apply(self: Card, target: List[UnitCard]): Unit = {
    // do nothing for now
  }
  
}
