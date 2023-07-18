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

    player1 = new Player("Constanza", BoardSection(), 2, List[Card](), List[Card](card11.Copy(), card36.Copy(), card22.Copy(), card1.Copy(), card5.Copy(), card8.Copy(), card14.Copy(), card25.Copy(), card3.Copy(), card9.Copy(), card10.Copy(), card15.Copy(), card28.Copy()))
    player2 = new Player("Valentina", BoardSection(), 2, List[Card](), List[Card](card32.Copy(), card25.Copy(), card7.Copy(), card2.Copy(), card4.Copy(), card6.Copy(), card11.Copy(), card13.Copy(), card31.Copy(), card7.Copy(), card12.Copy(), card16.Copy(), card18.Copy(), card20.Copy(), card22.Copy()))
    player3 = new Player("Julián", BoardSection(), 2, List[Card](), List[Card](card14.Copy(), card37.Copy(), card18.Copy(), card1.Copy(), card2.Copy(), card5.Copy(), card12.Copy(), card40.Copy(), card37.Copy(), card19.Copy(), card38.Copy(), card23.Copy(), card24.Copy()))
    player4 = new Player("Joaquín", BoardSection(), 2, List[Card](), List[Card](card6.Copy(), card39.Copy(), card28.Copy(), card3.Copy(), card8.Copy(), card6.Copy(), card10.Copy(), card4.Copy(), card20.Copy(), card32.Copy(), card17.Copy(), card35.Copy(), card9.Copy(), card25.Copy()))

    board1 = new Board(player1, player2, List[WeatherCard]())
    board2 = new Board(player3, player4, List[WeatherCard]())
  }


  test("Null Effect") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player1, card9)
    assertEquals(player1.boardSection.close(1).currentPower, 4) // card11
    assertEquals(player1.boardSection.close(1).weatherEffect, 0)

    board2.Play(player4, card35)
    assertEquals(player4.boardSection.siege(1).currentPower, 2) // card39
    assertEquals(player4.boardSection.siege(1).weatherEffect, 0)
  }

  test("Tight Bond") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player2, card7)
    assertEquals(player2.boardSection.close(1).currentPower, 8) // card7
    assertEquals(player2.boardSection.close(1).previousPower, 4) // card7
    assertEquals(player2.boardSection.close(1).unitEffect, 4) // card7
    assertEquals(player2.boardSection.close(1).weatherEffect, 0)

    board2.Play(player3, card37)
    assertEquals(player3.boardSection.siege(1).previousPower, 6) // card37
    assertEquals(player3.boardSection.siege(1).currentPower, 12) // card37
    assertEquals(player3.boardSection.siege(1).unitEffect, 6) // card37
    assertEquals(player3.boardSection.siege(1).weatherEffect, 0)
  }

  test("Morale Booster") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player2, card16)
    assertEquals(player2.boardSection.close(1).currentPower, 5) // card7
    assertEquals(player2.boardSection.close(1).weatherEffect, 0)

    board2.Play(player4, card25)
    assertEquals(player4.boardSection.ranged(1).currentPower, 7) // card28
    assertEquals(player4.boardSection.ranged(1).weatherEffect, 0)
  }

  test("Torrential Rain") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player2, card2)
    assertEquals(player2.boardSection.siege(1).currentPower, 1) // card32
    assertEquals(player1.boardSection.siege(1).currentPower, 1) // card36
    assertEquals(player2.boardSection.siege(1).weatherEffect, 1)
    assertEquals(player1.boardSection.siege(1).weatherEffect, 1)

    board2.Play(player3, card2)
    assertEquals(player3.boardSection.siege(1).currentPower, 1) // card37
    assertEquals(player4.boardSection.siege(1).currentPower, 1) // card39
    assertEquals(player3.boardSection.siege(1).weatherEffect, 1)
    assertEquals(player4.boardSection.siege(1).weatherEffect, 1)
  }

  test("Biting Frost") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player1, card3)
    assertEquals(player2.boardSection.close(1).currentPower, 1) // card7
    assertEquals(player1.boardSection.close(1).currentPower, 1) // card11
    assertEquals(player2.boardSection.close(1).weatherEffect, 1)
    assertEquals(player1.boardSection.close(1).weatherEffect, 1)

    board2.Play(player4, card3)
    assertEquals(player3.boardSection.close(1).currentPower, 1) // card14
    assertEquals(player4.boardSection.close(1).currentPower, 1) // card6
    assertEquals(player3.boardSection.close(1).weatherEffect, 1)
    assertEquals(player4.boardSection.close(1).weatherEffect, 1)
  }

  test("Impenetrable Fog") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player2, card4)
    assertEquals(player2.boardSection.ranged(1).currentPower, 1) // card25
    assertEquals(player1.boardSection.ranged(1).currentPower, 1) // card22
    assertEquals(player2.boardSection.ranged(1).weatherEffect, 1)
    assertEquals(player1.boardSection.ranged(1).weatherEffect, 1)

    board2.Play(player4, card4)
    assertEquals(player3.boardSection.ranged(1).currentPower, 1) // card18
    assertEquals(player4.boardSection.ranged(1).currentPower, 1) // card28
    assertEquals(player3.boardSection.ranged(1).weatherEffect, 1)
    assertEquals(player4.boardSection.ranged(1).weatherEffect, 1)
  }

  test("Clear Weather") {
    board1.Play(player1, card22)
    board1.Play(player1, card36)
    board1.Play(player1, card11)
    board1.Play(player2, card25)
    board1.Play(player2, card32)
    board1.Play(player2, card7)
    board2.Play(player3, card18)
    board2.Play(player3, card37)
    board2.Play(player3, card14)
    board2.Play(player4, card28)
    board2.Play(player4, card39)
    board2.Play(player4, card6)

    board1.Play(player1, card1)

    assertEquals(player2.boardSection.ranged(1).weatherEffect, 0)


    board2.Play(player3, card1)

    assertEquals(player4.boardSection.ranged(1).weatherEffect, 0)
  }

}
