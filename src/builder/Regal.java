package builder;

import java.util.ArrayList;

/**
 * Regal sklada sie z polek na ktorych przechowywane sa ksiazki.
 */
public class Regal {
    private ArrayList<Polka> polki;

    public Regal(ArrayList<Polka> polki) {
        this.polki = polki;
    }

    /**
     * Pobierz polke.
     * @param index Indeks polki.
     * @return Polka w regale.
     * @throws RegalException gdy regal nie ma polki o podanym indeksie.
     */
    public Polka getPolka(int index) throws RegalException {
        Polka p = null;
        try {
            p = polki.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new RegalException("Nie ma polki o podanym indeksie: " + index);
        }
        return p;
    }
}
