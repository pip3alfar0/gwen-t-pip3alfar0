package cl.uchile.dcc
package gwent.cards.effects.weather

import gwent.cards.Card
import gwent.board.BoardSection
import gwent.cards.effects.AbstractEffect

/** It's a class that represents the weather effect called Torrential Rain
 *
 * */
case class BitingFrost() extends AbstractEffect {

  /** The power of all the close combat cards on the board is 1 */
  override def apply(self: Card, target1: BoardSection, target2: BoardSection): Unit = {
    val t1 = target1.close
    val t2 = target2.close
    cPower(t1, t2)
  }

}
