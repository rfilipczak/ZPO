package builder;

import dekoracja.Book;
import dekoracja.BookIf;
import dekoracja.DecorativeCover;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolkaTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getMaksymalnaIloscStron() throws PolkaException {
        Polka p = new Polka(1000);
        assertEquals(p.getMaksymalnaIloscStron(), 1000);

        PolkaException thrown = Assertions.assertThrows(PolkaException.class,
                () -> {
                    Polka polka = new Polka(0);
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Polka musi miec jakas pojemnosc!");

        thrown = Assertions.assertThrows(PolkaException.class,
                () -> {
                    Polka polka = new Polka(-1000);
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Polka musi miec jakas pojemnosc!");
    }

    @Test
    void polozIWezKsiazke() throws PolkaException {
        Polka p = new Polka(6000);

        PolkaException thrown = Assertions.assertThrows(PolkaException.class,
                () -> {
                    p.wezKsiazke();
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Polka jest pusta!");

        p.polozKsiazke(new DecorativeCover(new Book("Juliusz Slowacki", "Kordian", 180)));
        p.polozKsiazke(new Book("Robin Cook", "Spiaczka", 300));

        BookIf b0 = p.wezKsiazke();
        assertNotEquals(b0, null);
        assertEquals(b0.getAuthor(), "Juliusz Slowacki");
        assertEquals(b0.getTitle(), "Kordian");
        assertEquals(b0.getPageCount(), 180);
        p.polozKsiazke(b0);

        thrown = Assertions.assertThrows(PolkaException.class,
                () -> {
                    p.wezKsiazke(3);
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Niedozwolony indeks ksiazki!");


        thrown = Assertions.assertThrows(PolkaException.class,
                () -> {
                    for(int i = 0; i < 6; i++)
                    {
                        Book k = new Book("Henryk Sienkiewicz", "Potop", 1200);
                        p.polozKsiazke(k);
                    }
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Polka jest pelna!");
    }

    @Test
    void testToString() throws PolkaException {
        Polka p = new Polka(6000);
        p.polozKsiazke(new DecorativeCover(new Book("Juliusz Slowacki", "Kordian", 180)));
        p.polozKsiazke(new Book("Robin Cook", "Spiaczka", 300));
        for(int i = 0; i < 4; i++)
        {
            Book k = new Book("Henryk Sienkiewicz", "Potop", 1200);
            p.polozKsiazke(k);
        }
        System.out.println(p);
    }
}