package builder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegalBuilderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void toRegal() throws RegalException, PolkaException {
        RegalBuilder rb = new RegalBuilder();
        rb.add(new Polka(10000));
        rb.add(new Polka(5000));
        Regal r = rb.toRegal();
        assertNotEquals(r.getPolka(0), null);
        assertNotEquals(r.getPolka(1), null);
        assertEquals(r.getPolka(0).getMaksymalnaIloscStron(), 10000);
        assertEquals(r.getPolka(1).getMaksymalnaIloscStron(), 5000);
    }
}