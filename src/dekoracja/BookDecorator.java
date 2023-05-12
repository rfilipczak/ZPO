package dekoracja;

/**
 * Klasa bazowa dla dekoratorow ksiazek.
 */
abstract class BookDecorator implements BookIf {
    protected BookIf decoratedBook;

    public BookDecorator(BookIf book) {
        this.decoratedBook = book;
    }
}
