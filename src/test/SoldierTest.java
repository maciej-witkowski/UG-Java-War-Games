package test;

import main.General;
import main.Soldier;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SoldierTest {

    private Soldier soldier;

    @Before
    public void setUp() throws Exception {
        General general = new General("Jan", "Kowalski");
        soldier = new Soldier(2, general);
    }

    @Test
    public void testRank() {
        Assertions.assertEquals("Kapral", soldier.rank());
    }

    @Test
    public void testValue() {
        Assertions.assertEquals(2, soldier.value());
    }

    @Test
    public void testExperience() {
        Assertions.assertEquals(1, soldier.experience());
    }

    @Test
    public void testCombatPotential() {
        Assertions.assertEquals(2, soldier.combatPotential());
    }

    @Test
    public void testStatus() {
        Assertions.assertEquals(true, soldier.status());
    }

    @Test
    public void testDieStatus() {
        soldier.die("battle");
        Assertions.assertEquals(false, soldier.status());
    }

    @Test
    public void testPromotionRank() {
        soldier.promotion();
        Assertions.assertEquals("Kapitan", soldier.rank());
    }

    @Test
    public void testPromotionValue() {
        soldier.promotion();
        Assertions.assertEquals(3, soldier.value());
    }

    @Test
    public void testPromotionCombatPotential() {
        soldier.promotion();
        Assertions.assertEquals(3, soldier.combatPotential());
    }

    @Test
    public void testIncreaseExpExperience() {
        soldier.increaseExp();
        Assertions.assertEquals(2, soldier.experience());
    }

    @Test
    public void testIncreaseExpCombatPotential() {
        soldier.increaseExp();
        Assertions.assertEquals(4, soldier.combatPotential());
    }

    @Test
    public void testIncreaseExpPromotion() {
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        soldier.increaseExp();
        Assertions.assertEquals("Kapitan", soldier.rank());
    }

    @Test
    public void testReduceExpExperience() {
        soldier.reduceExp();
        Assertions.assertEquals(0, soldier.experience());
    }

    @Test
    public void testReduceExpCombatPotential() {
        soldier.reduceExp();
        Assertions.assertEquals(0, soldier.combatPotential());
    }

    @Test
    public void testIncreaseExpDie() {
        soldier.increaseExp();
        soldier.reduceExp();
        soldier.reduceExp();
        Assertions.assertFalse(soldier.status());
    }
}
