package stol;

import dekoracja.Book;
import dekoracja.BookIf;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class StolTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void polozKsiazke() throws StolException {
        Stol stol = new Stol(10);
        Book panTadeusz = new Book("Adam Mickiewicz", "Pan Tadeusz", 1000);
        stol.polozKsiazke(panTadeusz);
        assertEquals(stol.peek(), panTadeusz);
    }

    @org.junit.jupiter.api.Test
    void polozKsiazkeException() throws StolException {
        Stol stol = new Stol(1);
        StolException thrown = Assertions.assertThrows(StolException.class,
                () -> {
                    BookIf b1 = new Book("1", "2", 3);
                    BookIf b2 = new Book("4", "5", 6);
                    stol.polozKsiazke(b1);
                    stol.polozKsiazke(b2);
                }
        );
        Assertions.assertEquals(thrown.getMessage(), "Stol pelny");
    }

    @org.junit.jupiter.api.Test
    void wezKsiazke() throws StolException {
        Stol stol = new Stol(10);
        Book panTadeusz = new Book("Adam Mickiewicz", "Pan Tadeusz", 1000);
        stol.polozKsiazke(panTadeusz);

        BookIf b = stol.wezKsiazke();
        assertEquals(b, panTadeusz);

        StolException thrown = Assertions.assertThrows(StolException.class,
                stol::wezKsiazke
        );
        Assertions.assertEquals(thrown.getMessage(), "Stol pusty");
    }

    @org.junit.jupiter.api.Test
    void size() throws StolException {
        Stol stol = new Stol(10);
        assertEquals(stol.size(), 0);

        Book panTadeusz = new Book("Adam Mickiewicz", "Pan Tadeusz", 1000);
        stol.polozKsiazke(panTadeusz);
        assertEquals(stol.size(), 1);

        for (int i = 0; i < 9; ++i) {
            stol.polozKsiazke(panTadeusz);
        }
        assertEquals(stol.size(), 10);
    }

    @org.junit.jupiter.api.Test
    void peek() throws StolException {
        Stol stol = new Stol(10);
        Book panTadeusz = new Book("Adam Mickiewicz", "Pan Tadeusz", 1000);
        stol.polozKsiazke(panTadeusz);
        assertEquals(stol.size(), 1);
        assertEquals(stol.peek(), panTadeusz);
        assertEquals(stol.size(), 1);
    }
}