package cl.uchile.dcc
package gwent.cards.unit

import gwent.cards.Card

/** It's a trait that represents a unit card of the game.
 *
 * A unit card is defined by a name, a description, an amount of power and a current power.
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

trait UnitCard extends Card {

  /** The power of the unit card.
   * This is an immutable property.
   */
  val power: Int

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[power]] of the card.
   */
  var currentPower: Int = power

  /** The weather power of the card is the changes of the card's power when a weather card is played
   * on the game.
   *
   * Initially set to the base [[currentPower]] of the card.
   */
  var weatherPower: Int = currentPower

}
