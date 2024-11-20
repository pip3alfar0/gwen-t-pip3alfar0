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
  def cPower(t1: List[UnitCard], t2: List[UnitCard]): Unit = {
    for (c <- t1) {
      c.weatherPower = 1
    }
    for (c <- t2) {
      c.weatherPower = 1
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
