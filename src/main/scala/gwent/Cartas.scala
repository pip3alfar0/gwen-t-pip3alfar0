package cl.uchile.dcc
package gwent

/**
 *
 * @param nombre
 * @param clasificacion
 *
 * */

//Cards get a name and a classification
class Cartas(private val nombre: String, private val clasificacion: String) { //The classification can be "Unity" or "Weather"
  
  
  
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Cartas]) {
      val other = obj.asInstanceOf[Cartas]
      (this eq other) || other.nombre == nombre && other.clasificacion == clasificacion
    } else {
      false
    }
  }

}
