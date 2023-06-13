package cl.uchile.dcc
package gwent

import gwent.Cartas.{WeatherCard, Card}

import cl.uchile.dcc.gwent.Cartas.Unidad.{SiegeCombatCard, CloseCombatCard, RangedCombatCard}
import cl.uchile.dcc.gwent.Jugador.Player
import cl.uchile.dcc.gwent.Tablero.boardSection

class CartasTest extends munit.FunSuite {
    val nombre1: String = "carta1"
    val nombre2: String = "carta2"
    val nombre3: String = "carta3"
    val nombre4: String = "carta4"
    val nombre5: String = "carta5"
    val nombre6: String = "carta6"
    val nombre7: String = "carta7"
    val nombre8: String = "carta8"

    val descripcion1: String = "Asedio"
    val descripcion2: String = "a"
    val descripcion3: String = "Cuerpo a Cuerpo"
    val descripcion4: String = "b"
    val descripcion5: String = "Distancia"

    val fuerza1: Int = 50
    val fuerza2: Int = 90
    val fuerza3: Int = 35
    val fuerza4: Int = 70
    val fuerza5: Int = 45
    val fuerza6: Int = 25

    var carta1: SiegeCombatCard = _  // null
    var carta2: WeatherCard = _
    var carta3: CloseCombatCard = _
    var carta4: RangedCombatCard = _
    var carta5: WeatherCard = _
    var carta6: SiegeCombatCard = _
    var carta7: CloseCombatCard = _
    var carta8: RangedCombatCard = _


    override def beforeEach(context: BeforeEach): Unit = {
        carta1 = new SiegeCombatCard("carta1", "Asedio", 50)
        carta2 = new WeatherCard("carta2", "a")
        carta3 = new CloseCombatCard("carta3", "Cuerpo a Cuerpo", 90)
        carta4 = new RangedCombatCard("carta4", "Distancia", 35)
        carta5 = new WeatherCard("carta5", "b")
        carta6 = new SiegeCombatCard("carta6", "Asedio", 70)
        carta7 = new CloseCombatCard("carta7", "Cuerpo a Cuerpo", 45)
        carta8 = new RangedCombatCard("carta8", "Distancia", 25)
    }

    test("Equals"){
        carta1.equals(carta1)
        carta2.equals(carta2)
        carta3.equals(carta3)
        carta4.equals(carta4)
        carta5.equals(carta5)
        carta6.equals(carta6)
        carta7.equals(carta7)
        carta8.equals(carta8)

        assertEquals(carta1, new SiegeCombatCard("carta1", "Asedio", 50))
        assertEquals(carta2, new WeatherCard("carta2", "a"))
        assertEquals(carta3, new CloseCombatCard("carta3", "Cuerpo a Cuerpo", 90))
        assertEquals(carta4, new RangedCombatCard("carta4", "Distancia", 35))
        assertEquals(carta5, new WeatherCard("carta5", "b"))
        assertEquals(carta6, new SiegeCombatCard("carta6", "Asedio", 70))
        assertEquals(carta7, new CloseCombatCard("carta7", "Cuerpo a Cuerpo", 45))
        assertEquals(carta8, new RangedCombatCard("carta8", "Distancia", 25))

        assert(!carta1.equals(new WeatherCard("carta2", "a")))
        assert(!carta2.equals(new CloseCombatCard("carta3", "Cuerpo a Cuerpo", 90)))
        assert(!carta3.equals(new RangedCombatCard("carta4", "Distancia", 35)))
        assert(!carta4.equals(new WeatherCard("carta5", "b")))
        assert(!carta5.equals(new SiegeCombatCard("carta6", "Asedio", 70)))
        assert(!carta6.equals(new CloseCombatCard("carta7", "Cuerpo a Cuerpo", 45)))
        assert(!carta7.equals(new RangedCombatCard("carta8", "Distancia", 25)))
        assert(!carta8.equals(new SiegeCombatCard("carta1", "Asedio", 50)))

        assertEquals(carta1, carta1)
        assertEquals(carta2, carta2)
        assertEquals(carta3, carta3)
        assertEquals(carta4, carta4)
        assertEquals(carta5, carta5)
        assertEquals(carta6, carta6)
        assertEquals(carta7, carta7)
        assertEquals(carta8, carta8)
        assert(!carta1.equals(carta2))
        assert(!carta1.equals(carta3))
        assert(!carta1.equals(carta4))
        assert(!carta1.equals(carta5))
        assert(!carta1.equals(carta6))
        assert(!carta1.equals(carta7))
        assert(!carta1.equals(carta8))
        assert(!carta2.equals(carta3))
        assert(!carta2.equals(carta4))
        assert(!carta2.equals(carta5))
        assert(!carta2.equals(carta6))
        assert(!carta2.equals(carta7))
        assert(!carta2.equals(carta8))
        assert(!carta3.equals(carta4))
        assert(!carta3.equals(carta5))
        assert(!carta3.equals(carta6))
        assert(!carta3.equals(carta7))
        assert(!carta3.equals(carta8))
        assert(!carta4.equals(carta5))
        assert(!carta4.equals(carta6))
        assert(!carta4.equals(carta7))
        assert(!carta4.equals(carta8))
        assert(!carta5.equals(carta6))
        assert(!carta5.equals(carta7))
        assert(!carta5.equals(carta8))
        assert(!carta6.equals(carta7))
        assert(!carta6.equals(carta8))
        assert(!carta7.equals(carta8))
    }

    test("hashCode"){
        assert(carta1.hashCode()!=carta2.hashCode())
        assert(carta2.hashCode()!=carta3.hashCode())
        assert(carta3.hashCode()!=carta4.hashCode())
        assert(carta4.hashCode()!=carta5.hashCode())
        assert(carta5.hashCode()!=carta6.hashCode())
        assert(carta6.hashCode()!=carta7.hashCode())
        assert(carta7.hashCode()!=carta8.hashCode())
        assert(carta8.hashCode()!=carta1.hashCode())
        
        assert(carta1.hashCode() == (new SiegeCombatCard("carta1", "Asedio", 50)).hashCode())
        assert(carta2.hashCode() == (new WeatherCard("carta2", "a")).hashCode())
        assert(carta3.hashCode() == (new CloseCombatCard("carta3", "Cuerpo a Cuerpo", 90)).hashCode())
        assert(carta4.hashCode() == (new RangedCombatCard("carta4", "Distancia", 35)).hashCode())
        assert(carta5.hashCode() == (new WeatherCard("carta5", "b")).hashCode())
        assert(carta6.hashCode() == (new SiegeCombatCard("carta6", "Asedio", 70)).hashCode())
        assert(carta7.hashCode() == (new CloseCombatCard("carta7", "Cuerpo a Cuerpo", 45)).hashCode())
        assert(carta8.hashCode() == (new RangedCombatCard("carta8", "Distancia", 25)).hashCode())
    }

    test("Nombre") {
        assertEquals(carta1.nombre, nombre1)
        assertEquals(carta2.nombre, nombre2)
        assertEquals(carta3.nombre, nombre3)
        assertEquals(carta4.nombre, nombre4)
        assertEquals(carta5.nombre, nombre5)
        assertEquals(carta6.nombre, nombre6)
        assertEquals(carta7.nombre, nombre7)
        assertEquals(carta8.nombre, nombre8)

        assert(!carta1.nombre.equals(nombre2))
        assert(!carta2.nombre.equals(nombre3))
        assert(!carta3.nombre.equals(nombre4))
        assert(!carta4.nombre.equals(nombre5))
        assert(!carta5.nombre.equals(nombre6))
        assert(!carta6.nombre.equals(nombre7))
        assert(!carta7.nombre.equals(nombre8))
        assert(!carta8.nombre.equals(nombre1))
    }

    test("Descripcion") {
        assertEquals(carta1.descripcion, descripcion1)
        assertEquals(carta2.descripcion, descripcion2)
        assertEquals(carta3.descripcion, descripcion3)
        assertEquals(carta4.descripcion, descripcion5)
        assertEquals(carta5.descripcion, descripcion4)
        assertEquals(carta6.descripcion, descripcion1)
        assertEquals(carta7.descripcion, descripcion3)
        assertEquals(carta8.descripcion, descripcion5)

        assert(!carta1.nombre.equals(descripcion2))
        assert(!carta2.nombre.equals(descripcion3))
        assert(!carta3.nombre.equals(descripcion4))
        assert(!carta4.nombre.equals(descripcion2))
        assert(!carta5.nombre.equals(descripcion3))
        assert(!carta6.nombre.equals(descripcion4))
        assert(!carta7.nombre.equals(descripcion5))
        assert(!carta8.nombre.equals(descripcion1))
    }

    test("Fuerza") {
        assertEquals(carta1.fuerza, fuerza1)
        assertEquals(carta3.fuerza, fuerza2)
        assertEquals(carta4.fuerza, fuerza3)
        assertEquals(carta6.fuerza, fuerza4)
        assertEquals(carta7.fuerza, fuerza5)
        assertEquals(carta8.fuerza, fuerza6)

        assert(!carta1.fuerza.equals(fuerza2))
        assert(!carta3.fuerza.equals(fuerza3))
        assert(!carta4.fuerza.equals(fuerza4))
        assert(!carta6.fuerza.equals(fuerza5))
        assert(!carta7.fuerza.equals(fuerza6))
        assert(!carta8.fuerza.equals(fuerza1))
    }

    test("Definiciones") {
        assert(!carta1.fuerza.equals(descripcion1))
        assert(!carta2.nombre.equals(fuerza6))
        assert(!carta3.fuerza.equals(nombre3))
        assert(!carta4.fuerza.equals(descripcion2))
        assert(!carta5.descripcion.equals(descripcion1))
        assert(!carta6.nombre.equals(fuerza4))
        assert(!carta7.fuerza.equals(descripcion3))
        assert(!carta8.descripcion.equals(fuerza2))
    }

    test("Jogador") {
        assert(!carta1.equals(new Player("Simba", new boardSection(), 90, List[Card](), List[Card]())))
        assert(!carta2.equals(new Player("Kitty", new boardSection(), 100, List[Card](), List[Card]())))
    }

}
