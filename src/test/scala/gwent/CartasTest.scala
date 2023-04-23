package cl.uchile.dcc
package gwent

class CartasTest extends munit.FunSuite {
    var carta1: Cartas = null
    var carta2: Cartas = null
    var carta3: Cartas = null
    var carta4: Cartas = null
    var carta5: Cartas = null

    override def beforeEach(context: BeforeEach): Unit = {
        carta1 = new Cartas("carta1", "Clima")
        carta2 = new Cartas("carta2", "Unidad")
        carta3 = new Cartas("carta3", "Unidad")
        carta4 = new Cartas("carta4", "Clima")
        carta5 = new Cartas("carta5", "Unidad")
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

        assertEquals(carta1, new Cartas("carta1", "Clima"))
        assertEquals(carta3, new Cartas("carta3", "Unidad"))
        assertEquals(carta1, carta1)
        assertEquals(carta4, carta4)
        assertNotEquals(carta1, carta4)
        assertNotEquals(carta2, carta3)
        assertNotEquals(carta3, carta5)
        assert(!carta3.equals(carta4))
        assert(!carta1.equals(carta5))
    }

    test("hashCode"){
        assert(carta1.hashCode()!=carta2.hashCode())
        assert(carta2.hashCode()!=carta3.hashCode())
        assert(carta3.hashCode()!=carta4.hashCode())
        assert(carta4.hashCode()!=carta5.hashCode())
        assert(carta5.hashCode()!=carta1.hashCode())
        
        assert(carta1.hashCode() == (new Cartas("carta1", "Clima")).hashCode())
        assert(carta2.hashCode() == (new Cartas("carta2", "Unidad")).hashCode())
        assert(carta3.hashCode() == (new Cartas("carta3", "Unidad")).hashCode())
        assert(carta4.hashCode() == (new Cartas("carta4", "Clima")).hashCode())
        assert(carta5.hashCode() == (new Cartas("carta5", "Unidad")).hashCode())
    }


}
