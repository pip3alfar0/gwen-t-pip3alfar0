package cl.uchile.dcc
package gwent

/** It's a class representing the board of the game.
 * This board is defined by
 *
 *
 * @param seccion The first section of the board.
 * //@param seccion2 The second section of the board.
 *
 * @example
 * {{{
 *
 * }}}
 *
 * @author Felipe Alfaro
 * */

class Tablero(j1: Jugador, j2: Jugador, zonaAsedio1: List[Cartas], zonaDistancia1: List[Cartas], zonaCuerpoACuerpo1: List[Cartas], zonaClima: List[Cartas]) {

  //def asignar(){}

  //def Jugar(card: Cartas, player: Jugador): Unit = {

  //}



}



/*
new Tablero(j1: Jugador, j2: Jugador, zonaClima)


class seccionTablero(asedio, distancia, cuerpoacuerpo) {}


jugador
jugador1 extends
jugador2 extends

class Tablero(j1: Jugador, j2: Jugador, zonaClima) {

    def Jugar(j: Jugador)

    j1.seccionTablero
}



class Jugador(nombre, ..., seccionTablero){

    def Jugar(card: Cartas, board: Tablero): Unit = {
      _manoCartas = _manoCartas.filter(_ != card)
      board.Jugar(this, card) // this: player
    }
}

class CartaClima(val nombre: String, val descripcion: String) extends Cartas {
    def Jugar(j: Jugador, )
}




* */




/*
* cada sección se subdivide en tres zonas: la zona de combate cuerpo a cuerpo, la zona de combate a distancia y la zona de asedio.
* Utilizaremos indistintamente los términos tablero y campo de batalla, así como los términos zona y fila.
Además de las zonas de combate, existe una zona adicional para las cartas de clima que afectan el campo de batalla
y pueden tener efectos como modificar la fuerza de las unidades en diferentes zonas. Esta zona es compartida por
ambos jugadores, por lo que solo puede haber una carta de clima en el campo.
La única diferencia entre las zonas del tablero son las cartas que pueden ser colocadas en cada una de ellas.
* */