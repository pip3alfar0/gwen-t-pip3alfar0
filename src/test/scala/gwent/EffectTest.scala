package cl.uchile.dcc
package gwent

import gwent.cards.unit.*
import gwent.cards.{Card, WeatherCard}
import gwent.cards.effects.weather.*
import gwent.cards.effects.unit.*
import gwent.cards.effects.AbstractEffect
import gwent.cards.effects.Effect
import gwent.cards.effects.NullEffect
import gwent.player.Player
import gwent.board.*


class EffectTest extends munit.FunSuite {
  var card1: WeatherCard = _
  var card2: WeatherCard = _
  var card3: WeatherCard = _
  var card4: WeatherCard = _

  var card5: CloseCombatCard = _
  var card6: CloseCombatCard = _
  var card7: CloseCombatCard = _
  var card8: CloseCombatCard = _
  var card9: CloseCombatCard = _
  var card10: CloseCombatCard = _
  var card11: CloseCombatCard = _
  var card12: CloseCombatCard = _
  var card13: CloseCombatCard = _
  var card14: CloseCombatCard = _
  var card15: CloseCombatCard = _
  var card16: CloseCombatCard = _

  var card17: RangedCombatCard = _
  var card18: RangedCombatCard = _
  var card19: RangedCombatCard = _
  var card20: RangedCombatCard = _
  var card21: RangedCombatCard = _
  var card22: RangedCombatCard = _
  var card23: RangedCombatCard = _
  var card24: RangedCombatCard = _
  var card25: RangedCombatCard = _
  var card26: RangedCombatCard = _
  var card27: RangedCombatCard = _
  var card28: RangedCombatCard = _

  var card29: SiegeCombatCard = _
  var card30: SiegeCombatCard = _
  var card31: SiegeCombatCard = _
  var card32: SiegeCombatCard = _
  var card33: SiegeCombatCard = _
  var card34: SiegeCombatCard = _
  var card35: SiegeCombatCard = _
  var card36: SiegeCombatCard = _
  var card37: SiegeCombatCard = _
  var card38: SiegeCombatCard = _
  var card39: SiegeCombatCard = _
  var card40: SiegeCombatCard = _

  var player1: Player = _
  var player2: Player = _
  var player3: Player = _
  var player4: Player = _

  var board1: Board = _
  var board2: Board = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new WeatherCard("Clear Weather",
      "Removes all Weather Card (Biting Frost, Impenetrable Fog and Torrential Rain) effects.", ClearWeather())
    card2 = new WeatherCard("Torrential Rain",
      "Sets the strength of all Siege Combat cards to 1 for both players.", TorrentialRain())
    card3 = new WeatherCard("Biting Frost",
      "Sets the strength of all Close Combat cards to 1 for both players.", BitingFrost())
    card4 = new WeatherCard("Impenetrable Fog",
      "Sets the strength of all Ranged Combat cards to 1 for both players.", TorrentialRain())

    card5 = new CloseCombatCard("Blueboy Lugos",
      "Muster: Find any cards with the same name in your deck and play them instantly.", 6, NullEffect())
    card6 = new CloseCombatCard("Botchling",
      " ", 4, NullEffect())
    card7 = new CloseCombatCard("Blue Stripes Commando",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 4, TightBond())
    card8 = new CloseCombatCard("Olgierd von Everec",
      "Morale boost: Adds +1 to all units in the row (excluding itself). Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.",
      10, MoraleBoost())
    card9 = new CloseCombatCard("Griffin",
      " ", 5, NullEffect())
    card10 = new CloseCombatCard("Clan an Craite Warrior",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 6, TightBond())
    card11 = new CloseCombatCard("Clan Tordarroch Armorsmith",
      " ", 4, NullEffect())
    card12 = new CloseCombatCard("Fiend",
      " ", 6, NullEffect())
    card13 = new CloseCombatCard("Harpy",
      "Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.", 2, NullEffect())
    card14 = new CloseCombatCard("Nekker",
      "Muster: Find any cards with the same name in your deck and play them instantly.", 2, NullEffect())
    card15 = new CloseCombatCard("Rainfarn",
      " ", 4, NullEffect())
    card16 = new CloseCombatCard("Transformed Vildkaarl",
      "Morale boost: Adds +1 strength to all units in the row (excluding itself).", 14, MoraleBoost())

    card17 = new RangedCombatCard("Crinfrid Reavers Dragon Hunter",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 5, TightBond())
    card18 = new RangedCombatCard("Dethmold",
      " ", 6, NullEffect())
    card19 = new RangedCombatCard("Milva",
      "Morale boost: Adds +1 to all units in the row (excluding itself).", 10, MoraleBoost())
    card20 = new RangedCombatCard("Riordain",
      " ", 1, NullEffect())
    card21 = new RangedCombatCard("Sweers",
      " ", 2, NullEffect())
    card22 = new RangedCombatCard("Transformed Young Vildkaarl",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 8, TightBond())
    card23 = new RangedCombatCard("Albrich",
      " ", 2, NullEffect())
    card24 = new RangedCombatCard("Black Infantry Archer",
      " ", 10, NullEffect())
    card25 = new RangedCombatCard("Kayran",
      "Hero: Not affected by any Special Cards or abilities. Morale boost: Adds +1 to all units in the row (excluding itself). Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.",
      8, MoraleBoost())
    card26 = new RangedCombatCard("Sabrina Glevissig",
      " ", 4, NullEffect())
    card27 = new RangedCombatCard("Toruviel",
      " ", 2, NullEffect())
    card28 = new RangedCombatCard("Yaevinn",
      "Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.", 6, NullEffect())

    card29 = new SiegeCombatCard("Ice Giant",
      " ", 5, NullEffect())
    card30 = new SiegeCombatCard("Kaedweni Siege Expert",
      "Morale boost: Adds +1 to all units in the row (excluding itself).", 1, MoraleBoost())
    card31 = new SiegeCombatCard("Siege Tower",
      " ", 6, NullEffect())
    card32 = new SiegeCombatCard("Catapult",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 8, TightBond())
    card33 = new SiegeCombatCard("Rotten Mangonel",
      " ", 3, NullEffect())
    card34 = new SiegeCombatCard("Zerrikanian Fire Scorpion",
      " ", 5, NullEffect())
    card35 = new SiegeCombatCard("Heavy Zerrikanian Fire Scorpion",
      " ", 10, NullEffect())
    card36 = new SiegeCombatCard("Siege Technician",
      " ", 0, NullEffect())
    card37 = new SiegeCombatCard("War Longship",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 6, TightBond())
    card38 = new SiegeCombatCard("Earth Elemental",
      " ", 6, NullEffect())
    card39 = new SiegeCombatCard("Gaunter O'Dimm",
      "Muster: Find any cards with the same name in your deck and play them instantly.", 2, NullEffect())
    card40 = new SiegeCombatCard("Schirrú",
      "Scorch - Siege: Destroys your enemy's strongest Siege Combat unit(s) if the combined strength of all his or her Siege Combat units is 10 or more.",
      8, NullEffect())

    player1 = new Player("Constanza", BoardSection(List(card22), List(card36), List(card11)), 2, List[Card](), List[Card](card1, card5, card8, card14, card25, card3, card9, card10, card15, card28))
    player2 = new Player("Valentina", BoardSection(List(card25), List(card32), List(card7)), 2, List[Card](), List[Card](card2, card4, card6, card11, card13, card31, card7, card12, card16, card18, card20, card22))
    player3 = new Player("Julián", BoardSection(List(card18), List(card37), List(card14)), 2, List[Card](), List[Card](card1, card2, card5, card12, card40, card37, card19, card38, card23, card24))
    player4 = new Player("Joaquín", BoardSection(List(card28), List(card39), List(card6)), 2, List[Card](), List[Card](card3, card8, card6, card10, card4, card20, card32, card17, card35, card9, card25))

    board1 = new Board(player1, player2, List[WeatherCard]())
    board2 = new Board(player3, player4, List[WeatherCard]())
  }


  test("Null Effect") {
    val expected1 = new CloseCombatCard("Blue Stripes Commando",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 4, TightBond())
    board1.Play(player1, card9)
    assertEquals(expected1, player2.boardSection.close(1), "error") // card7

    val expected2 = new SiegeCombatCard("Schirrú",
      "Scorch - Siege: Destroys your enemy's strongest Siege Combat unit(s) if the combined strength of all his or her Siege Combat units is 10 or more.",
      8, NullEffect())
    board2.Play(player4, card35)
    assertEquals(expected2, player3.boardSection.siege(1), "error") // card40
  }

  test("Tight Bond") {
    val expected3 = new CloseCombatCard("Blue Stripes Commando",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 8, TightBond())
    board1.Play(player2, card7)
    assertEquals(expected3, player1.boardSection.close(1), "error") // card7

    val expected4 = new SiegeCombatCard("War Longship",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 12, TightBond())
    board2.Play(player3, card37)
    assertEquals(expected4, player3.boardSection.siege(1), "error") // card37
  }

  test("Morale Booster") {
    val expected5 = new CloseCombatCard("Blue Stripes Commando",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 5, TightBond())
    board1.Play(player2, card16)
    assertEquals(expected5, player1.boardSection.close(1), "error") // card7

    val expected6 = new RangedCombatCard("Yaevinn",
      "Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.", 8, NullEffect())
    board2.Play(player4, card25)
    assertEquals(expected6, player4.boardSection.ranged(1), "error") // card28
  }

  test("Torrential Rain") {
    val expected7 = new SiegeCombatCard("Catapult",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 1, TightBond())
    val expected8 = new SiegeCombatCard("Siege Technician",
      " ", 1, NullEffect())
    board1.Play(player2, card2)
    assertEquals(expected7, player2.boardSection.siege(1)) // card32
    assertEquals(expected8, player1.boardSection.siege(1)) // card36
    
    val expected9 = new SiegeCombatCard("War Longship",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 1, TightBond())
    val expected10 = new SiegeCombatCard("Gaunter O'Dimm",
      "Muster: Find any cards with the same name in your deck and play them instantly.", 1, NullEffect())
    board2.Play(player3, card2)
    assertEquals(expected9, player3.boardSection.siege(1)) // card37
    assertEquals(expected10, player4.boardSection.siege(1)) // card39
  }

  test("Biting Frost") {
    val expected11 = new CloseCombatCard("Blue Stripes Commando",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 1, TightBond())
    val expected12 = new CloseCombatCard("Clan Tordarroch Armorsmith",
      " ", 1, NullEffect())
    board1.Play(player1, card3)
    assertEquals(expected11, player2.boardSection.close(1)) // card7
    assertEquals(expected12, player1.boardSection.close(1)) // card11
    
    val expected13 = new CloseCombatCard("Nekker",
      "Muster: Find any cards with the same name in your deck and play them instantly.", 1, NullEffect())
    val expected14 = new CloseCombatCard("Botchling",
      " ", 1, NullEffect())
    board2.Play(player4, card3)
    assertEquals(expected13, player3.boardSection.close(1)) // card14
    assertEquals(expected14, player4.boardSection.close(1)) // card6
  }

  test("Impenetrable Fog") {
    val expected15 = new RangedCombatCard("Kayran",
      "Hero: Not affected by any Special Cards or abilities. Morale boost: Adds +1 to all units in the row (excluding itself). Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.",
      1, MoraleBoost())
    val expected16 = new RangedCombatCard("Transformed Young Vildkaarl",
      "Tight Bond: Place next to a card with the same name to double the strength of both cards.", 1, TightBond())
    board1.Play(player2, card4)
    assertEquals(expected15, player2.boardSection.ranged(1)) // card25
    assertEquals(expected16, player1.boardSection.ranged(1)) // card22
    
    val expected17 = new RangedCombatCard("Dethmold",
      " ", 1, NullEffect())
    val expected18 = new RangedCombatCard("Yaevinn",
      "Agile: Can be placed in either the Close Combat or the Ranged Combat row. Cannot be moved once placed.", 1, NullEffect())
    board2.Play(player4, card4)
    assertEquals(expected17, player3.boardSection.ranged(1)) // card18
    assertEquals(expected18, player4.boardSection.ranged(1)) // card28
  }

  test("Clear Weather") {
    //board1.Play(player1, card1)


    //board2.Play(player3, card1)
  }

}
