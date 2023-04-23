package cl.uchile.dcc
package gwent
import java.util.Objects

/** It's a class that represents a card of the game
 *
 * @param nombre
 * @param clasificacion
 *
 * */

//Cards get a name and a classification
class Cartas(private val nombre: String, private val clasificacion: String) { //The classification can be "Unity" or "Weather"



  //Overriding the function hashCode for Cartas
  override def hashCode(): Int = {
    Objects.hash(classOf[Cartas], nombre, clasificacion)
  }

  //Overriding the function equals for Cartas
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Cartas]) {
      val other = obj.asInstanceOf[Cartas]
      (this eq other) || other.nombre == nombre && other.clasificacion == clasificacion
    } else {
      false
    }
  }

}
