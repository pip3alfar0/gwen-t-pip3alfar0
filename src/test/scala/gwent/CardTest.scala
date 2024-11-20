package cl.uchile.dcc
package gwent

import gwent.cards.{Card, WeatherCard}
import gwent.cards.unit.{CloseCombatCard, RangedCombatCard, SiegeCombatCard, UnitCard}
import gwent.player.Player
import gwent.board.BoardSection
import gwent.cards.effects.weather.{BitingFrost, TorrentialRain}
import gwent.cards.effects.unit.{TightBond, MoraleBoost}
import gwent.cards.effects.Effect
import gwent.cards.effects.NullEffect


class CardTest extends munit.FunSuite {
    val name1: String = "card1"
    val name2: String = "card2"
    val name3: String = "card3"
    val name4: String = "card4"
    val name5: String = "card5"
    val name6: String = "card6"
    val name7: String = "card7"
    val name8: String = "card8"

    val description1: String = "SiegeCombat"
    val description2: String = "Torrential Rain"
    val description3: String = "CloseCombat"
    val description4: String = "Biting Frost"
    val description5: String = "RangedCombat"

    val power1: Int = 50
    val power2: Int = 90
    val power3: Int = 35
    val power4: Int = 70
    val power5: Int = 45
    val power6: Int = 25

    var card1: SiegeCombatCard = _  // null
    var card2: WeatherCard = _
    var card3: CloseCombatCard = _
    var card4: RangedCombatCard = _
    var card5: WeatherCard = _
    var card6: SiegeCombatCard = _
    var card7: CloseCombatCard = _
    var card8: RangedCombatCard = _


    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new SiegeCombatCard("card1", "SiegeCombat", 50, TightBond())
        card2 = new WeatherCard("card2", "Torrential Rain", TorrentialRain())
        card3 = new CloseCombatCard("card3", "CloseCombat", 90, NullEffect())
        card4 = new RangedCombatCard("card4", "RangedCombat", 35, NullEffect())
        card5 = new WeatherCard("card5", "Biting Frost", BitingFrost())
        card6 = new SiegeCombatCard("card6", "SiegeCombat", 70, MoraleBoost())
        card7 = new CloseCombatCard("card7", "CloseCombat", 45, NullEffect())
        card8 = new RangedCombatCard("card8", "RangedCombat", 25, NullEffect())
    }

    test("Equals"){
        card1.equals(card1)
        card2.equals(card2)
        card3.equals(card3)
        card4.equals(card4)
        card5.equals(card5)
        card6.equals(card6)
        card7.equals(card7)
        card8.equals(card8)

        assertEquals(card1, new SiegeCombatCard("card1", "SiegeCombat", 50, TightBond()))
        assertEquals(card2, new WeatherCard("card2", "Torrential Rain", TorrentialRain()))
        assertEquals(card3, new CloseCombatCard("card3", "CloseCombat", 90, NullEffect()))
        assertEquals(card4, new RangedCombatCard("card4", "RangedCombat", 35, NullEffect()))
        assertEquals(card5, new WeatherCard("card5", "Biting Frost", BitingFrost()))
        assertEquals(card6, new SiegeCombatCard("card6", "SiegeCombat", 70, MoraleBoost()))
        assertEquals(card7, new CloseCombatCard("card7", "CloseCombat", 45, NullEffect()))
        assertEquals(card8, new RangedCombatCard("card8", "RangedCombat", 25, NullEffect()))

        assert(!card1.equals(new WeatherCard("card2", "Torrential Rain", TorrentialRain())))
        assert(!card2.equals(new CloseCombatCard("card3", "CloseCombat", 90, NullEffect())))
        assert(!card3.equals(new RangedCombatCard("card4", "RangedCombat", 35, NullEffect())))
        assert(!card4.equals(new WeatherCard("card5", "Biting Frost", BitingFrost())))
        assert(!card5.equals(new SiegeCombatCard("card6", "SiegeCombat", 70, MoraleBoost())))
        assert(!card6.equals(new CloseCombatCard("card7", "CloseCombat", 45, NullEffect())))
        assert(!card7.equals(new RangedCombatCard("card8", "RangedCombat", 25, NullEffect())))
        assert(!card8.equals(new SiegeCombatCard("card1", "SiegeCombat", 50, TightBond())))

        assertEquals(card1, card1)
        assertEquals(card2, card2)
        assertEquals(card3, card3)
        assertEquals(card4, card4)
        assertEquals(card5, card5)
        assertEquals(card6, card6)
        assertEquals(card7, card7)
        assertEquals(card8, card8)
        assert(!card1.equals(card2))
        assert(!card1.equals(card3))
        assert(!card1.equals(card4))
        assert(!card1.equals(card5))
        assert(!card1.equals(card6))
        assert(!card1.equals(card7))
        assert(!card1.equals(card8))
        assert(!card2.equals(card3))
        assert(!card2.equals(card4))
        assert(!card2.equals(card5))
        assert(!card2.equals(card6))
        assert(!card2.equals(card7))
        assert(!card2.equals(card8))
        assert(!card3.equals(card4))
        assert(!card3.equals(card5))
        assert(!card3.equals(card6))
        assert(!card3.equals(card7))
        assert(!card3.equals(card8))
        assert(!card4.equals(card5))
        assert(!card4.equals(card6))
        assert(!card4.equals(card7))
        assert(!card4.equals(card8))
        assert(!card5.equals(card6))
        assert(!card5.equals(card7))
        assert(!card5.equals(card8))
        assert(!card6.equals(card7))
        assert(!card6.equals(card8))
        assert(!card7.equals(card8))
    }

    test("hashCode"){
        assert(card1.hashCode()!=card2.hashCode())
        assert(card2.hashCode()!=card3.hashCode())
        assert(card3.hashCode()!=card4.hashCode())
        assert(card4.hashCode()!=card5.hashCode())
        assert(card5.hashCode()!=card6.hashCode())
        assert(card6.hashCode()!=card7.hashCode())
        assert(card7.hashCode()!=card8.hashCode())
        assert(card8.hashCode()!=card1.hashCode())
        
        assert(card1.hashCode() == (new SiegeCombatCard("card1", "SiegeCombat", 50, TightBond())).hashCode())
        assert(card2.hashCode() == (new WeatherCard("card2", "Torrential Rain", TorrentialRain())).hashCode())
        assert(card3.hashCode() == (new CloseCombatCard("card3", "CloseCombat", 90, NullEffect())).hashCode())
        assert(card4.hashCode() == (new RangedCombatCard("card4", "RangedCombat", 35, NullEffect())).hashCode())
        assert(card5.hashCode() == (new WeatherCard("card5", "Biting Frost", BitingFrost())).hashCode())
        assert(card6.hashCode() == (new SiegeCombatCard("card6", "SiegeCombat", 70, MoraleBoost())).hashCode())
        assert(card7.hashCode() == (new CloseCombatCard("card7", "CloseCombat", 45, NullEffect())).hashCode())
        assert(card8.hashCode() == (new RangedCombatCard("card8", "RangedCombat", 25, NullEffect())).hashCode())
    }

    test("Name") {
        assertEquals(card1.name, name1)
        assertEquals(card2.name, name2)
        assertEquals(card3.name, name3)
        assertEquals(card4.name, name4)
        assertEquals(card5.name, name5)
        assertEquals(card6.name, name6)
        assertEquals(card7.name, name7)
        assertEquals(card8.name, name8)

        assert(!card1.name.equals(name2))
        assert(!card2.name.equals(name3))
        assert(!card3.name.equals(name4))
        assert(!card4.name.equals(name5))
        assert(!card5.name.equals(name6))
        assert(!card6.name.equals(name7))
        assert(!card7.name.equals(name8))
        assert(!card8.name.equals(name1))
    }

    test("Description") {
        assertEquals(card1.description, description1)
        assertEquals(card2.description, description2)
        assertEquals(card3.description, description3)
        assertEquals(card4.description, description5)
        assertEquals(card5.description, description4)
        assertEquals(card6.description, description1)
        assertEquals(card7.description, description3)
        assertEquals(card8.description, description5)

        assert(!card1.name.equals(description2))
        assert(!card2.name.equals(description3))
        assert(!card3.name.equals(description4))
        assert(!card4.name.equals(description2))
        assert(!card5.name.equals(description3))
        assert(!card6.name.equals(description4))
        assert(!card7.name.equals(description5))
        assert(!card8.name.equals(description1))
    }

    test("Power") {
        assertEquals(card1.power, power1)
        assertEquals(card3.power, power2)
        assertEquals(card4.power, power3)
        assertEquals(card6.power, power4)
        assertEquals(card7.power, power5)
        assertEquals(card8.power, power6)

        assert(!card1.power.equals(power2))
        assert(!card3.power.equals(power3))
        assert(!card4.power.equals(power4))
        assert(!card6.power.equals(power5))
        assert(!card7.power.equals(power6))
        assert(!card8.power.equals(power1))
    }

    test("Effect") {

    }

    test("Definitions") {
        assert(!card1.power.equals(name1))
        assert(!card2.name.equals(power6))
        assert(!card3.power.equals(name3))
        assert(!card4.power.equals(description2))
        assert(!card5.description.equals(description1))
        assert(!card6.name.equals(power4))
        assert(!card7.power.equals(description3))
        assert(!card8.description.equals(power2))
    }

    test("Player") {
        assert(!card1.equals(new Player("Simba", new BoardSection(), 2, List[Card](), List[Card]())))
        assert(!card2.equals(new Player("Kitty", new BoardSection(), 2, List[Card](), List[Card]())))
    }

}
