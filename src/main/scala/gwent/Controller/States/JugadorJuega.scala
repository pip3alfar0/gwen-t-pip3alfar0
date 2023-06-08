package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class JugadorJuega(context: GameController) extends EstadoJuego(context) {

  override def toOtroJuega(): Unit = {
    context.estado = new OtroJuega(context)
  }

  override def toComputadorJuega(): Unit = {
    context.estado = new ComputadorJuega(context)
  }

  // tiene que jugar una carta
  override def doAction(): Unit = {
    context.jugarPlayer()
  }

}

