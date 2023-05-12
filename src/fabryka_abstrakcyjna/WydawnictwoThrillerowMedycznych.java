package fabryka_abstrakcyjna;

import dekoracja.BookIf;

/**
 * Wydawnictwo ksiazek gatunku thrillera medycznego.
 */
public class WydawnictwoThrillerowMedycznych extends Wydawnictwo {
    public WydawnictwoThrillerowMedycznych(String author) {
        this.author = author;
    }

    @Override
    public BookIf createBook(String title, int pageCount) {
        return new ThrillerMedyczny(author, title, pageCount);
    }
}
