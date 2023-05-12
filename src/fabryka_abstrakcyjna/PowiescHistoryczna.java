package fabryka_abstrakcyjna;

import dekoracja.Book;

/**
 * PowiescHistoryczna jest to ksiazka z gatunku powiesci historycznej.
 */
public class PowiescHistoryczna extends Book {
    public PowiescHistoryczna(String author, String title, int pageCount) {
        super(author, title, pageCount);
    }
}
