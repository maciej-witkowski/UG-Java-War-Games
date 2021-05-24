package test;

import main.Attache;
import main.General;
import main.RecruitReport;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AttacheTest {

    private Attache attache;
    private General general;

    @Before
    public void setUp() {
        general = new General("Andrzej", "Nemsko");
        attache = new Attache("Jan", "Kowalski", new General[] {general});
    }

    @Test
    public void testUpdate() {
        attache.update(new RecruitReport(general, 2, 3, 60));
        Assertions.assertEquals(1, attache.log().size());
    }

    @Test
    public void testUpdateFromObservable() {
        general.attach(attache);
        general.sendRaport(new RecruitReport(general, 2, 3, 60));
        Assertions.assertEquals(1, attache.log().size());
    }
}
