package test;

import main.Rank;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RankTest {

    private Rank rank;

    @Before
    public void setUp() throws Exception {
        rank = new Rank(2);
    }

    @Test
    public void testRank() {
        Assertions.assertEquals("Kapral", rank.rank());
    }

    @Test
    public void testValue() {
        Assertions.assertEquals(2, rank.value());
    }

    @Test
    public void testUpdateRank() {
        rank.update();
        Assertions.assertEquals("Kapitan", rank.rank());
    }

    @Test
    public void testUpdateValue() {
        rank.update();
        Assertions.assertEquals(3, rank.value());
    }

    @Test
    public void testUpdateMaxRank() {
        rank.update();
        rank.update();
        Assertions.assertEquals("Major", rank.rank());
        rank.update();
        Assertions.assertEquals("Major", rank.rank());
    }

    @Test
    public void testUpdateMaxValue() {
        rank.update();
        rank.update();
        Assertions.assertEquals(4, rank.value());
        rank.update();
        Assertions.assertEquals(4, rank.value());
    }
}
