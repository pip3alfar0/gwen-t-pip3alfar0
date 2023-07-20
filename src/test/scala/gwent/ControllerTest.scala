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
import gwent.controller.GameController


class ControllerTest extends munit.FunSuite {
  var controller: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController
  }

  test("Starts") {
    controller.Starts("Miguelito")
    assertEquals(controller.player.get.name, "Miguelito")
    assertEquals(controller.computer.get.name, "Computer")
  }

  test("Deck and Hand") {
    controller.Starts("Miguelito")
    assertEquals(controller.player.get.handCards.length, 10)
    assertEquals(controller.player.get.deck.length, 15)
  }

  test("Play") {
    controller.Starts("Simba")
    if (controller.state.isInComputerTurn) {
      controller.state.toPlayerTurn()
      controller.currentPlayer_=(controller.player.get)
    }
    controller.PlayPlayer(controller.player.get.handCards(1))
    assertEquals(controller.previousPlayer.get, controller.player.get)
    assertEquals(controller.currentPlayer.get, controller.computer.get)
    controller.PlayComputer()
    assertEquals(controller.previousPlayer.get, controller.computer.get)
    assertEquals(controller.currentPlayer.get, controller.player.get)
  }

  test("Pass player") {
    controller.Starts("Kitty")
    if (controller.state.isInComputerTurn) {
      controller.state.toPlayerTurn()
      controller.currentPlayer_=(controller.player.get)
    }
    controller.PassPlayer()
    assertEquals(controller.currentPlayer.get, controller.computer.get)
    assertEquals(controller.previousPlayer.get, controller.player.get)
  }

  test("Pass computer") {
    controller.Starts("Miguelito")
    if (controller.state.isInPlayerTurn) {
      controller.state.toComputerTurn()
      controller.currentPlayer_=(controller.computer.get)
    }
    controller.PassComputer()
    assertEquals(controller.currentPlayer.get, controller.player.get)
  }

  test("Gems count") {
    controller.Starts("Miguelito")
    if (controller.state.isInComputerTurn) {
      controller.state.toPlayerTurn()
      controller.currentPlayer_=(controller.player.get)
    }
    controller.PlayPlayer(controller.player.get.handCards(1))
    controller.PlayComputer()
    controller.PassPlayer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PassComputer()
    assertEquals(controller.state.isInFinalRound, true)
    controller.gems()
    assertEquals(controller.player.get.gemCounter, 1)
  }

  test("Another round") {
    controller.Starts("Miguelito")
    if (controller.state.isInComputerTurn) {
      controller.state.toPlayerTurn()
      controller.currentPlayer_=(controller.player.get)
    }
    controller.PlayPlayer(controller.player.get.handCards(1))
    controller.PlayComputer()
    controller.PassPlayer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PassComputer()
    controller.gems()
    controller.AnotherRound()
    assertEquals(controller.player.get.handCards.length, 12)
    assertEquals(controller.computer.get.handCards.length, 6)
  }

  test("Winner") {
    controller.Starts("Miguelito")
    if (controller.state.isInComputerTurn) {
      controller.state.toPlayerTurn()
      controller.currentPlayer_=(controller.player.get)
    }
    controller.PlayPlayer(controller.player.get.handCards(1))
    controller.PlayComputer()
    controller.PassPlayer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PassComputer()
    controller.gems()
    controller.AnotherRound()
    controller.PlayComputer()
    controller.PassPlayer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PlayComputer()
    controller.PassComputer()
    controller.gems()
  }

}
