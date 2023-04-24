package cl.uchile.dcc
package gwent
import java.util.Objects

/** It's a class representing a weather card in the game.
 * This card is defined by a name and an ability.
 *
 * @param nombre The name of the Card.
 * @param habilidad The ability of the card.
 *
 * @example
 * {{{
 *   val carta2 = new CartaClima("carta2", "a")
 * }}}
 *
 * @author Felipe Alfaro
 * */

class CartaClima(val nombre: String, val habilidad: String) extends Cartas {

  //Overriding the function hashCode for CartaClima
  override def hashCode(): Int = {
    Objects.hash(classOf[CartaClima], nombre, habilidad)
  }

  /*
  //Overriding the function canEqual for CartaClima
  override def canEqual(that: Any): Boolean = {
    that.isInstanceOf[CartaClima]
  }
  */

  //Overriding the function equals for CartaClima
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CartaClima]) {
      val other = obj.asInstanceOf[CartaClima]
      (this eq other) || nombre == other.nombre && habilidad == other.habilidad
    } else {
      false
    }
  }

}
