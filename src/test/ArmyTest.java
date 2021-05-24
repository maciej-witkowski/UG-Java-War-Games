package test;

import main.Army;
import main.General;
import main.Soldier;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArmyTest {

    private General general0;
    private Army army0;

    @Before
    public void setUp() throws Exception {
        general0 = new General("Jan", "Kowalski");
        army0 = new Army(
                new Soldier(1, general0),
                new Soldier(2, general0),
                new Soldier(3, general0),
                new Soldier(4, general0)
        );
    }

    @Test
    public void testArmyStrength() {
        Assertions.assertEquals(10, army0.armyStrength());
    }

    @Test
    public void testSumRanks() {
        Assertions.assertEquals(10, army0.sumRanks());
    }

    @Test
    public void testAssignSoldier() throws Exception {
        army0.assignSoldier(new Soldier(1, general0));
        Assertions.assertEquals(5, army0.army().length);
    }

    @Test
    public void testDismissSoldier() {
        army0.dismissSoldier(army0.army()[0].id());
        Assertions.assertEquals(3, army0.army().length);
    }

    @Test
    public void testManeuversAllArmy() {
        army0.maneuvers();
        Assertions.assertEquals(20, army0.armyStrength());
    }

    @Test
    public void testManeuversPartOfArmy() {
        army0.maneuvers(new String[] {army0.army()[0].id(), army0.army()[1].id()});
        Assertions.assertEquals(13, army0.armyStrength());
    }

    @Test
    public void testMaintenance() {
        army0.army()[0].reduceExp();
        army0.maintenance();
        Assertions.assertEquals(3, army0.army().length);
    }

    @Test
    public void testSpoilsOfWar() {
        army0.spoilsOfWar();
        Assertions.assertEquals(20, army0.armyStrength());
    }

    @Test
    public void testWarReparations() {
        army0.warReparations();
        Assertions.assertEquals(0, army0.armyStrength());
    }

    @Test
    public void testWarAttrition() {
        army0.warAttrition();
        army0.maintenance();
        Assertions.assertEquals(3, army0.army().length);
    }

}
