package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas.{CartaClima, Cartas}

import gwent.Cartas.Unidad.AbstractCartaUnidad
import gwent.Jugador.Jugador

/** It's a class representing the board of the game.
 * This board is defined by two players and a weather zone.
 *
 * @param j1 Represents a player.
 * @param j2 Represents other player.
 * @param zonaClima The zone where the weather cards are placed.
 *
 * @example
 * {{{
 *
 * }}}
 * @author Felipe Alfaro
 * */

class Tablero(j1: Jugador, j2: Jugador, private var _zonaClima: List[CartaClima]) {

  /** Accessor method for the board's weather zone */
  def zonaClima: List[CartaClima] = _zonaClima

  /** Player play a card and added to the player's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original player's plus the played card.
   *
   * This function modifies the section of the board of the player or the weather zone.
   *
   * @param carta The played card that will be added to the type card's section.
   *              
   * @author Felipe Alfaro
   */
  def Jugar(j: Jugador, card: Cartas): Unit = {
    j.Jugar(card, this)
  }

  /** Player play a weather card and added to the weather zone.
   *
   * Play a weather card and added to the weather zone is defined as the original list of weather cards in that zone plus the played weather card.
   *
   * This function modifies the list of weather cards that are in the weather zone.
   *
   * @param carta The played weather card that will be added to the weather zone.
   *              
   * @author Felipe Alfaro
   */
  def jugarClima(j: Jugador, carta: CartaClima): Unit = {
    _zonaClima = zonaClima :+ carta
  }

}