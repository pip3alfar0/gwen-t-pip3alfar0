package cl.uchile.dcc
package gwent

/** It's a class that represents a player in the game
 *
 * @param nombre
 * @param seccionTablero
 * @param contadorGemas
 * @param mazoCartas
 * @param manoCartas
 *
 * */

//the class player get a name, a section on the board, a gem counter (player's life), a card deck and a card hand
class Jugador(private val nombre: String, private val seccionTablero: String, private val contadorGemas: Int, private var mazo: Set[Cartas], private var manoCartas: Set[Cartas]) {

    //Select a card from your hand and place it on the board to perform an action
    /*
    def Jugar(): Unit = {
    }
    */

    //Take a card from the deck and add it to your hand
    def Robar(): Unit = {
        manoCartas = manoCartas + mazo.head
        mazo = mazo - mazo.head
    }

    //Overriding the function hashCode for Jugador
    override def hashCode(): Int = {
        Objects.hash(classOf[Jugador], nombre, seccionTablero, contadorGemas, mazo, manoCartas)
    }

    //Overriding the function equals for Jugador
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Jugador]) {
            val other = obj.asInstanceOf[Jugador]
            (this eq other) || other.nombre == nombre && other.seccionTablero == seccionTablero && other.contadorGemas == contadorGemas
            && other.mazo == mazo && other.manoCartas == manoCartas
        } else {
            false
        }
    }

}
