package builder;

import java.util.ArrayList;

/**
 * RegalBuilder to klasa budujaca regaly.
 */
public class RegalBuilder {
    private ArrayList<Polka> polki = new ArrayList<>();

    /**
     * Dodaje nowa polke do przyszlego regalu.
     * @param polka Nowa polka do budowanego regalu.
     */
    public void add(Polka polka) {
        polki.add(polka);
    }

    /**
     * Buduje regal.
     * @return Zbudowany regal.
     */
    public Regal toRegal() {
        return new Regal(polki);
    }
}
