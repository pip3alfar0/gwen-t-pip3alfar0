package cl.uchile.dcc
package gwent

import gwent.Cartas.{WeatherCard, Card}
import gwent.Cartas.Unidad.{SiegeCombatCard, CloseCombatCard, RangedCombatCard}
import gwent.Jugador.Player
import gwent.Tablero.{boardSection, Board}

class TableroTest extends munit.FunSuite {

  var tablero1: Board = _
  var tablero2: Board = _
  var tablero3: Board = _
  var tablero4: Board = _

  var zonaClima1: List[WeatherCard] = _
  var zonaClima2: List[WeatherCard] = _
  var zonaClima3: List[WeatherCard] = _
  var zonaClima4: List[WeatherCard] = _

  var seccionTablero = new boardSection()

  var jugador1: Player = _
  var jugador2: Player = _
  var jugador3: Player = _
  var jugador4: Player = _
  var jugador5: Player = _
  var jugador6: Player = _
  var jugador7: Player = _
  var jugador8: Player = _

  var carta1: SiegeCombatCard = _
  var carta2: WeatherCard = _
  var carta3: CloseCombatCard = _
  var carta4: RangedCombatCard = _
  var carta5: WeatherCard = _
  var carta6: SiegeCombatCard = _
  var carta7: CloseCombatCard = _
  var carta8: RangedCombatCard = _
  var carta9: RangedCombatCard = _
  var carta10: CloseCombatCard = _
  var carta11: SiegeCombatCard = _
  var carta12: WeatherCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new SiegeCombatCard("carta1", "Asedio", 50)
    carta2 = new WeatherCard("carta2", "a")
    carta3 = new CloseCombatCard("carta3", "Cuerpo a Cuerpo", 90)
    carta4 = new RangedCombatCard("carta4", "Distancia", 35)
    carta5 = new WeatherCard("carta5", "b")
    carta6 = new SiegeCombatCard("carta6", "Asedio", 70)
    carta7 = new CloseCombatCard("carta7", "Cuerpo a Cuerpo", 45)
    carta8 = new RangedCombatCard("carta8", "Distancia", 25)
    carta9 = new RangedCombatCard("carta9", "Distancia", 45)
    carta10 = new CloseCombatCard("carta10", "Cuerpo a Cuerpo", 60)
    carta11 = new SiegeCombatCard("carta11", "Asedio", 40)
    carta12 = new WeatherCard("carta12", "c")

    jugador1 = new Player("Constanza", seccionTablero, 100, List[Card](carta1), List[Card](carta3, carta4))
    jugador2 = new Player("Emilio", seccionTablero, 15, List[Card](carta4, carta6), List[Card](carta7, carta12))
    jugador3 = new Player("Diego", seccionTablero, 22, List[Card](carta1, carta2, carta5), List[Card](carta9))
    jugador4 = new Player("Agustín", seccionTablero, 20, List[Card](carta8, carta6), List[Card](carta2))
    jugador5 = new Player("Cucha", seccionTablero, 95, List[Card](carta4, carta5, carta7), List[Card](carta1, carta2, carta3, carta6))
    jugador6 = new Player("Blanquita", seccionTablero, 95, List[Card](carta9, carta10), List[Card](carta11))
    jugador7 = new Player("Simón", seccionTablero, 95, List[Card](), List[Card](carta10, carta7))
    jugador8 = new Player("Aki", seccionTablero, 95, List[Card](carta11, carta9, carta6, carta3), List[Card](carta2, carta12, carta8))

    zonaClima1 = List(carta2)
    zonaClima2 = List(carta5)
    zonaClima3 = List(carta12)
    zonaClima4 = List()

    tablero1 = new Board(jugador1, jugador2, List(carta2))
    tablero2 = new Board(jugador3, jugador4, List(carta5))
    tablero3 = new Board(jugador5, jugador6, List(carta12))
    tablero4 = new Board(jugador7, jugador8, List())
  }

  test("Tableros") {
    assert(!tablero1.equals(tablero2))
    assert(!tablero1.equals(tablero3))
    assert(!tablero1.equals(tablero4))
    assert(!tablero2.equals(tablero3))
    assert(!tablero2.equals(tablero4))
    assert(!tablero3.equals(tablero4))
  }

  test("Zona Clima") {
    assertEquals(tablero1.zonaClima, zonaClima1, "error")
    assertEquals(tablero2.zonaClima, zonaClima2, "error")
    assertEquals(tablero3.zonaClima, zonaClima3, "error")
    assertEquals(tablero4.zonaClima, zonaClima4, "error")
  }

  test("Jugar") {
    tablero1.Jugar(jugador1, carta3)
    assertEquals(jugador1.manoCartas, List[Card](carta4))
    assertEquals(jugador1.seccionTablero.cuerpoACuerpo, List[CloseCombatCard](carta3))

    tablero2.Jugar(jugador3, carta9)
    assertEquals(jugador3.manoCartas, List[Card]())
    assertEquals(jugador3.seccionTablero.distancia, List[RangedCombatCard](carta9))
  }

  test("Jugar carta clima") {
    tablero3.Jugar(jugador5, carta2)
    assertEquals(jugador5.manoCartas, List[Card](carta1, carta3, carta6))
    assertEquals(tablero3.zonaClima, List[WeatherCard](carta12, carta2))

    tablero4.Jugar(jugador8, carta12)
    assertEquals(jugador8.manoCartas, List[Card](carta2, carta8))
    assertEquals(tablero4.zonaClima, List[WeatherCard](carta12))
  }

  test("Definiciones") {
    assert(!jugador1.equals(tablero1))
    assert(!tablero2.equals(carta3))
    assert(!seccionTablero.equals(tablero3))
    assert(!tablero4.equals(zonaClima2))
  }

}