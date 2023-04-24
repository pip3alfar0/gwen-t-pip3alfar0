package cl.uchile.dcc
package gwent
import java.util.Objects

/** It's a class representing a unity card in the game.
 * This card is defined by a name, a classification and strength.
 *
 * @param nombre The name of the Card.
 * @param clasificacion The classification of the Card.
 * @param fuerza The strength of the Card.
 * 
 * @example
 * {{{
 *   val carta1 = new CartaUnidad("carta1", "Asedio", 50)
 * }}}
 *
 * @author Felipe Alfaro
 * */

//extends AbstractCartas(nombre)

class CartaUnidad(val nombre: String, val clasificacion: String, val fuerza: Int) extends Cartas { // classification can be Cuerpo a Cuerpo, Distancia or Asedio

  //Overriding the function hashCode for CartaUnidad
  override def hashCode(): Int = {
    Objects.hash(classOf[CartaUnidad], nombre, clasificacion, fuerza)
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
      (this eq other) || nombre == other.nombre && clasificacion == other.clasificacion && fuerza == other.fuerza
    } else {
      false
    }
  }

}
