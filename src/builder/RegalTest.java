package builder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegalTest {

    protected Regal regal = null;

    @BeforeEach
    void setUp() throws PolkaException {
        ArrayList<Polka> polki = new ArrayList<>();
        polki.add(new Polka(10000));
        polki.add(new Polka(5000));
        regal = new Regal(polki);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPolka() throws RegalException {
        assertNotEquals(regal.getPolka(0), null);
        assertNotEquals(regal.getPolka(1), null);
        assertEquals(regal.getPolka(0).getMaksymalnaIloscStron(), 10000);
        assertEquals(regal.getPolka(1).getMaksymalnaIloscStron(), 5000);
    }
}