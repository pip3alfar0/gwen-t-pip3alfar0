package cl.uchile.dcc
package gwent

class CartasTest extends munit.FunSuite {
    val nombre1: String = "carta1"
    val nombre2: String = "carta2"
    val nombre3: String = "carta3"
    val nombre4: String = "carta4"
    val nombre5: String = "carta5"

    var carta1: CartaUnidad = _  // null
    var carta2: CartaClima = _
    var carta3: CartaUnidad = _
    var carta4: CartaUnidad = _
    var carta5: CartaClima = _
    
    
    override def beforeEach(context: BeforeEach): Unit = {
        carta1 = new CartaUnidad("carta1", "Asedio", 50)
        carta2 = new CartaClima("carta2", "a")
        carta3 = new CartaUnidad("carta3", "Cuerpo a Cuerpo", 90)
        carta4 = new CartaUnidad("carta4", "Distancia", 35)
        carta5 = new CartaClima("carta5", "b")
    }

    test("Equals"){
        carta1.equals(carta1)
        carta2.equals(carta2)
        carta3.equals(carta3)
        carta4.equals(carta4)
        carta5.equals(carta5)

        assert(!carta1.equals(carta2))
        assert(!carta1.equals(carta3))
        assert(!carta1.equals(carta4))
        assert(!carta1.equals(carta5))
        assert(!carta4.equals(carta5))

        assertEquals(carta1, new CartaUnidad("carta1", "Asedio", 50))
        assertEquals(carta2, new CartaClima("carta2", "a"))
        assertEquals(carta3, new CartaUnidad("carta3", "Cuerpo a Cuerpo", 90))
        assertEquals(carta1, carta1)
        assertEquals(carta4, carta4)
        assertNotEquals(carta1, carta4)
        assertNotEquals(carta3, carta4)
        assertNotEquals(carta2, carta5)
        assert(!carta3.equals(carta4))
        assert(!carta1.equals(carta5))
        assert(!carta1.equals(carta2))
        assert(!carta3.equals(carta5))
    }

    test("hashCode"){
        assert(carta1.hashCode()!=carta2.hashCode())
        assert(carta2.hashCode()!=carta3.hashCode())
        assert(carta3.hashCode()!=carta4.hashCode())
        assert(carta4.hashCode()!=carta5.hashCode())
        assert(carta5.hashCode()!=carta1.hashCode())
        
        assert(carta1.hashCode() == (new CartaUnidad("carta1", "Asedio", 50)).hashCode())
        assert(carta2.hashCode() == (new CartaClima("carta2", "a")).hashCode())
        assert(carta3.hashCode() == (new CartaUnidad("carta3", "Cuerpo a Cuerpo", 90)).hashCode())
        assert(carta4.hashCode() == (new CartaUnidad("carta4", "Distancia", 35)).hashCode())
        assert(carta5.hashCode() == (new CartaClima("carta5", "b")).hashCode())
    }

    test("Nombres") {
        assertEquals(carta1.nombre, nombre1)
        assertEquals(carta2.nombre, nombre2)
        assertEquals(carta3.nombre, nombre3)
        assertEquals(carta4.nombre, nombre4)
        assertEquals(carta5.nombre, nombre5)
    }

    test("Jogador") {
        assert(!carta1.equals(new Jugador("Simba", "miau miau", 90, Set[Cartas](), Set[Cartas]())))
        assert(!carta2.equals(new Jugador("Kitty", "miau miau miau", 100, Set[Cartas](), Set[Cartas]())))
    }

}
