package cl.uchile.dcc
package gwent.Controller

import gwent.Controller.States.{GameState, StartGame}

import gwent.Cards.Card
import gwent.Player.Player
import gwent.Board.{boardSection, Board}


class GameController {
  private var board: Option[Board] = None
  private var currentPlayer: Option[Player] = None
  private var previousPlayer: Option[Player] = None
  private var playerSection: Option[boardSection] = None
  private var computerSection: Option[boardSection] = None
  private val card: Option[Card] = None

  //private var mazoJugador = List.empty[Cartas]
  //private var mazoComputador = List.empty[Cartas]
  var state: GameState = new StartGame(this)


  /** Player didn't play in his turn, so it's the computer's turn.
   * But, if computer passed first, it means the end of the round.
   *
   * Pass the turn is defined as leaving the board the same as it arrived to the player.
   *
   * This function leaves the board exactly the same as it arrived to the player, and now it's the computer's turn to play as many times the computer wants.
   * But, if computer passed first, it means the end of the round and maybe the end of the game.
   * @author Felipe Alfaro
   */
  def passPlayer(): Unit = {
    println("You passed. It's the opponent's turn")
    //board.get.Play(previousPlayer, card)
  }

  /** The computer didn't play in his turn, so it's the player's turn.
   * But, if player passed first, it means the end of the round.
   *
   * Pass the turn is defined as leaving the board the same as it arrived to the computer.
   *
   * This function leaves the board exactly the same as it arrived to the computer, and now it's the player's turn to play as many times the player wants.
   * But, if player passed first, it means the end of the round and maybe the end of the game.
   *
   * @author Felipe Alfaro
   */
  def passComputer(): Unit = {
    println("Your opponent passed. It's your turn")
    val card: String = scala.io.StdIn.readLine()
    //board.get.Play(previousPlayer.get, card)
  }

  /** Player play a card and added to the player's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original player's plus the played card.
   *
   * This function modifies the section of the board of the player or the weather zone.
   * @author Felipe Alfaro
   */
  def PlayPlayer(): Unit = {
    println("Select a card")
    val card: String = scala.io.StdIn.readLine()
    //board.get.Play(currentPlayer.get, card)
  }

  /** The computed play a card and added to the computer's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original computer's plus the played card.
   *
   * This function modifies the section of the board of the computer or the weather zone.
   * @author Felipe Alfaro
   */
  def PlayComputer(): Unit = {
    //board.get.Play(currentPlayer.get, card)
  }

  // revuelve el mazo y reparte 10 cartas a la mano
  def setDeck(): Unit = {

  }

  // le agrega 3 cartas del current mazo a la current mano
  def AnotherRound(): Unit = {

  }



  def Starts(): Unit = {
    println("What's your name?")
    val name: String = scala.io.StdIn.readLine()
    val player: Player = new Player(name, new boardSection(), 2, List[Card](), List[Card]())
    val computer: Player = new Player("computer", new boardSection(), 2, List[Card](), List[Card]())
    state = new StartGame(this)
  }

}

/*
def promptSelection(): Unit = {
    println("Select a character to attack")
    for (i <- enemyCharacters.indices) {
      println(s"$i: ${enemyCharacters(i).name}")
    }
    val input = scala.io.StdIn.readInt()
    selection = Some(enemyCharacters(input))
    state.doAction()
  }


override def attack(target: GameCharacter): Unit = {
   println(s"$name attacks ${target.name}")
}

class Jugador(nombre: String,seccionTablero: SeccionTablero,_contadorGemas: Int,_mazo: List[Cartas],_manoCartas: List[Cartas])
* */
