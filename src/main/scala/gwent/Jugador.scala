package cl.uchile.dcc
package gwent

/**
 *
 * @param nombre
 * @param seccionTablero
 * @param contadorGemas
 * @param mazoCartas
 * @param manoCartas
 *
 * */

//the class player get a name, a section on the board, a gem counter (player's life), a card deck and a card hand
class Jugador(nombre: String, seccionTablero: String, contadorGemas: Int, mazoCartas: Set[Cartas], manoCartas: Set[Cartas]) {

    //Select a card from your hand and place it on the board to perform an action
    def Jugar(): Unit = { 

    }

    //Take a card from the deck and add it to your hand
    def Robar(): Unit = { 

    }

}
