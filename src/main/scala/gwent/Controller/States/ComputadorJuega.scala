package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class ComputadorJuega(context: GameController) extends EstadoJuego(context) {

  override def toOtroJuega(): Unit = {
    context.estado = new OtroJuega(context)
  }

  override def toJugadorJuega(): Unit = {
    context.estado = new JugadorJuega(context)
  }

  override def doAction(): Unit = {
    context.jugarPC()
  }

}
