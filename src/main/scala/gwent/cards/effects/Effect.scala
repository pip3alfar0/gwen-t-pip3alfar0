package cl.uchile.dcc
package gwent.cards.effects

import gwent.cards.Card
import gwent.cards.unit.UnitCard
import gwent.board.BoardSection

/** It's a trait that represents the effect of the cards in the game.
 *
 * An effect changed some property of the target cards.
 *
 * This trait serves as a common interface for the methods
 * 
 * 
 *
 * This trait serves as a common interface for all the types of unit cards and ensures that every card will have these basic properties.
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

trait Effect {
  def apply(self: Card, target: List[UnitCard]): Unit
  def apply(self: Card, target1: BoardSection, target2: BoardSection): Unit
}
