package cl.uchile.dcc
package gwent.Controller.States

import gwent.Controller.GameController

class OtroJuega(context: GameController) extends EstadoJuego(context) {

  override def toFinalRound(): Unit = {
    context.estado = new FinalRound(context)
  }

  override def doAction(): Unit = {
    //context.jugar()
  }

}

