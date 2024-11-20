package cl.uchile.dcc
package gwent.cards

import gwent.cards.Card
import gwent.player.Player
import gwent.board.Board

import cl.uchile.dcc.gwent.cards.effects.Effect

import java.util.Objects


/** It's a class representing a weather card in the game.
 *
 * @param name The name of the Card.
 * @param description The description of the card.
 *
 * @example
 * {{{
 *   val card2 = new WeatherCard("card2", "a")
 * }}}
 *
 * @author Felipe Alfaro
 * */

class WeatherCard(val name: String, val description: String, val effect: Effect) extends Card {
  
  /** Player play a weather card and added to the weather zone.
   *
   * Play a weather card and added to the weather zone is defined as the original list of weather cards in that zone
   * plus the played weather card.
   *
   * This function modifies the list of weather cards that are in the weather zone.
   *
   * @param j The player.
   * @param t The player's board.
   */
  override def Play(j: Player, t: Board): Unit = {
    t.playWeather(j, this)
  }

  override def hashCode(): Int = {
    Objects.hash(classOf[WeatherCard], name, description)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      val other = obj.asInstanceOf[WeatherCard]
      (this eq other) || name == other.name && description == other.description
    } else {
      false
    }
  }

}
