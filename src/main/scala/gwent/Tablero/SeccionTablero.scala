package cl.uchile.dcc
package gwent.Tablero

import gwent.Cartas.Cartas
import gwent.Cartas.Unidad.{Asedio, CuerpoACuerpo, Distancia}

/** It's a class that represents a the player's section of the board. 
 * 
 * This player's section board is defined by a list of siege combat cards, a list of close combat cards and a list of ranged combat cards.
 *
 * @param distancia The list of ranged combat cards.
 * @param asedio The list of siege combat cards.
 * @param cuerpoACuerpo The list of close combat cards.
 *
 * @author Felipe Alfaro
 * */

class SeccionTablero(var distancia: List[Distancia] = List(), var asedio: List[Asedio] = List(), 
                     var cuerpoACuerpo: List[CuerpoACuerpo] = List()) {

  /** Play a ranged combat card and added to the ranged combat card zone.
   *
   * Play a ranged combat card and added to the ranged combat card zone is defined as the original list of ranged combat cards in that zone plus the played ranged combat card.
   *
   * This function modifies the list of ranged combat cards that are in the ranged combat zone.
   *
   * @param carta The played ranged combat card that will be added to the ranged combat zone.
   */
  def jugarDistancia(carta: Distancia): Unit = {
    distancia = carta :: distancia
  }

  /** Play a siege combat card and added to the siege combat card zone.
   *
   * Play a siege combat card and added to the siege combat card zone is defined as the original list of siege combat cards in that zone plus the played siege combat card.
   *
   * This function modifies the list of siege combat cards that are in the siege combat zone.
   *
   * @param carta The played siege combat card that will be added to the siege combat zone.
   */
  def jugarAsedio(carta: Asedio): Unit = {
    asedio = carta :: asedio
  }

  /** Play a close combat card and added to the close combat card zone.
   *
   * Play a close combat card and added to the close combat card zone is defined as the original list of close combat cards in that zone plus the played close combat card.
   *
   * This function modifies the list of close combat cards that are in the close combat zone.
   *
   * @param carta The played close combat card that will be added to the close combat zone.
   */
  def jugarCuerpoACuerpo(carta: CuerpoACuerpo): Unit = {
    cuerpoACuerpo = carta :: cuerpoACuerpo
  }
  
}
