package fabryka_abstrakcyjna;

import dekoracja.BookIf;

import java.util.Objects;

/**
 * Wydawnictwo to Fabryka Abstrakcyjna wydawnictw.
 */
public abstract class Wydawnictwo {
    protected String author;

    /**
     * Zwraca konkretne wydanictwo na podstawie autora.
     * @param author Imie i nazwisko autora.
     * @return Konkretne wydawnictwo odpowiedniego gatunku literackiego.
     * @throws WydawnictwoException gdy nie ma wydawnictwa dla podanego autora.
     */
    public static Wydawnictwo getWydawnictwo(String author) throws WydawnictwoException {
        if (Objects.equals(author, "Adam Mickiewicz")) {
            return new WydawnictwoPoematow(author);
        } else if (Objects.equals(author, "Henryk Sienkiewicz")) {
            return new WydawnictwoPowiesciHistorycznych(author);
        } else if (Objects.equals(author, "Robin Cook")) {
            return new WydawnictwoThrillerowMedycznych(author);
        }
        throw new WydawnictwoException("Nie ma wydawnictw z takim autorem: " + author);
    }

    public abstract BookIf createBook(String title, int pageCount);
}
