package cl.uchile.dcc
package gwent.Jugador

import gwent.Cartas.Cartas
import gwent.Tablero.{SeccionTablero, Tablero}
import java.util.Objects

/** It's a class that represents a player in the game.
 * This player is defined by a name, a board section, a gem counter, a deck of cards and a hand of cards.
 *
 * The gem counter, deck and hand are private variables, but can be accessed via their corresponding
 * getter methods.
 * We use immutable lists instead of mutable ones to represent the deck and the hand.
 * This is a common practice in functional programming and in Scala in particular.
 * By using immutable data structures, we can avoid potential side effects caused by
 * mutable state and make our code safer and easier to reason about.
 *
 * @param nombre The name of the Player.
 * @param seccionTablero The board section of the Player.
 * @param contadorGemas The gem counter, represents the Player's life.
 * @param mazo The deck of cards are the cards in the board.
 * @param manoCartas The hand of cards are the Player's cards.
 *
 * @example
 * {{{
 *      jugador = new Jugador("Constanza", new seccionTablero(List[Cartas](carta1), List[Cartas](carta3), List[Cartas](carta10, carta12)), 100, List[Cartas](carta2), List[Cartas]())
 * }}}
 *
 * @author Felipe Alfaro
 * */

class Jugador(val nombre: String, var seccionTablero: SeccionTablero, private val _contadorGemas: Int, private var _mazo: List[Cartas],
              private var _manoCartas: List[Cartas]) {

    /** Accesor methos for the player's gem counter */
    def contadorGemas: Int = _contadorGemas

    /** Accessor method for the player's deck */
    def mazo: List[Cartas] = _mazo

    /** Accessor method for the player's hand */
    def manoCartas: List[Cartas] = _manoCartas

    /** The gem counter can not be negative */
    require(contadorGemas >= 0, "The gem counter can not be less than zero")

    /** Select a card from your hand and place it on the board to perform an action.
     *
     * Play a card of the hand is defined as the original hand of cards less the played card and now the card's section 
     * are the same cards with the played card.
     *
     * This function modifies the player's section on the board or the weather zone and the hand of cards when the card is drawn.
     *
     * @param card The played card.
     * @param board The board where the player is playing.
     * @example
     * 
     * @author Felipe Alfaro
     */
    def Jugar(card: Cartas, board: Tablero): Unit = {
        require(manoCartas.contains(card), "The card is not on the player's hand")
        _manoCartas = manoCartas.filterNot(_ eq card)
        card.Jugar(this, board)
    }
    
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
    def Robar(): Cartas = {
        val card = mazo.head
        _mazo = mazo.tail
        _manoCartas = card :: manoCartas
        card
    }

    /** Shuffles the player's deck.
     *
     * The order of cards in the player's deck is randomized.
     * This is achieved by creating a new, shuffled list and reassigning _deck to it, rather
     * than by modifying the original list.
     */
    def mezclarMazo(): Unit = {
        _mazo = scala.util.Random.shuffle(_mazo)
    }

    override def hashCode(): Int = {
        Objects.hash(classOf[Jugador], nombre, seccionTablero, contadorGemas, mazo, manoCartas)
    }

    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Jugador]) {
            val other = obj.asInstanceOf[Jugador]
            (this eq other) || other.nombre == nombre && other.seccionTablero == seccionTablero && other.contadorGemas == contadorGemas && other.mazo == mazo && other.manoCartas == manoCartas
        } else {
            false
        }
    }

}
