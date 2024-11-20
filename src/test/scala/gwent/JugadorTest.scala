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
  val nombre8: String = "Aki"

  val seccionTablero1: String = "1"
  val seccionTablero2: String = "2"

  val contadorGemas1: Int = 100
  val contadorGemas2: Int = 15
  val contadorGemas3: Int = 22
  val contadorGemas4: Int = 20
  val contadorGemas5: Int = 95
  
  var jugador1: Jugador = _  // null
  var jugador2: Jugador = _
  var jugador3: Jugador = _
  var jugador4: Jugador = _
  var jugador5: Jugador = _
  var jugador6: Jugador = _
  var jugador7: Jugador = _
  var jugador8: Jugador = _

  // for the Player's cards or deck's cards
  var carta1: Asedio = _ // null
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
    
    jugador1 = new Jugador("Constanza", "1", 100, List[Cartas](carta1), List[Cartas](carta3, carta4))
    jugador2 = new Jugador("Emilio", "2", 15, List[Cartas](carta4, carta6), List[Cartas](carta7, carta12))
    jugador3 = new Jugador("Diego", "1", 22, List[Cartas](carta1, carta2, carta5), List[Cartas]())
    jugador4 = new Jugador("Agustín", "2", 20, List[Cartas](carta8, carta6), List[Cartas](carta2))
    jugador5 = new Jugador("Cucha", "1", 95, List[Cartas](carta4, carta5, carta2, carta7), List[Cartas](carta1, carta3, carta6, carta10))
    jugador6 = new Jugador("Blanquita", "2", 95, List[Cartas](carta9, carta10), List[Cartas](carta11, carta12))
    jugador7 = new Jugador("Simón", "1", 95, List[Cartas](), List[Cartas](carta10, carta7))
    jugador8 = new Jugador("Aki", "2", 95, List[Cartas](carta11, carta9, carta6, carta3), List[Cartas](carta2, carta12, carta8))
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
    
    assertEquals(jugador1, new Jugador("Constanza", "1", 100, List[Cartas](carta1), List[Cartas](carta3, carta4)))
    assertEquals(jugador2, new Jugador("Emilio", "2", 15, List[Cartas](carta4, carta6), List[Cartas](carta7, carta12)))
    assertEquals(jugador3, new Jugador("Diego", "1", 22, List[Cartas](carta1, carta2, carta5), List[Cartas]()))
    assertEquals(jugador4, new Jugador("Agustín", "2", 20, List[Cartas](carta8, carta6), List[Cartas](carta2)))
    assertEquals(jugador5, new Jugador("Cucha", "1", 95, List[Cartas](carta4, carta5, carta2, carta7), List[Cartas](carta1, carta3, carta6, carta10)))
    assertEquals(jugador6, new Jugador("Blanquita", "2", 95, List[Cartas](carta9, carta10), List[Cartas](carta11, carta12)))
    assertEquals(jugador7, new Jugador("Simón", "1", 95, List[Cartas](), List[Cartas](carta10, carta7)))
    assertEquals(jugador8, new Jugador("Aki", "2", 95, List[Cartas](carta11, carta9, carta6, carta3), List[Cartas](carta2, carta12, carta8)))
    
    assert(!jugador1.equals(new Jugador("Emilio", "2", 15, List[Cartas](carta4, carta6), List[Cartas](carta7, carta12))))
    assert(!jugador2.equals(new Jugador("Diego", "1", 22, List[Cartas](carta1, carta2, carta5), List[Cartas]())))
    assert(!jugador3.equals(new Jugador("Agustín", "2", 20, List[Cartas](carta8, carta6), List[Cartas](carta2))))
    assert(!jugador4.equals(new Jugador("Cucha", "1", 95, List[Cartas](carta4, carta5, carta2, carta7), List[Cartas](carta1, carta3, carta6, carta10))))
    assert(!jugador5.equals(new Jugador("Blanquita", "2", 95, List[Cartas](carta9, carta10), List[Cartas](carta11, carta12))))
    assert(!jugador6.equals(new Jugador("Simón", "1", 95, List[Cartas](), List[Cartas](carta10, carta7))))
    assert(!jugador7.equals(new Jugador("Aki", "2", 95, List[Cartas](carta11, carta9, carta6, carta3), List[Cartas](carta2, carta12, carta8))))
    assert(!jugador8.equals(new Jugador("Constanza", "1", 100, List[Cartas](carta1), List[Cartas](carta3, carta4))))
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

    assert(jugador1.hashCode() == (new Jugador("Constanza", "1", 100, List[Cartas](carta1), List[Cartas](carta3, carta4))).hashCode())
    assert(jugador2.hashCode() == (new Jugador("Emilio", "2", 15, List[Cartas](carta4, carta6), List[Cartas](carta7, carta12))).hashCode())
    assert(jugador3.hashCode() == (new Jugador("Diego", "1", 22, List[Cartas](carta1, carta2, carta5), List[Cartas]())).hashCode())
    assert(jugador4.hashCode() == (new Jugador("Agustín", "2", 20, List[Cartas](carta8, carta6), List[Cartas](carta2))).hashCode())
    assert(jugador5.hashCode() == (new Jugador("Cucha", "1", 95, List[Cartas](carta4, carta5, carta2, carta7), List[Cartas](carta1, carta3, carta6, carta10))).hashCode())
    assert(jugador6.hashCode() == (new Jugador("Blanquita", "2", 95, List[Cartas](carta9, carta10), List[Cartas](carta11, carta12))).hashCode())
    assert(jugador7.hashCode() == (new Jugador("Simón", "1", 95, List[Cartas](), List[Cartas](carta10, carta7))).hashCode())
    assert(jugador8.hashCode() == (new Jugador("Aki", "2", 95, List[Cartas](carta11, carta9, carta6, carta3), List[Cartas](carta2, carta12, carta8))).hashCode())
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

  test("Seccion del tablero") {
    assertEquals(jugador1.seccionTablero, seccionTablero1)
    assertEquals(jugador2.seccionTablero, seccionTablero2)
    assertEquals(jugador3.seccionTablero, seccionTablero1)
    assertEquals(jugador4.seccionTablero, seccionTablero2)
    assertEquals(jugador5.seccionTablero, seccionTablero1)
    assertEquals(jugador6.seccionTablero, seccionTablero2)
    assertEquals(jugador7.seccionTablero, seccionTablero1)
    assertEquals(jugador8.seccionTablero, seccionTablero2)

    assert(!jugador1.seccionTablero.equals(seccionTablero2))
    assert(!jugador2.seccionTablero.equals(seccionTablero1))
    assert(!jugador3.seccionTablero.equals(seccionTablero2))
    assert(!jugador4.seccionTablero.equals(seccionTablero1))
    assert(!jugador5.seccionTablero.equals(seccionTablero2))
    assert(!jugador6.seccionTablero.equals(seccionTablero1))
    assert(!jugador7.seccionTablero.equals(seccionTablero2))
    assert(!jugador8.seccionTablero.equals(seccionTablero1))
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
  
  /*
  test("Mazo") {
    //assertEquals(jugador1.mazo, List[Cartas](carta1))
  }

  test("Mano") {
    //assertEquals(jugador1.mano, List[Cartas](carta3, carta4))
  }
  */
  
  test("Robar") {
    val expected1 = new Jugador("Constanza", "1", 100, List[Cartas](), List[Cartas](carta1, carta3, carta4))
    jugador1.Robar()
    assertEquals(expected1, jugador1, "error")

    val expected2 = new Jugador("Emilio", "2", 15, List[Cartas](carta6), List[Cartas](carta4, carta7, carta12))
    jugador2.Robar()
    assertEquals(expected2, jugador2, "error")

    val expected3 = new Jugador("Diego", "1", 22, List[Cartas](carta2, carta5), List[Cartas](carta1))
    jugador3.Robar()
    assertEquals(expected3, jugador3, "error")

    val expected4 = new Jugador("Agustín", "2", 20, List[Cartas](carta6), List[Cartas](carta8, carta2))
    jugador4.Robar()
    assertEquals(expected4, jugador4, "error")

    val expected5 = new Jugador("Cucha", "1", 95, List[Cartas](carta5, carta2, carta7), List[Cartas](carta4, carta1, carta3, carta6, carta10))
    jugador5.Robar()
    assertEquals(expected5, jugador5, "error")
  }

  test("Jugar") {
    val expected6 = new Jugador("Blanquita", "2", 95, List[Cartas](carta11, carta9, carta10), List[Cartas](carta12))
    jugador6.Jugar()
    assertEquals(expected6, jugador6, "error")

    val expected7 = new Jugador("Simón", "1", 95, List[Cartas](carta10), List[Cartas](carta7))
    jugador7.Jugar()
    assertEquals(expected7, jugador7, "error")

    val expected8 = new Jugador("Aki", "2", 95, List[Cartas](carta2, carta11, carta9, carta6, carta3), List[Cartas](carta12, carta8))
    jugador8.Jugar()
    assertEquals(expected8, jugador8, "error")
  }
  
  test("Mezclar") {
    jugador3.mezclarMazo()
    jugador5.mezclarMazo()
    jugador6.mezclarMazo()
    jugador8.mezclarMazo()

    assert(!jugador3.mazo.equals(List[Cartas](carta2, carta5)))
    assert(!jugador3.mazo.equals(List[Cartas](carta5, carta2, carta7)))
    assert(!jugador3.mazo.equals(List[Cartas](carta11, carta9, carta10)))
    assert(!jugador3.mazo.equals(List[Cartas](carta2, carta11, carta9, carta6, carta3)))
  }
  
  test("Definiciones") {
    assert(!jugador1.contadorGemas.equals(nombre2))
    assert(!jugador2.nombre.equals(contadorGemas3))
    assert(!jugador3.seccionTablero.equals(nombre4))
    assert(!jugador4.contadorGemas.equals(seccionTablero2))
    assert(!jugador5.nombre.equals(contadorGemas1))
    assert(!jugador6.seccionTablero.equals(nombre5))
    assert(!jugador7.contadorGemas.equals(seccionTablero1))
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