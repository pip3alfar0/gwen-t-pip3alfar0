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
    for (c <- target1.siege) {
      c.weatherPower = c.currentPower
    }
    for (c <- target2.siege) {
      c.weatherPower = c.currentPower
    }
  }

}
