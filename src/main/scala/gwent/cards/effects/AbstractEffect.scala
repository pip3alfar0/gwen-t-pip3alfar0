package cl.uchile.dcc
package gwent.cards.effects

import gwent.board.BoardSection
import gwent.cards.Card
import gwent.cards.effects.Effect
import gwent.cards.unit.UnitCard

/** It's an abstract class that represents
 * 
 * */
abstract class AbstractWeatherEffect extends Effect {

  /** Method apply for the weather effects */
  def apply(self: Card, target1: BoardSection, target2: BoardSection): Unit = {
    // do nothing
  }

  /** Method apply for the unit effects */
  def apply(self: Card, target: List[UnitCard]): Unit = {
    // do nothing
  }
  
}
