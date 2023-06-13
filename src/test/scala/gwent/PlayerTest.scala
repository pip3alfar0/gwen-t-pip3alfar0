package cl.uchile.dcc
package gwent

import gwent.Cartas.{WeatherCard, Card}

import cl.uchile.dcc.gwent.Cartas.Unidad.{SiegeCombatCard, CloseCombatCard, RangedCombatCard}
import cl.uchile.dcc.gwent.Jugador.Player
import cl.uchile.dcc.gwent.Tablero.boardSection

class JugadorTest extends munit.FunSuite {

  val nombre1: String = "Constanza"
  val nombre2: String = "Emilio"
  val nombre3: String = "Diego"
  val nombre4: String = "Agustín"
  val nombre5: String = "Cucha"
  val nombre6: String = "Blanquita"
  val nombre7: String = "Simón"
  val nombre8: String = "Aki"

  val contadorGemas1: Int = 100
  val contadorGemas2: Int = 15
  val contadorGemas3: Int = 22
  val contadorGemas4: Int = 20
  val contadorGemas5: Int = 95

  var seccionTablero = new boardSection()
  var seccionTablero2: boardSection = _
  var seccionTablero3: boardSection = _

  var jugador1: Player = _  // null
  var jugador2: Player = _
  var jugador3: Player = _
  var jugador4: Player = _
  var jugador5: Player = _
  var jugador6: Player = _
  var jugador7: Player = _
  var jugador8: Player = _

  // for the Player's cards or deck's cards
  var carta1: SiegeCombatCard = _ // null
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

    seccionTablero2 = new boardSection(List(carta8), List(), List(carta10))
    seccionTablero3 = new boardSection(List(), List(carta1), List())

    jugador1 = new Player("Constanza", seccionTablero, 100, List[Card](carta1), List[Card](carta3, carta4))
    jugador2 = new Player("Emilio", seccionTablero, 15, List[Card](carta4, carta6), List[Card](carta7, carta12))
    jugador3 = new Player("Diego", seccionTablero, 22, List[Card](carta1, carta2, carta5), List[Card]())
    jugador4 = new Player("Agustín", seccionTablero, 20, List[Card](carta8, carta6), List[Card](carta2))
    jugador5 = new Player("Cucha", seccionTablero, 95, List[Card](carta4, carta5, carta2, carta7), List[Card](carta1, carta3, carta6, carta10))
    jugador6 = new Player("Blanquita", seccionTablero, 95, List[Card](carta9, carta10), List[Card](carta11, carta12))
    jugador7 = new Player("Simón", seccionTablero, 95, List[Card](), List[Card](carta10, carta7))
    jugador8 = new Player("Aki", seccionTablero, 95, List[Card](carta11, carta9, carta6, carta3), List[Card](carta2, carta12, carta8))
  }

  test("Equals"){
    assertEquals(jugador1, jugador1)
    assertEquals(jugador2, jugador2)
    assertEquals(jugador3, jugador3)
    assertEquals(jugador4, jugador4)
    assertEquals(jugador5, jugador5)
    assertEquals(jugador6, jugador6)
    assertEquals(jugador7, jugador7)
    assertEquals(jugador8, jugador8)
    
    assert(!jugador1.equals(jugador2))
    assert(!jugador2.equals(jugador3))
    assert(!jugador3.equals(jugador4))
    assert(!jugador4.equals(jugador5))
    assert(!jugador5.equals(jugador6))
    assert(!jugador6.equals(jugador7))
    assert(!jugador7.equals(jugador8))
    assert(!jugador8.equals(jugador1))
    
    assertEquals(jugador1, new Player("Constanza", seccionTablero, 100, List[Card](carta1), List[Card](carta3, carta4)))
    assertEquals(jugador2, new Player("Emilio", seccionTablero, 15, List[Card](carta4, carta6), List[Card](carta7, carta12)))
    assertEquals(jugador3, new Player("Diego", seccionTablero, 22, List[Card](carta1, carta2, carta5), List[Card]()))
    assertEquals(jugador4, new Player("Agustín", seccionTablero, 20, List[Card](carta8, carta6), List[Card](carta2)))
    assertEquals(jugador5, new Player("Cucha", seccionTablero, 95, List[Card](carta4, carta5, carta2, carta7), List[Card](carta1, carta3, carta6, carta10)))
    assertEquals(jugador6, new Player("Blanquita", seccionTablero, 95, List[Card](carta9, carta10), List[Card](carta11, carta12)))
    assertEquals(jugador7, new Player("Simón", seccionTablero, 95, List[Card](), List[Card](carta10, carta7)))
    assertEquals(jugador8, new Player("Aki", seccionTablero, 95, List[Card](carta11, carta9, carta6, carta3), List[Card](carta2, carta12, carta8)))
    
    assert(!jugador1.equals(new Player("Emilio", seccionTablero, 15, List[Card](carta4, carta6), List[Card](carta7, carta12))))
    assert(!jugador2.equals(new Player("Diego", seccionTablero, 22, List[Card](carta1, carta2, carta5), List[Card]())))
    assert(!jugador3.equals(new Player("Agustín", seccionTablero, 20, List[Card](carta8, carta6), List[Card](carta2))))
    assert(!jugador4.equals(new Player("Cucha", seccionTablero, 95, List[Card](carta4, carta5, carta2, carta7), List[Card](carta1, carta3, carta6, carta10))))
    assert(!jugador5.equals(new Player("Blanquita", seccionTablero, 95, List[Card](carta9, carta10), List[Card](carta11, carta12))))
    assert(!jugador6.equals(new Player("Simón", seccionTablero, 95, List[Card](), List[Card](carta10, carta7))))
    assert(!jugador7.equals(new Player("Aki", seccionTablero, 95, List[Card](carta11, carta9, carta6, carta3), List[Card](carta2, carta12, carta8))))
    assert(!jugador8.equals(new Player("Constanza", seccionTablero, 100, List[Card](carta1), List[Card](carta3, carta4))))
  }

  test("hashCode") {
    assert(jugador1.hashCode() != jugador2.hashCode())
    assert(jugador2.hashCode() != jugador3.hashCode())
    assert(jugador3.hashCode() != jugador4.hashCode())
    assert(jugador4.hashCode() != jugador5.hashCode())
    assert(jugador5.hashCode() != jugador6.hashCode())
    assert(jugador6.hashCode() != jugador7.hashCode())
    assert(jugador7.hashCode() != jugador8.hashCode())
    assert(jugador8.hashCode() != jugador1.hashCode())

    assert(jugador1.hashCode() == (new Player("Constanza", seccionTablero, 100, List[Card](carta1), List[Card](carta3, carta4))).hashCode())
    assert(jugador2.hashCode() == (new Player("Emilio", seccionTablero, 15, List[Card](carta4, carta6), List[Card](carta7, carta12))).hashCode())
    assert(jugador3.hashCode() == (new Player("Diego", seccionTablero, 22, List[Card](carta1, carta2, carta5), List[Card]())).hashCode())
    assert(jugador4.hashCode() == (new Player("Agustín", seccionTablero, 20, List[Card](carta8, carta6), List[Card](carta2))).hashCode())
    assert(jugador5.hashCode() == (new Player("Cucha", seccionTablero, 95, List[Card](carta4, carta5, carta2, carta7), List[Card](carta1, carta3, carta6, carta10))).hashCode())
    assert(jugador6.hashCode() == (new Player("Blanquita", seccionTablero, 95, List[Card](carta9, carta10), List[Card](carta11, carta12))).hashCode())
    assert(jugador7.hashCode() == (new Player("Simón", seccionTablero, 95, List[Card](), List[Card](carta10, carta7))).hashCode())
    assert(jugador8.hashCode() == (new Player("Aki", seccionTablero, 95, List[Card](carta11, carta9, carta6, carta3), List[Card](carta2, carta12, carta8))).hashCode())
  }

  test("Nombre") {
    assertEquals(jugador1.nombre, nombre1)
    assertEquals(jugador2.nombre, nombre2)
    assertEquals(jugador3.nombre, nombre3)
    assertEquals(jugador4.nombre, nombre4)
    assertEquals(jugador5.nombre, nombre5)
    assertEquals(jugador6.nombre, nombre6)
    assertEquals(jugador7.nombre, nombre7)
    assertEquals(jugador8.nombre, nombre8)
    
    assert(!jugador1.nombre.equals(nombre2))
    assert(!jugador2.nombre.equals(nombre3))
    assert(!jugador3.nombre.equals(nombre4))
    assert(!jugador4.nombre.equals(nombre5))
    assert(!jugador5.nombre.equals(nombre6))
    assert(!jugador6.nombre.equals(nombre7))
    assert(!jugador7.nombre.equals(nombre8))
    assert(!jugador8.nombre.equals(nombre1))
  }

  test("Contador de Gemas") {
    assertEquals(jugador1.contadorGemas, contadorGemas1)
    assertEquals(jugador2.contadorGemas, contadorGemas2)
    assertEquals(jugador3.contadorGemas, contadorGemas3)
    assertEquals(jugador4.contadorGemas, contadorGemas4)
    assertEquals(jugador5.contadorGemas, contadorGemas5)
    assertEquals(jugador6.contadorGemas, contadorGemas5)
    assertEquals(jugador7.contadorGemas, contadorGemas5)
    assertEquals(jugador8.contadorGemas, contadorGemas5)

    assert(!jugador1.contadorGemas.equals(contadorGemas2))
    assert(!jugador2.contadorGemas.equals(contadorGemas3))
    assert(!jugador3.contadorGemas.equals(contadorGemas4))
    assert(!jugador4.contadorGemas.equals(contadorGemas5))
    assert(!jugador5.contadorGemas.equals(contadorGemas1))
    assert(!jugador6.contadorGemas.equals(contadorGemas3))
    assert(!jugador7.contadorGemas.equals(contadorGemas4))
    assert(!jugador8.contadorGemas.equals(contadorGemas1))
  }

  test("Mazo") {
    assertEquals(jugador1.mazo, List[Card](carta1))
    assertEquals(jugador2.mazo, List[Card](carta4, carta6))
    assertEquals(jugador3.mazo, List[Card](carta1, carta2, carta5))
    assertEquals(jugador4.mazo, List[Card](carta8, carta6))
    assertEquals(jugador5.mazo, List[Card](carta4, carta5, carta2, carta7))
    assertEquals(jugador6.mazo, List[Card](carta9, carta10))
    assertEquals(jugador7.mazo, List[Card]())
    assertEquals(jugador8.mazo, List[Card](carta11, carta9, carta6, carta3))

    assert(!jugador1.mazo.equals(List[Card](carta3)))
    assert(!jugador2.mazo.equals(List[Card](carta6, carta4)))
    assert(!jugador3.mazo.equals(List[Card](carta5, carta2, carta1)))
    assert(!jugador4.mazo.equals(List[Card](carta4, carta7, carta9, carta11, carta12)))
    assert(!jugador5.mazo.equals(List[Card](carta6, carta9)))
    assert(!jugador6.mazo.equals(List[Card](carta5)))
    assert(!jugador7.mazo.equals(List[Card](carta3, carta2, carta5)))
    assert(!jugador8.mazo.equals(List[Card](carta10, carta9, carta8)))
  }

  test("Mano") {
    assertEquals(jugador1.manoCartas, List[Card](carta3, carta4))
    assertEquals(jugador2.manoCartas, List[Card](carta7, carta12))
    assertEquals(jugador3.manoCartas, List[Card]())
    assertEquals(jugador4.manoCartas, List[Card](carta2))
    assertEquals(jugador5.manoCartas, List[Card](carta1, carta3, carta6, carta10))
    assertEquals(jugador6.manoCartas, List[Card](carta11, carta12))
    assertEquals(jugador7.manoCartas, List[Card](carta10, carta7))
    assertEquals(jugador8.manoCartas, List[Card](carta2, carta12, carta8))

    assert(!jugador1.manoCartas.equals(List[Card](carta4, carta2)))
    assert(!jugador2.manoCartas.equals(List[Card](carta12)))
    assert(!jugador3.manoCartas.equals(List[Card](carta5, carta2, carta1)))
    assert(!jugador4.manoCartas.equals(List[Card]()))
    assert(!jugador5.manoCartas.equals(List[Card](carta6, carta9)))
    assert(!jugador6.manoCartas.equals(List[Card](carta5)))
    assert(!jugador7.manoCartas.equals(List[Card](carta3, carta2)))
    assert(!jugador8.manoCartas.equals(List[Card](carta10, carta9, carta8)))
  }
  
  test("Robar") {
    val expected1 = new Player("Constanza", seccionTablero, 100, List[Card](), List[Card](carta1, carta3, carta4))
    jugador1.Robar()
    assertEquals(expected1, jugador1, "error")

    val expected2 = new Player("Emilio", seccionTablero, 15, List[Card](carta6), List[Card](carta4, carta7, carta12))
    jugador2.Robar()
    assertEquals(expected2, jugador2, "error")

    val expected3 = new Player("Diego", seccionTablero, 22, List[Card](carta2, carta5), List[Card](carta1))
    jugador3.Robar()
    assertEquals(expected3, jugador3, "error")

    val expected4 = new Player("Agustín", seccionTablero, 20, List[Card](carta6), List[Card](carta8, carta2))
    jugador4.Robar()
    assertEquals(expected4, jugador4, "error")

    val expected5 = new Player("Cucha", seccionTablero, 95, List[Card](carta5, carta2, carta7), List[Card](carta4, carta1, carta3, carta6, carta10))
    jugador5.Robar()
    assertEquals(expected5, jugador5, "error")
  }

  test("Seccion del tablero") {
    assertEquals (jugador1.seccionTablero, seccionTablero)
    assertEquals(jugador2.seccionTablero, seccionTablero)
    assertEquals(jugador3.seccionTablero, seccionTablero)
    assertEquals(jugador4.seccionTablero, seccionTablero)
    assertEquals(jugador5.seccionTablero, seccionTablero)
    assertEquals(jugador6.seccionTablero, seccionTablero)
    assertEquals(jugador7.seccionTablero, seccionTablero)
    assertEquals(jugador8.seccionTablero, seccionTablero)

    assert(!jugador1.seccionTablero.equals(seccionTablero2))
    assert(!jugador2.seccionTablero.equals(seccionTablero3))
    assert(!jugador3.seccionTablero.equals(seccionTablero2))
    assert(!jugador4.seccionTablero.equals(seccionTablero3))
    assert(!jugador5.seccionTablero.equals(seccionTablero2))
    assert(!jugador6.seccionTablero.equals(seccionTablero3))
    assert(!jugador7.seccionTablero.equals(seccionTablero2))
    assert(!jugador8.seccionTablero.equals(seccionTablero3))
  }
  
  test("Mezclar") {
    jugador3.mezclarMazo()
    jugador5.mezclarMazo()
    jugador6.mezclarMazo()
    jugador8.mezclarMazo()

    assert(!jugador3.mazo.equals(List[Card](carta2, carta5)))
    assert(!jugador3.mazo.equals(List[Card](carta5, carta2, carta7)))
    assert(!jugador3.mazo.equals(List[Card](carta11, carta9, carta10)))
    assert(!jugador3.mazo.equals(List[Card](carta2, carta11, carta9, carta6, carta3)))
  }
  
  test("Definiciones") {
    assert(!jugador1.contadorGemas.equals(nombre2))
    assert(!jugador2.nombre.equals(contadorGemas3))
    assert(!jugador3.seccionTablero.equals(nombre4))
    assert(!jugador4.contadorGemas.equals(seccionTablero))
    assert(!jugador5.nombre.equals(contadorGemas1))
    assert(!jugador6.seccionTablero.equals(nombre5))
    assert(!jugador7.contadorGemas.equals(seccionTablero))
    assert(!jugador8.nombre.equals(contadorGemas4))
  }

  test("Jogador") {
    assert(!jugador1.equals(carta1))
    assert(!jugador2.equals(carta2))
    assert(!jugador3.equals(carta3))
    assert(!jugador4.equals(carta4))
    assert(!jugador5.equals(carta5))
    assert(!jugador6.equals(carta6))
    assert(!jugador7.equals(carta7))
    assert(!jugador8.equals(carta8))
  }
    
}