package cl.uchile.dcc
package gwent
import java.util.Objects

/** It's a class that represents a player in the game.
 * This player is denifed by a name, a board section, a gem counter, a deck of cards and a hand of cards.
 *
 * @param nombre The name of the Player.
 * @param seccionTablero The board section of the Player.
 * @param contadorGemas The gem counter, represents the Player's life.
 * @param mazoCartas The deck of cards are the cards in the board.
 * @param manoCartas The hand of cards are the Player's cards.
 *
 * @example
 * {{{
 *   jugador1 = new Jugador("Constanza", "bobaboba", 100, Set[Cartas](new CartaUnidad("carta1", "Asedio", 50)), Set[Cartas]())
 * }}}
 *
 * @author Felipe Alfaro
 * */

class Jugador(val nombre: String, val seccionTablero: String, val contadorGemas: Int, var mazo: Set[Cartas], var manoCartas: Set[Cartas]) {

    //Select a card from your hand and place it on the board to perform an action
    /*
    def Jugar(): Unit = {
    }
    */

    /** Take a card from the deck and add it to your hand.
     *
     * Steal a card of the deck is defined as the original deck of cards less the stolen card and now the hand of
     * Player's cards are the same cards with the stolen deck's card.
     *
     * This function modifies the deck of cards and the hand of cards when the card is drawn.
     *
     * @example
     * {{{
     *  val jugador1 = new Jugador("Constanza", "bobaboba", 100, Set[Cartas](), Set[Cartas](new CartaUnidad("carta1", "Asedio", 50)))
     *  jugador1.Robar()
     * }}}
     */
    def Robar(): Unit = {
        manoCartas = manoCartas + mazo.head
        mazo = mazo - mazo.head
    }

    //Overriding the function hashCode for Jugador
    override def hashCode(): Int = {
        Objects.hash(classOf[Jugador], nombre, seccionTablero, contadorGemas, mazo, manoCartas)
    }

    //Overriding the function equals for Cartas
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Jugador]) {
            val other = obj.asInstanceOf[Jugador]
            (this eq other) || other.nombre == nombre && other.seccionTablero == seccionTablero && other.contadorGemas == contadorGemas && other.mazo == mazo && other.manoCartas == manoCartas
        } else {
            false
        }
    }

}
