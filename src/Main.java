import dekoracja.*;
import fabryka_abstrakcyjna.Wydawnictwo;
import fabryka_abstrakcyjna.WydawnictwoException;
import stol.Stol;
import stol.StolException;

/**
 * Glowna klasa programu
 * @author Rafal Filipczak
 * @version 1.0
 * @since JDK 17
 * @see <a href=https://pl.wikibooks.org/wiki/Kody_%C5%BAr%C3%B3d%C5%82owe/Dekorator_(wzorzec_projektowy)>Wikipedia</a>
 */
public class Main {
    /**
     * Glowna funckja programu
     * @param args parametry wywolania programu, nie uzywane
     */
    public static void main(String[] args) {
        BookIf book = new Book("Adam Mickiewicz", "Pan Tadeusz", 830);
        BookIf normalCover = new NormalCover(book);
        BookIf solidCover = new SolidCover(normalCover);
        BookIf decorativeCover = new DecorativeCover(solidCover);

        System.out.println(book);
        System.out.println(normalCover);
        System.out.println(solidCover);
        System.out.println(decorativeCover);

        System.out.println("");

        book.setPageCount(1200);
        System.out.println(book);
        System.out.println(normalCover);
        System.out.println(solidCover);
        System.out.println(decorativeCover);

        System.out.println("");

        solidCover.setAuthor("A.M.");
        System.out.println(book);
        System.out.println(normalCover);
        System.out.println(solidCover);
        System.out.println(decorativeCover);

        System.out.println("");

        try {
            Wydawnictwo w = Wydawnictwo.getWydawnictwo("Adam Mickiewicz");
            BookIf poemat = w.createBook("Dziady", 130);
            System.out.println(poemat);

            w = Wydawnictwo.getWydawnictwo("Henryk Sienkiewicz");
            BookIf powiescHistoryczna = w.createBook("Potop", 1000);
            System.out.println(powiescHistoryczna);

            w = Wydawnictwo.getWydawnictwo("Robin Cook");
            BookIf thrillerMedyczny = w.createBook("Cialo Obce", 300);
            System.out.println(thrillerMedyczny);

            w = Wydawnictwo.getWydawnictwo("Nieznany autor");
        } catch (WydawnictwoException e) {
            System.out.println(e.getMessage());
        }

        try {
            Stol stol = new Stol(5);
            stol.polozKsiazke(new Book("Adam Mickiewicz", "Pan Tadeusz", 1000));
            System.out.println(stol);
            System.out.println(stol.wezKsiazke());
        } catch (StolException e) {
            System.out.println(e.getMessage());
        }

    }
}
