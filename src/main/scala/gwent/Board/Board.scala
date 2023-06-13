package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas.{WeatherCard, Card}

import gwent.Cartas.Unidad.AbstractUnitCard
import gwent.Jugador.Player

/** It's a class representing the board of the game.
 * This board is defined by two players and a weather zone.
 *
 * @param j1 Represents a player.
 * @param j2 Represents other player.
 * @param weatherZone The zone where the weather cards are placed.
 *
 * @example
 * {{{
 *
 * }}}
 * @author Felipe Alfaro
 * */

class Board(j1: Player, j2: Player, private var _weatherZone: List[WeatherCard]) {

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
  def Play(j: Player, card: Card): Unit = {
    j.Play(card, this)
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
  def playWeather(j: Player, card: WeatherCard): Unit = {
    _weatherZone = weatherZone :+ card
  }

}