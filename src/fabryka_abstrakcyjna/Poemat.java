package fabryka_abstrakcyjna;

import dekoracja.Book;

/**
 * Poemat jest to ksiazka w gatunku poematu.
 */
public class Poemat extends Book {
    public Poemat(String author, String title, int pageCount) {
        super(author, title, pageCount);
    }
}
