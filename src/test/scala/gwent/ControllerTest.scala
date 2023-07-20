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

import cl.uchile.dcc.gwent.exception.{InvalidMethodException, InvalidTransitionException}
import org.junit.Assert


class ControllerTest extends munit.FunSuite {
  var controller: GameController = _
  var controller2: GameController = _

  override def beforeEach(context: BeforeEach): Unit = {
    controller = new GameController
    controller2 = new GameController
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
      controller.initialPlayer_=(controller.player.get)
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
      controller.initialPlayer_=(controller.player.get)
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
      controller.initialPlayer_=(controller.computer.get)
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
      controller.initialPlayer_=(controller.player.get)
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

  test("Winner 1") {
    controller.Starts("Miguelito")
    if (controller.state.isInComputerTurn) {
      controller.state.toPlayerTurn()
      controller.initialPlayer_=(controller.player.get)
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

  test("Winner 2") {
    controller2.Starts("Rene Bridge")
    if (controller2.state.isInPlayerTurn) {
      controller2.state.toComputerTurn()
      controller2.initialPlayer_=(controller2.computer.get)
      controller2.currentPlayer_=(controller2.computer.get)
    }
    controller2.PlayComputer()
    controller2.PlayPlayer(controller2.player.get.handCards(1))
    controller2.PlayComputer()
    controller2.PlayPlayer(controller2.player.get.handCards(1))
    controller2.PlayComputer()
    controller2.PlayPlayer(controller2.player.get.handCards(1))
    controller2.PassComputer()
    controller2.PlayPlayer(controller2.player.get.handCards(1))
    controller2.PlayPlayer(controller2.player.get.handCards(1))
    controller2.PassPlayer()
    controller2.gems()
    controller2.AnotherRound()
    controller2.PlayPlayer(controller2.player.get.handCards(1))
    controller2.PassComputer()
    controller2.PassPlayer()
    controller2.gems()
  }

  test("Exceptions") {
    controller2.Starts("Rene Bridge")
    if (controller2.state.isInComputerTurn) {
      controller2.state.toPlayerTurn()
      controller2.initialPlayer_=(controller2.player.get)
      controller2.currentPlayer_=(controller2.player.get)
    }
    val e1 = Assert.assertThrows(classOf[InvalidMethodException], () => controller2.PlayComputer())
    assertEquals(e1.getMessage, "It's the player's turn, not yours")


    controller.Starts("Kike Morande")
    if (controller.state.isInPlayerTurn) {
      controller.state.toComputerTurn()
      controller.initialPlayer_=(controller.computer.get)
      controller.currentPlayer_=(controller.computer.get)
    }
    val e2 = Assert.assertThrows(classOf[InvalidMethodException], () => controller.PlayPlayer(controller.player.get.handCards(1)))
    assertEquals(e2.getMessage, "It's the computer's turn, not yours")
  }
  
  test("Transition error") {
    controller.Starts("Kike Morande")
    if (controller.state.isInPlayerTurn) {
      controller.state.toComputerTurn()
      controller.initialPlayer_=(controller.computer.get)
      controller.currentPlayer_=(controller.computer.get)
    }
    val e1 = Assert.assertThrows(classOf[InvalidMethodException], () => controller.PlayComputer())
    assertEquals(e1.getMessage, "Cannot transition from  to ")
  }

}
