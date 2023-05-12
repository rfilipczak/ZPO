package stol;

import dekoracja.BookIf;

import java.util.Stack;

/**
 * Stol to klasa opisujaca stol w czytelni, na ktory mozna odkladac ksiazki.
 */
public class Stol {
    private Stack<BookIf> stos;
    private int capacity;

    public Stol(int size) throws StolException {
        if (size <= 0) {
            throw new StolException("Niewlasciwy rozmiar stosu");
        }
        this.capacity = size;
        stos = new Stack<>();
    }

    /**
     * Odklada ksiazke na stol.
     * @param book Ksiazka do odlozenia
     * @throws StolException gdy stol jest pelny
     */
    public void polozKsiazke(BookIf book) throws StolException {
        if (stos.size() == capacity) {
            throw new StolException("Stol pelny");
        }
        stos.push(book);
    }

    /**
     * Zabiera ksiazke ze stolu
     * @return Zebrana ksiazka.
     * @throws StolException gdy stol jest pusty
     */
    public BookIf wezKsiazke() throws StolException {
        if (stos.empty()) {
            throw new StolException("Stol pusty");
        }
        return stos.pop();
    }

    /**
     * @return Ilosc ksiazek na stole.
     */
    int size() {
        return stos.size();
    }

    /**
     * Sprawdza co lezy na wierzchu stolu.
     * @return Ksiazka
     */
    public BookIf peek() {
        return stos.peek();
    }


}
