package cl.uchile.dcc
package gwent

import gwent.Cartas.{CartaClima, Cartas}
import gwent.Cartas.Unidad.{Asedio, CuerpoACuerpo, Distancia}
import gwent.Jugador.Jugador
import gwent.Tablero.{SeccionTablero, Tablero}

class TableroTest extends munit.FunSuite {

  var tablero1: Tablero = _
  var tablero2: Tablero = _
  var tablero3: Tablero = _
  var tablero4: Tablero = _

  var zonaClima1: List[CartaClima] = _
  var zonaClima2: List[CartaClima] = _
  var zonaClima3: List[CartaClima] = _
  var zonaClima4: List[CartaClima] = _

  var seccionTablero = new SeccionTablero()

  var jugador1: Jugador = _
  var jugador2: Jugador = _
  var jugador3: Jugador = _
  var jugador4: Jugador = _
  var jugador5: Jugador = _
  var jugador6: Jugador = _
  var jugador7: Jugador = _
  var jugador8: Jugador = _

  var carta1: Asedio = _
  var carta2: CartaClima = _
  var carta3: CuerpoACuerpo = _
  var carta4: Distancia = _
  var carta5: CartaClima = _
  var carta6: Asedio = _
  var carta7: CuerpoACuerpo = _
  var carta8: Distancia = _
  var carta9: Distancia = _
  var carta10: CuerpoACuerpo = _
  var carta11: Asedio = _
  var carta12: CartaClima = _

  override def beforeEach(context: BeforeEach): Unit = {
    carta1 = new Asedio("carta1", "Asedio", 50)
    carta2 = new CartaClima("carta2", "a")
    carta3 = new CuerpoACuerpo("carta3", "Cuerpo a Cuerpo", 90)
    carta4 = new Distancia("carta4", "Distancia", 35)
    carta5 = new CartaClima("carta5", "b")
    carta6 = new Asedio("carta6", "Asedio", 70)
    carta7 = new CuerpoACuerpo("carta7", "Cuerpo a Cuerpo", 45)
    carta8 = new Distancia("carta8", "Distancia", 25)
    carta9 = new Distancia("carta9", "Distancia", 45)
    carta10 = new CuerpoACuerpo("carta10", "Cuerpo a Cuerpo", 60)
    carta11 = new Asedio("carta11", "Asedio", 40)
    carta12 = new CartaClima("carta12", "c")

    jugador1 = new Jugador("Constanza", seccionTablero, 100, List[Cartas](carta1), List[Cartas](carta3, carta4))
    jugador2 = new Jugador("Emilio", seccionTablero, 15, List[Cartas](carta4, carta6), List[Cartas](carta7, carta12))
    jugador3 = new Jugador("Diego", seccionTablero, 22, List[Cartas](carta1, carta2, carta5), List[Cartas](carta9))
    jugador4 = new Jugador("Agustín", seccionTablero, 20, List[Cartas](carta8, carta6), List[Cartas](carta2))
    jugador5 = new Jugador("Cucha", seccionTablero, 95, List[Cartas](carta4, carta5, carta7), List[Cartas](carta1, carta2, carta3, carta6))
    jugador6 = new Jugador("Blanquita", seccionTablero, 95, List[Cartas](carta9, carta10), List[Cartas](carta11))
    jugador7 = new Jugador("Simón", seccionTablero, 95, List[Cartas](), List[Cartas](carta10, carta7))
    jugador8 = new Jugador("Aki", seccionTablero, 95, List[Cartas](carta11, carta9, carta6, carta3), List[Cartas](carta2, carta12, carta8))

    zonaClima1 = List(carta2)
    zonaClima2 = List(carta5)
    zonaClima3 = List(carta12)
    zonaClima4 = List()

    tablero1 = new Tablero(jugador1, jugador2, List(carta2))
    tablero2 = new Tablero(jugador3, jugador4, List(carta5))
    tablero3 = new Tablero(jugador5, jugador6, List(carta12))
    tablero4 = new Tablero(jugador7, jugador8, List())
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
    assertEquals(jugador1.manoCartas, List[Cartas](carta4))
    assertEquals(jugador1.seccionTablero.cuerpoACuerpo, List[CuerpoACuerpo](carta3))

    tablero2.Jugar(jugador3, carta9)
    assertEquals(jugador3.manoCartas, List[Cartas]())
    assertEquals(jugador3.seccionTablero.distancia, List[Distancia](carta9))
  }

  test("Jugar carta clima") {
    tablero3.Jugar(jugador5, carta2)
    assertEquals(jugador5.manoCartas, List[Cartas](carta1, carta3, carta6))
    assertEquals(tablero3.zonaClima, List[CartaClima](carta12, carta2))

    tablero4.Jugar(jugador8, carta12)
    assertEquals(jugador8.manoCartas, List[Cartas](carta2, carta8))
    assertEquals(tablero4.zonaClima, List[CartaClima](carta12))
  }

  test("Definiciones") {
    assert(!jugador1.equals(tablero1))
    assert(!tablero2.equals(carta3))
    assert(!seccionTablero.equals(tablero3))
    assert(!tablero4.equals(zonaClima2))
  }

}