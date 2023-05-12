package fabryka_abstrakcyjna;

import dekoracja.BookIf;

/**
 * Wydawnictwo ksiazek gatunku poematu.
 */
public class WydawnictwoPoematow extends Wydawnictwo {
    public WydawnictwoPoematow(String author) {
        this.author = author;
    }

    @Override
    public BookIf createBook(String title, int pageCount) {
        return new Poemat(author, title, pageCount);
    }
}
