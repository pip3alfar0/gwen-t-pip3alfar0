package cl.uchile.dcc
package gwent

class JugadorTest extends munit.FunSuite{
  var jugador1: Jugador = null
  var jugador2: Jugador = null
  var jugador3: Jugador = null
  var jugador4: Jugador = null
  var jugador5: Jugador = null

  override def beforeEach(context: BeforeEach): Unit = {
    jugador1 = new Jugador("Constanza", "bobaboba", 100, Set[Cartas](), Set[Cartas]())
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
    
}
