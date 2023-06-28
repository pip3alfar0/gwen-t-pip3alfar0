package cl.uchile.dcc
package gwent.Player

import gwent.Cards.Card
import gwent.Board.{boardSection, Board}
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
 * @param name The name of the Player.
 * @param boardSection The board section of the Player.
 * @param gemCounter The gem counter, represents the Player's life.
 * @param deck The deck of cards are the cards in the board.
 * @param handCards The hand of cards are the Player's cards.
 *
 * @example
 * {{{
 *      player = new Player("Constanza", new boardSection(List[Card](card1), List[Card](card3), List[Card](card10, card12)), 100, List[Card](card2), List[Card]())
 * }}}
 *
 * @author Felipe Alfaro
 * */

class Player(val name: String, var boardSection: boardSection, private val _gemCounter: Int, private var _deck: List[Card],
             private var _handCards: List[Card]) {

    /** Accesor methos for the player's gem counter */
    def gemCounter: Int = _gemCounter

    /** Accessor method for the player's deck */
    def deck: List[Card] = _deck

    /** Accessor method for the player's hand */
    def handCards: List[Card] = _handCards

    /** The gem counter can not be negative */
    require(gemCounter >= 0, "The gem counter can not be less than zero")

    /** Select a card from your hand and place it on the board to perform an action.
     *
     * Play a card of the hand is defined as the original hand of cards less the played card and now the card's section 
     * are the same cards with the played card.
     *
     * This function modifies the player's section on the board or the weather zone and the hand of cards when the card is drawn.
     *
     * @param card The played card.
     * @param board The board where the player is playing.
     * 
     * @author Felipe Alfaro
     */
    def Play(card: Card, board: Board): Unit = {
        require(handCards.contains(card), "The card is not on the player's hand")
        _handCards = handCards.filterNot(_ eq card)
        card.Play(this, board)
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
     *  val player1 = new Player("Constanza", "bobaboba", 100, Set[Card](), Set[Card](new SiegeCombaCard("card1", "SiegeCombaCard", 50)))
     *  player1.Steal()
     * }}}
     */
    def Steal(): Card = {
        val card = deck.head
        _deck = deck.tail
        _handCards = card :: handCards
        card
    }

    /** Shuffles the player's deck.
     *
     * The order of cards in the player's deck is randomized.
     * This is achieved by creating a new, shuffled list and reassigning _deck to it, rather
     * than by modifying the original list.
     */
    def shuffleDeck(): Unit = {
        _deck = scala.util.Random.shuffle(_deck)
    }

    override def hashCode(): Int = {
        Objects.hash(classOf[Player], name, boardSection, gemCounter, deck, handCards)
    }

    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Player]) {
            val other = obj.asInstanceOf[Player]
            (this eq other) || other.name == name && other.boardSection == boardSection && other.gemCounter == gemCounter && other.deck == deck && other.handCards == handCards
        } else {
            false
        }
    }

}
