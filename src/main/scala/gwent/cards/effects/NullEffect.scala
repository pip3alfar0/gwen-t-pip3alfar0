package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.unit.UnitCard
import gwent.cards.Card
import gwent.board.BoardSection


case class NullEffect() extends Effect {
  
  /** Method apply for the weather effects */
  def apply(self: Card, target1: BoardSection, target2: BoardSection): Unit = {
    // do nothing
  }

  /** Method apply for the unit effects */
  def apply(self: Card, target: List[UnitCard]): Unit = {
    // do nothing
  }

}
