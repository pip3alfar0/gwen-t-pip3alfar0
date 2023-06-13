package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController
import gwent.Exception.InvalidTransitionException


class EstadoJuego(val context: GameController) {
  context.state = this

  def toInicioPartida(): Unit = {
    transitionError("InicioPartida")
  }

  def toJugadorJuega(): Unit = {
    transitionError("JugadorJuega")
  }

  def toComputadorJuega(): Unit = {
    transitionError("ComputadorJuega")
  }

  def toOtroJuega(): Unit = {
    transitionError("OtroJuega")
  }

  def toFinalRound(): Unit = {
    transitionError("FinalRound")
  }

  def toOtroRound(): Unit = {
    transitionError("OtroRound")
  }

  def toFinPartida(): Unit = {
    transitionError("FinPartida")
  }

  def doAction(): Unit = {
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
    s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }

}
