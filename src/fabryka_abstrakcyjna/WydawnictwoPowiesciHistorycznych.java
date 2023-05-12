package fabryka_abstrakcyjna;

import dekoracja.BookIf;

/**
 * Wydanictwo ksiazek gatunku powiesci historycznej.
 */
public class WydawnictwoPowiesciHistorycznych extends Wydawnictwo {
    public WydawnictwoPowiesciHistorycznych(String author) {
        this.author = author;
    }

    @Override
    public BookIf createBook(String title, int pageCount) {
        return new PowiescHistoryczna(author, title, pageCount);
    }
}
