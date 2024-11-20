package cl.uchile.dcc
package gwent.controller.states

import gwent.controller.GameController
import gwent.exception.InvalidTransitionException


class GameState(val context: GameController) {
  context.state = this

  def toPlayerTurn(): Unit = {
    transitionError("PlayerTurn")
  }

  def toComputerTurn(): Unit = {
    transitionError("ComputerTurn")
  }

  def toOtherTurn(): Unit = {
    transitionError("OtherTurn")
  }

  def toFinalRound(): Unit = {
    transitionError("FinalRound")
  }

  def toAnotherRound(): Unit = {
    transitionError("AnotherRound")
  }

  def toEndGame(): Unit = {
    transitionError("EndGame")
  }

  def pass(): Unit = {
    // do nothing
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }

}
