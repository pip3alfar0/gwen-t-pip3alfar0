package cl.uchile.dcc
package gwent.cards.effects.weather

import gwent.cards.Card
import gwent.board.BoardSection
import gwent.cards.effects.AbstractEffect

/** It's a class that represents the weather effect called Torrential Rain
 * */
case class ClearWeather() extends AbstractEffect {

  /** The effect of all the weather cards are null */
  override def apply(self: Card, target1: BoardSection, target2: BoardSection): Unit = {
    val t1s = target1.siege
    val t2s = target2.siege
    val t1r = target1.ranged
    val t2r = target2.ranged
    val t1c = target1.close
    val t2c = target2.close
    cClear(t1s)
    cClear(t2s)
    cClear(t1r)
    cClear(t2r)
    cClear(t1c)
    cClear(t2c)
  }

}
