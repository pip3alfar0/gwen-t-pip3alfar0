package cl.uchile.dcc
package gwent.controller

import scala.io.StdIn
import gwent.controller.states.*
import gwent.cards.*
import gwent.cards.unit.*
import gwent.cards.effects.*
import gwent.cards.effects.weather.*
import gwent.cards.effects.unit.*
import gwent.player.Player
import gwent.board.{Board, BoardSection}
import gwent.exception.InvalidMethodException
import gwent.observer.{FinalGemCount, Observer, Subject}


class GameController extends Observer[FinalGemCount] {
  private var board: Option[Board] = None
  private var _currentPlayer: Option[Player] = None
  private var previousPlayer: Option[Player] = None
  private var initialPlayer: Option[Player] = None
  private var _player: Option[Player] = None
  private var _computer: Option[Player] = None
  //private var playerSection: Option[BoardSection] = None
  //private var computerSection: Option[BoardSection] = None

  /** Accessor method for the player */
  def player: Option[Player] = _player

  /** Accessor method for the computer */
  def computer: Option[Player] = _computer

  /** Accessor method for the current player */
  def currentPlayer: Option[Player] = _currentPlayer

  /** Setter for the player */
  def player_=(player: Player): Unit = {
    _player = Some(player)
  }

  /** Setter for the computer */
  def computer_=(computer: Player): Unit = {
    _computer = Some(computer)
  }

  /***/
  override def update(observable: Subject[FinalGemCount], p: FinalGemCount): Unit = {
    if (p.player == player) {
      
    }
    //println(s"Player ${p.name} has lost the game!!!")
    println(s"$observable has won the game!!!")
  }

  /** Add the players as observed subjects */
  player.get.addObserver(this)
  computer.get.addObserver(this)

  // Initial state
  var state: GameState = new StartGame(this)

  /** The game's cards */
  var card1: WeatherCard = new WeatherCard("Clear Weather",
    "Removes all Weather Card (Biting Frost, Impenetrable Fog and Torrential Rain) effects.", ClearWeather())
  var card2: WeatherCard = new WeatherCard("Torrential Rain",
    "Sets the strength of all Siege Combat cards to 1 for both players.", TorrentialRain())
  var card3: WeatherCard = new WeatherCard("Biting Frost",
    "Sets the strength of all Close Combat cards to 1 for both players.", BitingFrost())
  var card4: WeatherCard = new WeatherCard("Impenetrable Fog",
    "Sets the strength of all Ranged Combat cards to 1 for both players.", TorrentialRain())

  var card5: CloseCombatCard = new CloseCombatCard("Blueboy Lugos",
    "Muster: Find any cards with the same name in your deck and play them instantly.", 6, NullEffect())
  var card6: CloseCombatCard = new CloseCombatCard("Botchling",
    " ", 4, NullEffect())
  var card7: CloseCombatCard = new CloseCombatCard("Blue Stripes Commando",
    "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 4, TightBond())
  var card8: CloseCombatCard = new CloseCombatCard("Olgierd von Everec",
    "Morale boost: Adds +1 to all units in the row (excluding itself). Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.",
    10, MoraleBoost())
  var card9: CloseCombatCard = new CloseCombatCard("Griffin",
    " ", 5, NullEffect())
  var card10: CloseCombatCard = new CloseCombatCard("Clan an Craite Warrior",
    "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 6, TightBond())
  var card11: CloseCombatCard = new CloseCombatCard("Clan Tordarroch Armorsmith",
    " ", 4, NullEffect())
  var card12: CloseCombatCard = new CloseCombatCard("Fiend",
    " ", 6, NullEffect())
  var card13: CloseCombatCard = new CloseCombatCard("Harpy",
    "Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.", 2, NullEffect())
  var card14: CloseCombatCard = new CloseCombatCard("Nekker",
    "Muster: Find any cards with the same name in your deck and play them instantly.", 2, NullEffect())
  var card15: CloseCombatCard = new CloseCombatCard("Rainfarn",
    " ", 4, NullEffect())
  var card16: CloseCombatCard = new CloseCombatCard("Transformed Vildkaarl",
    "Morale boost: Adds +1 strength to all units in the row (excluding itself).", 14, MoraleBoost())

  var card17: RangedCombatCard = new RangedCombatCard("Crinfrid Reavers Dragon Hunter",
    "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 5, TightBond())
  var card18: RangedCombatCard = new RangedCombatCard("Dethmold",
    " ", 6, NullEffect())
  var card19: RangedCombatCard = new RangedCombatCard("Milva",
    "Morale boost: Adds +1 to all units in the row (excluding itself).", 10, MoraleBoost())
  var card20: RangedCombatCard = new RangedCombatCard("Riordain",
    " ", 1, NullEffect())
  var card21: RangedCombatCard = new RangedCombatCard("Sweers",
    " ", 2, NullEffect())
  var card22: RangedCombatCard = new RangedCombatCard("Transformed Young Vildkaarl",
    "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 8, TightBond())
  var card23: RangedCombatCard = new RangedCombatCard("Albrich",
    " ", 2, NullEffect())
  var card24: RangedCombatCard = new RangedCombatCard("Black Infantry Archer",
    " ", 10, NullEffect())
  var card25: RangedCombatCard = new RangedCombatCard("Kayran",
    "Hero: Not affected by any Special Cards or abilities. Morale boost: Adds +1 to all units in the row (excluding itself). Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.",
    8, MoraleBoost())
  var card26: RangedCombatCard = new RangedCombatCard("Sabrina Glevissig",
    " ", 4, NullEffect())
  var card27: RangedCombatCard = new RangedCombatCard("Toruviel",
    " ", 2, NullEffect())
  var card28: RangedCombatCard = new RangedCombatCard("Yaevinn",
    "Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.", 6, NullEffect())

  var card29: SiegeCombatCard = new SiegeCombatCard("Ice Giant",
    " ", 5, NullEffect())
  var card30: SiegeCombatCard = new SiegeCombatCard("Kaedweni Siege Expert",
    "Morale boost: Adds +1 to all units in the row (excluding itself).", 1, MoraleBoost())
  var card31: SiegeCombatCard = new SiegeCombatCard("Siege Tower",
    " ", 6, NullEffect())
  var card32: SiegeCombatCard = new SiegeCombatCard("Catapult",
    "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 8, TightBond())
  var card33: SiegeCombatCard = new SiegeCombatCard("Rotten Mangonel",
    " ", 3, NullEffect())
  var card34: SiegeCombatCard = new SiegeCombatCard("Zerrikanian Fire Scorpion",
    " ", 5, NullEffect())
  var card35: SiegeCombatCard = new SiegeCombatCard("Heavy Zerrikanian Fire Scorpion",
    " ", 10, NullEffect())
  var card36: SiegeCombatCard = new SiegeCombatCard("Siege Technician",
    " ", 0, NullEffect())
  var card37: SiegeCombatCard = new SiegeCombatCard("War Longship",
    "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 6, TightBond())
  var card38: SiegeCombatCard = new SiegeCombatCard("Earth Elemental",
    " ", 6, NullEffect())
  var card39: SiegeCombatCard = new SiegeCombatCard("Gaunter O'Dimm",
    "Muster: Find any cards with the same name in your deck and play them instantly.", 2, NullEffect())
  var card40: SiegeCombatCard = new SiegeCombatCard("Schirrú",
    "Scorch - Siege: Destroys your enemy's strongest Siege Combat unit(s) if the combined strength of all his or her Siege Combat units is 10 or more.",
    8, NullEffect())

  val ListUnitCards = List[Card](card5, card6, card7, card8, card9, card10, card11, card12, card13, card14,
    card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30,
    card31, card32, card33, card34, card35, card36, card37, card38, card39, card40)
  val ListWeatherCards = List[Card](card1, card2, card3, card4)

  /** Shuffle each player's deck and give 10 cards for each hand of cards */ //fix
  def setDeckAndHand(p: Player): Unit = { // private?
    p.deck_=(ListWeatherCards ::: p.deck)
    var i = 21
    while (i > 0) {
      val n = scala.util.Random.nextInt(36)
      p.deck_=(ListUnitCards(n) :: p.deck)
      i -= 1
    }
    p.shuffleDeck()
    var j = 10
    while (j > 0) {
      p.Steal()
      j -= 1
    }
  }



  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /** Select randomly the initial player */
  private def First(p1: Player, p2: Player): Unit = {
    val n = scala.util.Random.nextInt(2)
    if (n == 1) {
      _currentPlayer = Some(p1)
      initialPlayer = Some(p1)
    }
    else {
      _currentPlayer = Some(p2)
      initialPlayer = Some(p2)
    }
  }

  /** The start of the game */
  def Starts(name: String): Unit = {
    val player: Player = new Player(name, new BoardSection(), 2, List[Card](), List[Card]())
    val computer: Player = new Player("computer", new BoardSection(), 2, List[Card](), List[Card]())
    setDeckAndHand(player)
    setDeckAndHand(computer)
    board = Some(new Board(player, computer, List[WeatherCard]()))
    First(player, computer) // First turn
    state = new StartGame(this)
    if (_currentPlayer == player) {
      state.toPlayerTurn()
    }
    else {
      state.toComputerTurn()
    }
  }



  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /** Player play a card and added to the player's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original player's plus the played card.
   * This function modifies the section of the board of the player or the weather zone.
   *
   * @author Felipe Alfaro
   */
  def PlayPlayer(c: Card): Unit = {
    if (_currentPlayer != player) {
      throw new InvalidMethodException(
        s"It's the computer's turn, not yours"
      )
    }
    board.get.Play(player.get, c)
    state.toComputerTurn()
  }
  
  /** The Player didn't play in his turn, so it's the computer's turn.
   * 
   * Pass the turn is defined as leaving the board the same as it arrived to the player.
   * 
   * This function leaves the board exactly the same as it arrived to the player, now the current player is the Computer and the previous player is the Player
   * @author Felipe Alfaro
   */
  def PassPlayer(): Unit = {
    previousPlayer = player
    _currentPlayer = computer
    state.pass()
  }

  /** The computed play a card and added to the computer's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original computer's plus the played card.
   *
   * This function modifies the section of the board of the computer or the weather zone.
   * @author Felipe Alfaro
   */
  def PlayComputer(): Unit = {
    if (_currentPlayer != computer) {
      throw new InvalidMethodException(
        s"It's the player's turn, not yours"
      )
    }
    val length = computer.get.handCards.length
    val n = scala.util.Random.nextInt(length)
    board.get.Play(_currentPlayer.get, computer.get.handCards(n))
    state.toPlayerTurn()
  }
  
  /** The Computer didn't play in his turn, so it's the player's turn.
   *
   * Pass the turn is defined as leaving the board the same as it arrived to the computer.
   *
   * This function leaves the board exactly the same as it arrived to the computer, now the current player is the Player and the previous player is the Computer
   * @author Felipe Alfaro
   */
  def PassComputer(): Unit = {
    previousPlayer = computer
    _currentPlayer = player
    state.pass()
  }


  
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /** Count the points for some player*/
  private def countPointsPlayer(p: Player): Int = {
    var pPoints = 0
    for (c <- p.boardSection.siege) {
      pPoints += c.currentPower
    }
    for (c <- p.boardSection.close) {
      pPoints += c.currentPower
    }
    for (c <- p.boardSection.ranged) {
      pPoints += c.currentPower
    }
    pPoints
  }

  /** Counts the points, the player with the less points loose a gem */
  def countPoints(): Unit = {
    val playerPoints = countPointsPlayer(player.get)
    val computerPoints = countPointsPlayer(computer.get)
    // compare
    if (playerPoints < computerPoints) {
      player.get.gemCounter -= 1
    }
    else if (playerPoints > computerPoints) {
      computer.get.gemCounter -= 1
    } else {
      player.get.gemCounter -= 1
      computer.get.gemCounter -= 1
    }
  }





  /** Each player steal 3 cards from their respective decks */ //fix
  def AnotherRound(): Unit = {
    var i = 3
    while (i > 0) {
      player.get.Steal()
      computer.get.Steal()
      i-=1
    }
    if (initialPlayer == player) {
      _currentPlayer = computer
      initialPlayer = player
      state = new ComputerTurn(this)
    } else {
      _currentPlayer = player
      initialPlayer = computer
      state = new PlayerTurn(this)
    }
  }



  


  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  /** In the end of the game, the player who still have gems won */ //fix
  def finalGemCount(): Unit = {
    if (player.get.gemCounter != 0) {
      printf("You won!! Congrats:)")
    }
    else if (computer.get.gemCounter != 0) {
      printf("The Computer wins!!")
    } else {
      printf("All the players have 0 gems!! It's a tie")
    }
  }


}
