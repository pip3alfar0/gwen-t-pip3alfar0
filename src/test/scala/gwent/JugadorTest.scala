package cl.uchile.dcc
package gwent

class JugadorTest extends munit.FunSuite{
  val nombre1: String = "Constanza"
  val nombre2: String = "Emilio"
  val nombre3: String = "Diego"
  val nombre4: String = "Agustín"
  val nombre5: String = "Cucha"
  val nombre6: String = "Blanquita"
  val nombre7: String = "Simón"
  val nombre8: String = "Pascal"

  var jugador1: Jugador = _  // null
  var jugador2: Jugador = _
  var jugador3: Jugador = _
  var jugador4: Jugador = _
  var jugador5: Jugador = _
  var jugador6: Jugador = _
  var jugador7: Jugador = _
  var jugador8: Jugador = _

  override def beforeEach(context: BeforeEach): Unit = {
    jugador1 = new Jugador("Constanza", "bobaboba", 100, Set[Cartas](new Asedio("carta1", "Asedio", 50)), Set[Cartas]())
    jugador2 = new Jugador("Emilio", "industrial", 15, Set[Cartas](), Set[Cartas]())
    jugador3 = new Jugador("Diego", "blablabla", 22, Set[Cartas](), Set[Cartas]())
    jugador4 = new Jugador("Agustín", "papitas", 20, Set[Cartas](), Set[Cartas]())
    jugador5 = new Jugador("Cucha", "miau", 95, Set[Cartas](), Set[Cartas]())
  }

  test("Equals"){
    assert(!jugador1.equals(jugador2))
    assert(!jugador3.equals(jugador4))
    assert(!jugador5.equals(jugador2))
  }

  test("hashCode") {
    assert(jugador1.hashCode() != jugador2.hashCode())
    assert(jugador2.hashCode() != jugador3.hashCode())
    assert(jugador3.hashCode() != jugador4.hashCode())
    assert(jugador4.hashCode() != jugador5.hashCode())
    assert(jugador5.hashCode() != jugador1.hashCode())

    assert(jugador1.hashCode() == (new Jugador("Constanza", "bobaboba", 100, Set[Cartas](new Asedio("carta1", "Asedio", 50)), Set[Cartas]())).hashCode())
    assert(jugador2.hashCode() == (new Jugador("Emilio", "industrial", 15, Set[Cartas](), Set[Cartas]())).hashCode())
    assert(jugador3.hashCode() == (new Jugador("Diego", "blablabla", 22, Set[Cartas](), Set[Cartas]())).hashCode())
    assert(jugador4.hashCode() == (new Jugador("Agustín", "papitas", 20, Set[Cartas](), Set[Cartas]())).hashCode())
    assert(jugador5.hashCode() == (new Jugador("Cucha", "miau", 95, Set[Cartas](), Set[Cartas]())).hashCode())
  }

  test("Nombres") {
    assertEquals(jugador1.nombre, nombre1)
    assertEquals(jugador2.nombre, nombre2)
    assertEquals(jugador3.nombre, nombre3)
    assertEquals(jugador4.nombre, nombre4)
    assertEquals(jugador5.nombre, nombre5)
  }

  test("Robar") {
    val expected = new Jugador("Constanza", "bobaboba", 100, Set[Cartas](), Set[Cartas](new Asedio("carta1", "Asedio", 50)))
    jugador1.Robar()
    assertEquals(expected, jugador1, "error")
  }

  test("Jogador") {
    assert(!jugador1.equals(new Asedio("carta1", "Asedio", 50)))
    assert(!jugador2.equals(new CartaClima("carta2", "a")))
  }
    
}