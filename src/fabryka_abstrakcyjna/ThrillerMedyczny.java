package fabryka_abstrakcyjna;

import dekoracja.Book;

/**
 * ThrillerMedyczny jest to ksiazka z gatunku thrillera medycznego.
 */
public class ThrillerMedyczny extends Book {
    public ThrillerMedyczny(String author, String title, int pageCount) {
        super(author, title, pageCount);
    }
}
