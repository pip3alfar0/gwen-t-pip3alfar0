package cl.uchile.dcc
package gwent.board

import gwent.cards.{WeatherCard, Card}

import gwent.cards.unit.AbstractUnitCard
import gwent.player.Player

/** It's a class representing the board of the game.
 * This board is defined by two players and a weather zone.
 *
 * @param p1 Represents a player.
 * @param p2 Represents other player.
 * @param _weatherZone The zone where the weather cards are placed.
 *
 * @example
 * {{{
 *
 * }}}
 * @author Felipe Alfaro
 * */

class Board(p1: Player, p2: Player, private var _weatherZone: List[WeatherCard]) {

  /** Accessor method for the board's weather zone */
  def weatherZone: List[WeatherCard] = _weatherZone

  /** Player play a card and added to the player's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original player's plus the played card.
   *
   * This function modifies the section of the board of the player or the weather zone.
   *
   * @param card The played card that will be added to the type card's section.
   *              
   * @author Felipe Alfaro
   */
  def Play(p: Player, card: Card): Unit = {
    p.Play(card, this)
    card.effect(card, p1.boardSection, p2.boardSection)
  }

  /** Player play a weather card and added to the weather zone.
   *
   * Play a weather card and added to the weather zone is defined as the original list of weather cards in that zone plus the played weather card.
   *
   * This function modifies the list of weather cards that are in the weather zone.
   *
   * @param card The played weather card that will be added to the weather zone.
   *              
   * @author Felipe Alfaro
   */
  def playWeather(p: Player, card: WeatherCard): Unit = {
    _weatherZone = weatherZone :+ card
    //card.effect()
  }

}