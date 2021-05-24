package test;

import main.Attache;
import main.General;
import main.RecruitReport;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class GeneralTest {

    private General general0;
    private General general1;

    @Before
    public void setUp() {
        general0 = new General("Jan", "Kowalski");
        general1 = new General("Adam", "Kret");
    }

    @Test
    public void testAttach() {
        general0.attach(new Attache("Test", "Testowy", new General[] {general0}));
        Assertions.assertEquals(1, general0.secretaries().size());
    }

    @Test
    public void testDetach() {
        Attache toDelete = new Attache("Test", "Testowa", new General[] {general0});

        general0.attach(new Attache("Test", "Testowy", new General[] {general0}));
        general0.attach(toDelete);

        general0.detach(toDelete);

        Assertions.assertEquals(1, general0.secretaries().size());
    }

    @Test
    public void testNotifyObservers() {
        Attache attache = new Attache("Test", "Testowa", new General[] {general0});
        general0.attach(attache);
        general0.notifyObservers(new RecruitReport(general0, 2, 3, 60));

        Assertions.assertEquals(1, attache.log().size());
    }

    @Test
    public void testPersonalInfo() {
        Assertions.assertEquals("Jan Kowalski", general0.personalInfo());
    }

    @Test
    public void testBudget() {
        Assertions.assertEquals(200, general0.budget());
    }

    @Test
    public void testRecruitPrice() throws Exception {
        general0.recruit(4, 10);
        Assertions.assertEquals(200, general0.budget());
    }

    @Test
    public void testRecruitBudget() throws Exception {
        general0.recruit(4, 2);
        Assertions.assertEquals(120, general0.budget());
    }

    @Test
    public void testManeuversArmyAllPrice() throws Exception {
        general0.recruit(4, 4);
        general0.recruit(3, 1);
        general0.commandManeuvers();
        Assertions.assertEquals(10, general0.budget());
    }

    @Test
    public void testManeuversArmyAllBudget() throws Exception {
        general0.recruit(4, 4);
        general0.commandManeuvers();
        Assertions.assertEquals(24, general0.budget());
    }

    @Test
    public void testAttackWonBudget0() throws Exception {
        general0.recruit(4, 4);
        general1.recruit(4, 3);
        general0.attack(general1);
        Assertions.assertTrue(general0.budget() > 40);
    }

    @Test
    public void testAttackWonBudget1() throws Exception {
        general0.recruit(4, 4);
        general1.recruit(4, 3);
        general0.attack(general1);
        Assertions.assertTrue(general1.budget() < 80);
    }

    @Test
    public void testAttackLostBudget0() throws Exception {
        general0.recruit(4, 3);
        general1.recruit(4, 4);
        general0.attack(general1);
        Assertions.assertTrue(general0.budget() < 80);
    }

    @Test
    public void testAttackLostBudget1() throws Exception {
        general0.recruit(4, 3);
        general1.recruit(4, 4);
        general0.attack(general1);
        Assertions.assertTrue(general1.budget() > 40);
    }

    @Test
    public void testSave() {
        general0.save();
        File file = new File("./saves/save_");
        Assertions.assertTrue(file.exists());
    }

    @Test
    public void testLoad() {
        general1.load("save_");
        Assertions.assertEquals(general0.personalInfo(), general1.personalInfo());
    }
}
