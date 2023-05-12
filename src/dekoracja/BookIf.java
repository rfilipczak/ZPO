package dekoracja;

/**
 * Interfejs ksiazki.
 */
public interface BookIf {

    public String toString();

    String getAuthor();

    void setAuthor(String author);

    String getTitle();

    void setTitle(String title);

    int getPageCount();

    void setPageCount(int pageCount);
}
