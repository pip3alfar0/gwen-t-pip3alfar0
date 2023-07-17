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

  /** The previous power of the card is the previous current power before suffered changes.
   *
   * Initially set as 0.
   */
  var previousPower: Int = 0


  /** The weather effect it's the way to know if the card suffered changes from weather cards.
   *
   * Initially set as 0 and changes to 1 if some weather effect applies on the card.
   */
  var weatherEffect: Int = 0

  /** The unit effect is the way to know how many changes suffered the card from unit card effect.
   *
   * Initially set as 0.
   */
  var unitEffect: Int = 0

}
