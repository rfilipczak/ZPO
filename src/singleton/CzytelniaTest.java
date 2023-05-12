package singleton;

import builder.PolkaException;
import builder.RegalException;
import dekoracja.Book;
import dekoracja.BookIf;
import fabryka_abstrakcyjna.Wydawnictwo;
import fabryka_abstrakcyjna.WydawnictwoException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stol.StolException;

import static org.junit.jupiter.api.Assertions.*;

class CzytelniaTest {

    Czytelnia czytelnia = null;

    @BeforeEach
    void setUp() throws StolException, PolkaException {
        czytelnia = Czytelnia.getInstance();
        czytelnia.zbudujRegal();
    }

    @AfterEach
    void tearDown() {
        czytelnia = null;
    }

    @Test
    void getInstance() {
        assertNotEquals(czytelnia, null);
    }

    @Test
    void getKsiazkiNaPolce() throws RegalException, PolkaException {
        System.out.println(czytelnia.getKsiazkiNaPolce(0));
        czytelnia.dodajKsiazkeDoPolki(new Book("Foo", "Bar", 1000), 1);
        czytelnia.dodajKsiazkeDoPolki(new Book("Foo", "Bar", 1000), 1);
        czytelnia.dodajKsiazkeDoPolki(new Book("Foo", "Bar", 1000), 1);
        czytelnia.dodajKsiazkeDoPolki(new Book("Foo", "Bar", 1000), 1);
        czytelnia.dodajKsiazkeDoPolki(new Book("Foo", "Bar", 1000), 1);
        System.out.println(czytelnia.getKsiazkiNaPolce(1));
    }

    @Test
    void odlozKsiazkeNaStol() throws PolkaException, RegalException, StolException {
        czytelnia.dodajKsiazkeDoPolki(new Book("Foo", "Bar", 1000), 0);

        czytelnia.odlozKsiazkeNaStol(0, 0);

        Exception thrown = Assertions.assertThrows(PolkaException.class,
                () -> {
                    czytelnia.odlozKsiazkeNaStol(10, 2);
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Polka jest pusta!");
    }

    @Test
    void przelozKsiazkeZeStoluNaPolke() throws PolkaException, RegalException, StolException {
        BookIf b = new Book("Foo", "Bar", 1000);
        czytelnia.dodajKsiazkeDoPolki(b, 0);
        System.out.println("Przed odlozeniem na stol:\n" + czytelnia.getKsiazkiNaPolce(0));
        czytelnia.odlozKsiazkeNaStol(0, 0);
        System.out.println("Po odlozeniu na stol:\n" + czytelnia.getKsiazkiNaPolce(0));
        czytelnia.przelozKsiazkeZeStoluNaPolke(0);
        System.out.println("Po odlozeniu z powrotem na polke:\n" + czytelnia.getKsiazkiNaPolce(0));
    }

    @Test
    void dodajKsiazkeDoPolki() throws PolkaException, RegalException {
        BookIf b = new Book("Foo", "Bar", 1000);
        czytelnia.dodajKsiazkeDoPolki(b, 0);
    }
}