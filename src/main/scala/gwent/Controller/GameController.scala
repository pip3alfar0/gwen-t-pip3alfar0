package cl.uchile.dcc
package gwent.Controller

import gwent.Controller.States.{EstadoJuego, InicioPartida}

import gwent.Cartas.Cartas
import gwent.Jugador.Jugador
import gwent.Tablero.{SeccionTablero, Tablero}


class GameController {
  private var tablero: Option[Tablero] = None
  private var jugadorActual: Option[Jugador] = None
  private var jugadorPrevio: Option[Jugador] = None
  private var seccionJugador: Option[SeccionTablero] = None
  private var seccionComputador: Option[SeccionTablero] = None
  //private val carta: Option[Cartas] = None

  //private var mazoJugador = List.empty[Cartas]
  //private var mazoComputador = List.empty[Cartas]
  var estado: EstadoJuego = new InicioPartida(this)


  /** Player didn't play in his turn, so it's the computer's turn.
   * But, if computer passed first, it means the end of the round.
   *
   * Pass the turn is defined as leaving the board the same as it arrived to the player.
   *
   * This function leaves the board exactly the same as it arrived to the player, and now it's the computer's turn to play as many times the computer wants.
   * But, if computer passed first, it means the end of the round and maybe the end of the game.
   * @author Felipe Alfaro
   */
  def pasarPlayer(): Unit = {
    println("You passed. It's the opponent's turn")
    //tablero.get.Jugar(jugadorPrevio, carta.get)
  }

  /** The computer didn't play in his turn, so it's the player's turn.
   * But, if player passed first, it means the end of the round.
   *
   * Pass the turn is defined as leaving the board the same as it arrived to the computer.
   *
   * This function leaves the board exactly the same as it arrived to the computer, and now it's the player's turn to play as many times the player wants.
   * But, if player passed first, it means the end of the round and maybe the end of the game.
   *
   * @author Felipe Alfaro
   */
  def pasarPC(): Unit = {
    println("Your opponent passed. It's your turn")
    //tablero.get.Jugar(jugadorPrevio, carta.get)
  }

  /** Player play a card and added to the player's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original player's plus the played card.
   *
   * This function modifies the section of the board of the player or the weather zone.
   * @author Felipe Alfaro
   */
  def jugarPlayer(): Unit = {
    println("Select a card")
    val carta: String = scala.io.StdIn.readLine()
    //tablero.get.Jugar(jugadorActual, carta.get)
  }

  /** The computed play a card and added to the computer's section of the board or the weather zone, corresponding to the type of card.
   *
   * Play a card and added to the card's section on the board is defined as the original computer's plus the played card.
   *
   * This function modifies the section of the board of the computer or the weather zone.
   * @author Felipe Alfaro
   */
  def jugarPC(): Unit = {
    //tablero.get.Jugar(jugadorActual, selection.get)
  }

  // revuelve el mazo y reparte 10 cartas a la mano
  def setMazo(): Unit = {

  }

  // le agrega 3 cartas del current mazo a la current mano
  def otraRonda(): Unit = {

  }



  def Comenzar(): Unit = {
    println("What's your name?")
    val name: String = scala.io.StdIn.readLine()
    val jugador: Jugador = new Jugador(name, new SeccionTablero(), 2, List[Cartas](), List[Cartas]())
    val computador: Jugador = new Jugador("Computador", new SeccionTablero(), 2, List[Cartas](), List[Cartas]())
    //println(s"$player begins ${}")
    estado = new InicioPartida(this)
  }

}

/*
def promptSelection(): Unit = {
    println("Select a character to attack")
    for (i <- enemyCharacters.indices) {
      println(s"$i: ${enemyCharacters(i).name}")
    }
    val input = scala.io.StdIn.readInt()
    selection = Some(enemyCharacters(input))
    state.doAction()
  }


override def attack(target: GameCharacter): Unit = {
   println(s"$name attacks ${target.name}")
}

class Jugador(val nombre: String, var seccionTablero: SeccionTablero, private val _contadorGemas: Int, private var _mazo: List[Cartas],
              private var _manoCartas: List[Cartas])
* */
