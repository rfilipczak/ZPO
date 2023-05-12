package fabryka_abstrakcyjna;

import dekoracja.BookIf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WydawnictwoTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getWydawnictwo() throws WydawnictwoException {
        Wydawnictwo w = Wydawnictwo.getWydawnictwo("Adam Mickiewicz");
        w = Wydawnictwo.getWydawnictwo("Henryk Sienkiewicz");
        w = Wydawnictwo.getWydawnictwo("Robin Cook");

        WydawnictwoException thrown = Assertions.assertThrows(WydawnictwoException.class,
                () -> {
                    Wydawnictwo.getWydawnictwo("Nieznany autor");
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Nie ma wydawnictw z takim autorem: Nieznany autor");
    }

    @Test
    void createBook() throws WydawnictwoException {
        Wydawnictwo w = Wydawnictwo.getWydawnictwo("Adam Mickiewicz");
        BookIf poemat = w.createBook("Dziady", 130);
        assertEquals(poemat.getAuthor(), "Adam Mickiewicz");

        w = Wydawnictwo.getWydawnictwo("Henryk Sienkiewicz");
        BookIf powiescHistoryczna = w.createBook("Potop", 1000);
        assertEquals(powiescHistoryczna.getAuthor(), "Henryk Sienkiewicz");

        w = Wydawnictwo.getWydawnictwo("Robin Cook");
        BookIf thrillerMedyczny = w.createBook("Cialo Obce", 300);
        assertEquals(thrillerMedyczny.getAuthor(), "Robin Cook");
    }
}