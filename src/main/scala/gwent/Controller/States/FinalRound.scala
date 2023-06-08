package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class FinalRound(context: GameController) extends EstadoJuego(context) {

  override def toFinPartida(): Unit = {
    context.estado = new FinPartida(context)
  }

  override def toOtroRound(): Unit = {
    context.estado = new OtroRound(context)
  }

}

