package cl.uchile.dcc
package gwent.cards

import gwent.player.Player
import gwent.board.Board
import gwent.cards.effects.Effect

/** It's a trait that represents a card of the game.
 *
 * A card is defined by a name and a description.
 * This trait serves as a common interface for all the types of cards and ensures that every card will have these basic properties.
 *
 * The ``val`` keyword in the property declarations indicates that these properties are immutable 
 * -- once a card has been created with a certain name and description, these
 * cannot be changed.
 * This reflects the real-world behaviour of game cards, which have fixed names and
 * descriptions printed on them. 
 *
 * The actual content of these properties, as well as any additional properties or behaviours, are to be defined in the concrete
 * classes that extend this trait.
 * */

trait Card {

  /** The name of the card.
   * This is an immutable property.
   */
  val name: String

  /** A description of the card's properties or effects.
   * This is an immutable property.
   */
  val description: String

  /** The effect of the card.
   * This is an immutable property.
   */
  val effect: Effect

  /** Player play a card and added to the card's section.
   * 
   * @param j The player.
   * @param t The board.
   *
   * @author Felipe Alfaro
   */
  def Play(j: Player, t: Board): Unit

}