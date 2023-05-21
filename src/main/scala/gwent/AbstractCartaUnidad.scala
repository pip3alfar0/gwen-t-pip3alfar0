package cl.uchile.dcc
package gwent
import java.util.Objects

/** It's an abstract class representing a unity card in the game.
 * This card is defined by a name, a classification and strength.
 *
 * An `AbstractCartaUnidad` is a type of [[Cartas]] that has a power value which contributes to
 * the player's total power in the game.
 * Each unit card starts with its current power equal to its base power.
 *
 * The classification of the unit card can be Cuerpo a Cuerpo, Distancia or Asedio.
 *
 * @constructor Creates a new `AbstractUnitCard` with a specified name, description, and
 *              power.
 *   The name of the card.
 *  description The description of the card, explaining its specific abilities or
 *                    role in the game.
 *  power The base power of the card, indicating the contribution of this card to
 *              the player's total power when unaffected by any special conditions.
 *
 * @author Felipe Alfaro
 * */

abstract class AbstractCartaUnidad protected(val nombre: String, val descripcion: String, val fuerza: Int) extends Cartas {

  /** The current power of the card, which may be affected by various conditions during
   * gameplay.
   * Initially set to the base [[fuerza]] of the card.
   */
  var fuerzaActual: Int = fuerza

  override def hashCode(): Int = {
    Objects.hash(classOf[AbstractCartaUnidad], nombre, descripcion, fuerza)
  }
  
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractCartaUnidad]) {
      val other = obj.asInstanceOf[AbstractCartaUnidad]
      (this eq other) || nombre == other.nombre && descripcion == other.descripcion && fuerza == other.fuerza
    } else {
      false
    }
  }
  
}


/*
//Overriding the function hashCode for CartaUnidad
override def hashCode(): Int = {
  Objects.hash(classOf[CartaUnidad], nombre, descripcion, fuerza)
}

/*
//Overriding the function canEqual for CartaUnidad
override def canEqual(that: Any): Boolean = {
  that.isInstanceOf[CartaUnidad]
}
*/

//Overriding the function equals for CartaUnidad
override def equals(obj: Any): Boolean = {
  if (obj.isInstanceOf[CartaUnidad]) {
    val other = obj.asInstanceOf[CartaUnidad]
    (this eq other) || nombre == other.nombre && descripcion == other.descripcion && fuerza == other.fuerza
  } else {
    false
  }
}




//Overriding the function canEqual for AbstractCartaUnidad
override def canEqual(that: Any): Boolean = {
  that.isInstanceOf[AbstractCartaUnidad]
}

//Overriding the function equals for AbstractCartaUnidad
override def equals(that: Any): Boolean = {
  if (canEqual(that)) {
    val other = that.asInstanceOf[AbstractCartaUnidad]
    (this eq other) || nombre == other.nombre && descripcion == other.descripcion && fuerza == other.fuerza
  } else {
    false
  }
}
*/
