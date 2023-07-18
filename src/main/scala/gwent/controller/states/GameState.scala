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
  
  def isInStartGame: Boolean = {
    false
  }

  def isInPlayerTurn: Boolean = {
    false
  }

  def isInComputerTurn: Boolean = {
    false
  }

  def isInOtherTurn: Boolean = {
    false
  }

  def isInFinalRound: Boolean = {
    false
  }

  def isInAnotherRound: Boolean = {
    false
  }

  def isInEndGame: Boolean = {
    false
  }

  def pass(): Unit = {
    // do nothing
  }
  
  def changeTurn(): Unit = {
    // do nothing
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }

}
