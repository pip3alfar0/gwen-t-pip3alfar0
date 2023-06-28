package cl.uchile.dcc
package gwent

import gwent.cards.{Card, WeatherCard}
import gwent.cards.unit.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import gwent.player.Player
import gwent.board.{Board, BoardSection}
import gwent.cards.effects.weather.{BitingFrost, ImpenetrableFog, TorrentialRain}
import gwent.cards.effects.unit.{TightBond, MoraleBoost}
import gwent.cards.effects.Effect
import gwent.cards.effects.NullEffect


class BoardTest extends munit.FunSuite {

  var board1: Board = _
  var board2: Board = _
  var board3: Board = _
  var board4: Board = _

  var weatherZone1: List[WeatherCard] = _
  var weatherZone2: List[WeatherCard] = _
  var weatherZone3: List[WeatherCard] = _
  var weatherZone4: List[WeatherCard] = _

  var boardSection = new BoardSection()

  var player1: Player = _
  var player2: Player = _
  var player3: Player = _
  var player4: Player = _
  var player5: Player = _
  var player6: Player = _
  var player7: Player = _
  var player8: Player = _

  var card1: SiegeCombatCard = _
  var card2: WeatherCard = _
  var card3: CloseCombatCard = _
  var card4: RangedCombatCard = _
  var card5: WeatherCard = _
  var card6: SiegeCombatCard = _
  var card7: CloseCombatCard = _
  var card8: RangedCombatCard = _
  var card9: RangedCombatCard = _
  var card10: CloseCombatCard = _
  var card11: SiegeCombatCard = _
  var card12: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new SiegeCombatCard("card1", "SiegeCombat", 50, MoraleBoost())
    card2 = new WeatherCard("card2", "BitingFrost", BitingFrost())
    card3 = new CloseCombatCard("card3", "CloseCombat", 90, TightBond())
    card4 = new RangedCombatCard("card4", "RangeCombat", 35, NullEffect())
    card5 = new WeatherCard("card5", "ImpenetrableFog", ImpenetrableFog())
    card6 = new SiegeCombatCard("card6", "SiegeCombat", 70, NullEffect())
    card7 = new CloseCombatCard("card7", "CloseCombat", 45, NullEffect())
    card8 = new RangedCombatCard("card8", "RangeCombat", 25, NullEffect())
    card9 = new RangedCombatCard("card9", "RangeCombat", 45, TightBond())
    card10 = new CloseCombatCard("card10", "CloseCombat", 60, MoraleBoost())
    card11 = new SiegeCombatCard("card11", "SiegeCombat", 40, NullEffect())
    card12 = new WeatherCard("card12", "TorrentialRain", TorrentialRain())

    player1 = new Player("Constanza", boardSection, 2, List[Card](card1), List[Card](card3, card4))
    player2 = new Player("Emilio", boardSection, 2, List[Card](card4, card6), List[Card](card7, card12))
    player3 = new Player("Diego", boardSection, 2, List[Card](card1, card2, card5), List[Card](card9))
    player4 = new Player("Agustín", boardSection, 2, List[Card](card8, card6), List[Card](card2))
    player5 = new Player("Cucha", boardSection, 2, List[Card](card4, card5, card7), List[Card](card1, card2, card3, card6))
    player6 = new Player("Blanquita", boardSection, 2, List[Card](card9, card10), List[Card](card11))
    player7 = new Player("Simón", boardSection, 2, List[Card](), List[Card](card10, card7))
    player8 = new Player("Aki", boardSection, 2, List[Card](card11, card9, card6, card3), List[Card](card2, card12, card8))

    weatherZone1 = List(card2)
    weatherZone2 = List(card5)
    weatherZone3 = List(card12)
    weatherZone4 = List()

    board1 = new Board(player1, player2, List(card2))
    board2 = new Board(player3, player4, List(card5))
    board3 = new Board(player5, player6, List(card12))
    board4 = new Board(player7, player8, List())
  }

  test("Boards") {
    assert(!board1.equals(board2))
    assert(!board1.equals(board3))
    assert(!board1.equals(board4))
    assert(!board2.equals(board3))
    assert(!board2.equals(board4))
    assert(!board3.equals(board4))
  }

  test("Weather Zone") {
    assertEquals(board1.weatherZone, weatherZone1, "error")
    assertEquals(board2.weatherZone, weatherZone2, "error")
    assertEquals(board3.weatherZone, weatherZone3, "error")
    assertEquals(board4.weatherZone, weatherZone4, "error")
  }

  test("Play") {
    board1.Play(player1, card3)
    assertEquals(player1.handCards, List[Card](card4))
    assertEquals(player1.boardSection.close, List[CloseCombatCard](card3))

    board2.Play(player3, card9)
    assertEquals(player3.handCards, List[Card]())
    assertEquals(player3.boardSection.ranged, List[RangedCombatCard](card9))
  }

  test("Play weather card") {
    board3.Play(player5, card2)
    assertEquals(player5.handCards, List[Card](card1, card3, card6))
    assertEquals(board3.weatherZone, List[WeatherCard](card12, card2))

    board4.Play(player8, card12)
    assertEquals(player8.handCards, List[Card](card2, card8))
    assertEquals(board4.weatherZone, List[WeatherCard](card12))
  }

  test("Definitions") {
    assert(!player1.equals(board1))
    assert(!board2.equals(card3))
    assert(!boardSection.equals(board3))
    assert(!board4.equals(weatherZone2))
  }

}