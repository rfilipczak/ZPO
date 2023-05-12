package dekoracja;

/**
 * Dekorator dla ksiazek dodajcy zwykla okladke.
 */
public class NormalCover extends BookDecorator {
    public NormalCover(BookIf book) {
        super(book);
    }

    @Override
    public String toString() {
        return "( " + decoratedBook.toString() + " )";
    }

    @Override
    public String getAuthor() {
        return decoratedBook.getAuthor();
    }

    @Override
    public void setAuthor(String author) {
        decoratedBook.setAuthor(author);
    }

    @Override
    public String getTitle() {
        return decoratedBook.getTitle();
    }

    @Override
    public void setTitle(String title) {
        decoratedBook.setTitle(title);
    }

    @Override
    public int getPageCount() {
        return decoratedBook.getPageCount();
    }

    @Override
    public void setPageCount(int pageCount) {
        decoratedBook.setPageCount(pageCount);
    }
}
