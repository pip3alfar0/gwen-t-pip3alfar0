package cl.uchile.dcc
package gwent.controller

import scala.io.StdIn
import gwent.controller.states.{GameState, StartGame}

import gwent.cards.Card
import gwent.player.Player
import gwent.board.{BoardSection, Board}


class GameController {
  private var board: Option[Board] = None
  private var currentPlayer: Option[Player] = None
  private var previousPlayer: Option[Player] = None
  private val player: Option[Player] = None
  private val computer: Option[Player] = None
  private var playerSection: Option[BoardSection] = None
  private var computerSection: Option[BoardSection] = None
  private val card: Option[Card] = None
  private var selection = List.empty[Card]
  private var computerDeck = List.empty[Card]

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
    //
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
  def passComputer(i: Int): Unit = {
    println("Your opponent passed. It's your turn")
    //for (i <- player.get.handCards) {
    //  println(s"Your cards are: ${player.get.handCards(i).name}")
    //}
    //val card: Int = StdIn.readInt()
    //selection = Some(player.get.handCards(card))
    //board.get.Play(previousPlayer.get, selection)
  }

  /** Player play a card and added to the player's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original player's plus the played card.
   *
   * This function modifies the section of the board of the player or the weather zone.
   * @author Felipe Alfaro
   */
  def PlayPlayer(): Unit = {
    println("Which card do you want to play?")
    println("Your hand of cards: " + player.get.handCards) // + Player.handCards
    //val card: String = scala.io.StdIn.readLine()
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
    val player: Player = new Player(name, new BoardSection(), 2, List[Card](), List[Card]())
    val computer: Player = new Player("computer", new BoardSection(), 2, List[Card](), List[Card]())
    state = new StartGame(this)
  }

}

/*
class GameController {
  private var playerCharacters = List.empty[PlayerCharacter]
  private var enemyCharacters = List.empty[EnemyCharacter]
  private val turnsQueue = mutable.Queue.empty[GameCharacter]
  var state: GameState = new IdleState(this)
  private var selection: Option[GameCharacter] = None
  private var currentCharacter: Option[GameCharacter] = None
  private val inventory = mutable.Map.empty[String, Item]

  def startGame(
      playerCharacters: List[String],
      enemyCharacters: List[String]
  ): Unit = {
    playerCharacters.foreach(addPlayerCharacter)
    enemyCharacters.foreach(addEnemyCharacter)
    state = new IdleState(this)
  }

  def battle(): Unit = state.toSelectingTargetState()

  def promptSelection(): Unit = {
    println("Select a character to attack")
    for (i <- enemyCharacters.indices) {
      println(s"$i: ${enemyCharacters(i).name}")
    }
    val input = scala.io.StdIn.readInt()
    selection = Some(enemyCharacters(input))
    state.doAction()
  }

  def doAttack(): Unit = {
    currentCharacter.get.attack(selection.get)
  }

  def addPotion(name: String, healing: Int): Unit = {
    potionFactory.healing = Some(healing)
    addToInventory(potionFactory, name)
  }

  def addEther(name: String, restore: Int): Unit = {
    etherFactory.restore = Some(restore)
    addToInventory(etherFactory, name)
  }

  def addPhoenixDown(name: String): Unit = {
    addToInventory(phoenixDownFactory, name)
  }

  private def addToInventory[T <: Item](
      factory: ItemFactory[T],
      name: String
  ): Unit = {
    factory.name = Some(name)
    val item = factory.createItem()
    inventory += (item -> item)
  }

  def addPlayerCharacter(name: String): Unit = {
    playerCharacters = playerCharacters :+ new PlayerCharacter(name)
  }

  def addEnemyCharacter(name: String): Unit = {
    enemyCharacters = enemyCharacters :+ new EnemyCharacter(name)
  }
}
* */
