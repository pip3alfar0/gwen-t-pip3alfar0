package cl.uchile.dcc
package gwent

import gwent.Cards.{Card, WeatherCard}

import gwent.Cards.Unit.{CloseCombatCard, RangedCombatCard, SiegeCombatCard}
import gwent.Player.Player
import gwent.Board.boardSection


class PlayerTest extends munit.FunSuite {

  val name1: String = "Constanza"
  val name2: String = "Emilio"
  val name3: String = "Diego"
  val name4: String = "Agustín"
  val name5: String = "Cucha"
  val name6: String = "Blanquita"
  val name7: String = "Simón"
  val name8: String = "Aki"

  val gemCounter: Int = 2

  var boardSection = new boardSection()
  var boardSection2: boardSection = _
  var boardSection3: boardSection = _

  var player1: Player = _  // null
  var player2: Player = _
  var player3: Player = _
  var player4: Player = _
  var player5: Player = _
  var player6: Player = _
  var player7: Player = _
  var player8: Player = _

  // for the Player's cards or deck's cards
  var card1: SiegeCombatCard = _ // null
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
  var card13: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new SiegeCombatCard("card1", "SiegeCombat", 50)
    card2 = new WeatherCard("card2", "Escarcha mordiente")
    card3 = new CloseCombatCard("card3", "CloseCombat", 90)
    card4 = new RangedCombatCard("card4", "RangedCombat", 35)
    card5 = new WeatherCard("card5", "Niebla impenetrable")
    card6 = new SiegeCombatCard("card6", "SiegeCombat", 70)
    card7 = new CloseCombatCard("card7", "CloseCombat", 45)
    card8 = new RangedCombatCard("card8", "RangedCombat", 25)
    card9 = new RangedCombatCard("card9", "RangedCombat", 45)
    card10 = new CloseCombatCard("card10", "CloseCombat", 60)
    card11 = new SiegeCombatCard("card11", "SiegeCombat", 40)
    card12 = new WeatherCard("card12", "Lluvia torrencial")
    card13 = new WeatherCard("card13", "Clima despejado")

    boardSection2 = new boardSection(List(card8), List(), List(card10))
    boardSection3 = new boardSection(List(), List(card1), List())

    player1 = new Player("Constanza", boardSection, 2, List[Card](card1), List[Card](card3, card4))
    player2 = new Player("Emilio", boardSection, 2, List[Card](card4, card6), List[Card](card7, card12))
    player3 = new Player("Diego", boardSection, 2, List[Card](card1, card2, card5), List[Card]())
    player4 = new Player("Agustín", boardSection, 2, List[Card](card8, card6), List[Card](card2))
    player5 = new Player("Cucha", boardSection, 2, List[Card](card4, card5, card2, card7), List[Card](card1, card3, card6, card10))
    player6 = new Player("Blanquita", boardSection, 2, List[Card](card9, card10), List[Card](card11, card12))
    player7 = new Player("Simón", boardSection, 2, List[Card](), List[Card](card10, card7))
    player8 = new Player("Aki", boardSection, 2, List[Card](card11, card9, card6, card3), List[Card](card2, card12, card8))
  }

  test("Equals"){
    assertEquals(player1, player1)
    assertEquals(player2, player2)
    assertEquals(player3, player3)
    assertEquals(player4, player4)
    assertEquals(player5, player5)
    assertEquals(player6, player6)
    assertEquals(player7, player7)
    assertEquals(player8, player8)

    assert(!player1.equals(player2))
    assert(!player2.equals(player3))
    assert(!player3.equals(player4))
    assert(!player4.equals(player5))
    assert(!player5.equals(player6))
    assert(!player6.equals(player7))
    assert(!player7.equals(player8))
    assert(!player8.equals(player1))
    
    assertEquals(player1, new Player("Constanza", boardSection, 2, List[Card](card1), List[Card](card3, card4)))
    assertEquals(player2, new Player("Emilio", boardSection, 2, List[Card](card4, card6), List[Card](card7, card12)))
    assertEquals(player3, new Player("Diego", boardSection, 2, List[Card](card1, card2, card5), List[Card]()))
    assertEquals(player4, new Player("Agustín", boardSection, 2, List[Card](card8, card6), List[Card](card2)))
    assertEquals(player5, new Player("Cucha", boardSection, 2, List[Card](card4, card5, card2, card7), List[Card](card1, card3, card6, card10)))
    assertEquals(player6, new Player("Blanquita", boardSection, 2, List[Card](card9, card10), List[Card](card11, card12)))
    assertEquals(player7, new Player("Simón", boardSection, 2, List[Card](), List[Card](card10, card7)))
    assertEquals(player8, new Player("Aki", boardSection, 2, List[Card](card11, card9, card6, card3), List[Card](card2, card12, card8)))
    
    assert(!player1.equals(new Player("Emilio", boardSection, 2, List[Card](card4, card6), List[Card](card7, card12))))
    assert(!player2.equals(new Player("Diego", boardSection, 2, List[Card](card1, card2, card5), List[Card]())))
    assert(!player3.equals(new Player("Agustín", boardSection, 2, List[Card](card8, card6), List[Card](card2))))
    assert(!player4.equals(new Player("Cucha", boardSection, 2, List[Card](card4, card5, card2, card7), List[Card](card1, card3, card6, card10))))
    assert(!player5.equals(new Player("Blanquita", boardSection, 2, List[Card](card9, card10), List[Card](card11, card12))))
    assert(!player6.equals(new Player("Simón", boardSection, 2, List[Card](), List[Card](card10, card7))))
    assert(!player7.equals(new Player("Aki", boardSection, 2, List[Card](card11, card9, card6, card3), List[Card](card2, card12, card8))))
    assert(!player8.equals(new Player("Constanza", boardSection, 2, List[Card](card1), List[Card](card3, card4))))
  }

  test("hashCode") {
    assert(player1.hashCode() != player2.hashCode())
    assert(player2.hashCode() != player3.hashCode())
    assert(player3.hashCode() != player4.hashCode())
    assert(player4.hashCode() != player5.hashCode())
    assert(player5.hashCode() != player6.hashCode())
    assert(player6.hashCode() != player7.hashCode())
    assert(player7.hashCode() != player8.hashCode())
    assert(player8.hashCode() != player1.hashCode())

    assert(player1.hashCode() == (new Player("Constanza", boardSection, 2, List[Card](card1), List[Card](card3, card4))).hashCode())
    assert(player2.hashCode() == (new Player("Emilio", boardSection, 2, List[Card](card4, card6), List[Card](card7, card12))).hashCode())
    assert(player3.hashCode() == (new Player("Diego", boardSection, 2, List[Card](card1, card2, card5), List[Card]())).hashCode())
    assert(player4.hashCode() == (new Player("Agustín", boardSection, 2, List[Card](card8, card6), List[Card](card2))).hashCode())
    assert(player5.hashCode() == (new Player("Cucha", boardSection, 2, List[Card](card4, card5, card2, card7), List[Card](card1, card3, card6, card10))).hashCode())
    assert(player6.hashCode() == (new Player("Blanquita", boardSection, 2, List[Card](card9, card10), List[Card](card11, card12))).hashCode())
    assert(player7.hashCode() == (new Player("Simón", boardSection, 2, List[Card](), List[Card](card10, card7))).hashCode())
    assert(player8.hashCode() == (new Player("Aki", boardSection, 2, List[Card](card11, card9, card6, card3), List[Card](card2, card12, card8))).hashCode())
  }

  test("Name") {
    assertEquals(player1.name, name1)
    assertEquals(player2.name, name2)
    assertEquals(player3.name, name3)
    assertEquals(player4.name, name4)
    assertEquals(player5.name, name5)
    assertEquals(player6.name, name6)
    assertEquals(player7.name, name7)
    assertEquals(player8.name, name8)
    
    assert(!player1.name.equals(name2))
    assert(!player2.name.equals(name3))
    assert(!player3.name.equals(name4))
    assert(!player4.name.equals(name5))
    assert(!player5.name.equals(name6))
    assert(!player6.name.equals(name7))
    assert(!player7.name.equals(name8))
    assert(!player8.name.equals(name1))
  }

  test("Gem Counter") {
    assertEquals(player1.gemCounter, "2")
    assertEquals(player2.gemCounter, "2")
    assertEquals(player3.gemCounter, "2")
    assertEquals(player4.gemCounter, "2")
    assertEquals(player5.gemCounter, "2")
    assertEquals(player6.gemCounter, "2")
    assertEquals(player7.gemCounter, "2")
    assertEquals(player8.gemCounter, "2")

    assert(!player1.gemCounter.equals("5"))
    assert(!player2.gemCounter.equals("5"))
    assert(!player3.gemCounter.equals("5"))
    assert(!player4.gemCounter.equals("5"))
    assert(!player5.gemCounter.equals("5"))
    assert(!player6.gemCounter.equals("5"))
    assert(!player7.gemCounter.equals("5"))
    assert(!player8.gemCounter.equals("5"))
  }

  test("Deck") {
    assertEquals(player1.deck, List[Card](card1))
    assertEquals(player2.deck, List[Card](card4, card6))
    assertEquals(player3.deck, List[Card](card1, card2, card5))
    assertEquals(player4.deck, List[Card](card8, card6))
    assertEquals(player5.deck, List[Card](card4, card5, card2, card7))
    assertEquals(player6.deck, List[Card](card9, card10))
    assertEquals(player7.deck, List[Card]())
    assertEquals(player8.deck, List[Card](card11, card9, card6, card3))

    assert(!player1.deck.equals(List[Card](card3)))
    assert(!player2.deck.equals(List[Card](card6, card4)))
    assert(!player3.deck.equals(List[Card](card5, card2, card1)))
    assert(!player4.deck.equals(List[Card](card4, card7, card9, card11, card12)))
    assert(!player5.deck.equals(List[Card](card6, card9)))
    assert(!player6.deck.equals(List[Card](card5)))
    assert(!player7.deck.equals(List[Card](card3, card2, card5)))
    assert(!player8.deck.equals(List[Card](card10, card9, card8)))
  }

  test("Hand of cards") {
    assertEquals(player1.handCards, List[Card](card3, card4))
    assertEquals(player2.handCards, List[Card](card7, card12))
    assertEquals(player3.handCards, List[Card]())
    assertEquals(player4.handCards, List[Card](card2))
    assertEquals(player5.handCards, List[Card](card1, card3, card6, card10))
    assertEquals(player6.handCards, List[Card](card11, card12))
    assertEquals(player7.handCards, List[Card](card10, card7))
    assertEquals(player8.handCards, List[Card](card2, card12, card8))

    assert(!player1.handCards.equals(List[Card](card4, card2)))
    assert(!player2.handCards.equals(List[Card](card12)))
    assert(!player3.handCards.equals(List[Card](card5, card2, card1)))
    assert(!player4.handCards.equals(List[Card]()))
    assert(!player5.handCards.equals(List[Card](card6, card9)))
    assert(!player6.handCards.equals(List[Card](card5)))
    assert(!player7.handCards.equals(List[Card](card3, card2)))
    assert(!player8.handCards.equals(List[Card](card10, card9, card8)))
  }
  
  test("Steal") {
    val expected1 = new Player("Constanza", boardSection, 2, List[Card](), List[Card](card1, card3, card4))
    player1.Steal()
    assertEquals(expected1, player1, "error")

    val expected2 = new Player("Emilio", boardSection, 2, List[Card](card6), List[Card](card4, card7, card12))
    player2.Steal()
    assertEquals(expected2, player2, "error")

    val expected3 = new Player("Diego", boardSection, 2, List[Card](card2, card5), List[Card](card1))
    player3.Steal()
    assertEquals(expected3, player3, "error")

    val expected4 = new Player("Agustín", boardSection, 2, List[Card](card6), List[Card](card8, card2))
    player4.Steal()
    assertEquals(expected4, player4, "error")

    val expected5 = new Player("Cucha", boardSection, 2, List[Card](card5, card2, card7), List[Card](card4, card1, card3, card6, card10))
    player5.Steal()
    assertEquals(expected5, player5, "error")
  }

  test("Board Section") {
    assertEquals (player1.boardSection, boardSection)
    assertEquals(player2.boardSection, boardSection)
    assertEquals(player3.boardSection, boardSection)
    assertEquals(player4.boardSection, boardSection)
    assertEquals(player5.boardSection, boardSection)
    assertEquals(player6.boardSection, boardSection)
    assertEquals(player7.boardSection, boardSection)
    assertEquals(player8.boardSection, boardSection)

    assert(!player1.boardSection.equals(boardSection2))
    assert(!player2.boardSection.equals(boardSection3))
    assert(!player3.boardSection.equals(boardSection2))
    assert(!player4.boardSection.equals(boardSection3))
    assert(!player5.boardSection.equals(boardSection2))
    assert(!player6.boardSection.equals(boardSection3))
    assert(!player7.boardSection.equals(boardSection2))
    assert(!player8.boardSection.equals(boardSection3))
  }
  
  test("Shuffle") {
    player3.shuffleDeck()
    player5.shuffleDeck()
    player6.shuffleDeck()
    player8.shuffleDeck()

    assert(!player3.deck.equals(List[Card](card2, card5)))
    assert(!player3.deck.equals(List[Card](card5, card2, card7)))
    assert(!player3.deck.equals(List[Card](card11, card9, card10)))
    assert(!player3.deck.equals(List[Card](card2, card11, card9, card16, card3)))
  }
  
  test("Definitions") {
    assert(!player1.gemCounter.equals(name2))
    assert(!player2.name.equals(gemCounter))
    assert(!player3.boardSection.equals(name4))
    assert(!player4.gemCounter.equals(boardSection))
    assert(!player5.name.equals(gemCounter))
    assert(!player6.boardSection.equals(name5))
    assert(!player7.gemCounter.equals(boardSection))
    assert(!player8.name.equals(gemCounter))
  }

  test("Player") {
    assert(!player1.equals(card1))
    assert(!player2.equals(card2))
    assert(!player3.equals(card3))
    assert(!player4.equals(card4))
    assert(!player5.equals(card5))
    assert(!player6.equals(card6))
    assert(!player7.equals(card7))
    assert(!player8.equals(card8))
  }
    
}