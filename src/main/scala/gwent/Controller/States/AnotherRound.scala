package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController


class OtroRound(context: GameController) extends GameState(context) {

  override def toJugadorJuega(): Unit = {
    context.estado = new JugadorJuega(context)
  }

  override def toComputadorJuega(): Unit = {
    context.estado = new ComputadorJuega(context)
  }
  
}
