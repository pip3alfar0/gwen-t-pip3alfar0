package cl.uchile.dcc
package gwent

class CartasTest extends munit.FunSuite {
    var carta1 = new CartasClima("carta1", "a")
    var carta2 = new CartasUnidad("carta2", "Asedio", 15)
    var carta3 = new CartasUnidad("carta3", "Distancia", 25)
    var carta4 = new CartasClima("carta4", "b")
    var carta5 = new CartasUnidad("carta5", "Cuerpo a Cuerpo", 12)

    test("Equals"){
        assertEquals(carta1,carta1)
        assertEquals(carta4,carta4)
        assertNotEquals(carta1,carta4)
        assertNotEquals(carta2,carta3)
        assertNotEquals(carta3,carta5)
        assert(!carta3.equals(carta4))
        assert(!carta1.equals(carta5))
    }
}
