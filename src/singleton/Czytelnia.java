package singleton;

import builder.*;
import dekoracja.BookIf;
import stol.Stol;
import stol.StolException;

/**
 * Czytelnia to klasa typu Singleton, skladajaca sie ze Stolu oraz Regalu.
 * @see Stol
 * @see Regal
 */
public final class Czytelnia {
    private static volatile Czytelnia instance = null;

    private Stol stol = new Stol(10);
    private Regal regal = null;

    public static Czytelnia getInstance() throws StolException {
        if (instance == null) {
            synchronized (Czytelnia.class) {
                if (instance == null) {
                    instance = new Czytelnia();
                }
            }
        }
        return instance;
    }

    /**
     * Buduje regal dla instancji czytelni.
     * @throws PolkaException gdy podczas budowania regalu, dodano polke o nieodpowiedniej pojemnosci stron.
     */
    public void zbudujRegal() throws PolkaException {
        RegalBuilder rb = new RegalBuilder();
        rb.add(new Polka(10000));
        rb.add(new Polka(10000));
        rb.add(new Polka(10000));
        regal = rb.toRegal();
    }

    /**
     * Zwraca string z lista ksiazek na danej polce.
     * @param index Indeks polki na regale.
     * @return String z ksiazkami.
     * @throws RegalException gdy nie istnieje polka o podanym indeksie.
     */
    public String getKsiazkiNaPolce(int index) throws RegalException {
        return regal.getPolka(index).toString();
    }

    /**
     * Odklad ksiazke z regalu na stol.
     * @param indexKsiazki indeks ksiazki na polce
     * @param indexPolki indeks polki w regale
     * @throws RegalException gdy podany indeks polki jest nieprawidlowy
     * @throws StolException gdy stol jest pelny
     * @throws PolkaException gdy podany indeks ksiazki jest nieprawidlowy
     */
    public void odlozKsiazkeNaStol( int indexKsiazki, int indexPolki) throws RegalException, StolException, PolkaException {
        BookIf b = regal.getPolka(indexPolki).wezKsiazke(indexKsiazki);
        stol.polozKsiazke(b);
    }

    /**
     * Przeklada pierwsza z wierzchu ksiazke ze stolu z powrotem na polke
     * @param indexPolki Indeks polki na ktora odlozyc ksiazke.
     * @throws RegalException gdy podany indeks polki jest nieprawidlowy
     * @throws PolkaException gdy polka jest pelna
     * @throws StolException gdy stol jest pusty
     */
    public void przelozKsiazkeZeStoluNaPolke(int indexPolki) throws RegalException, PolkaException, StolException {
        regal.getPolka(indexPolki).polozKsiazke(stol.wezKsiazke());
    }

    /**
     * Dodaje nowa ksiazke do podanej polki.
     * @param ksiazka nowa ksiazka
     * @param indexPolki indeks polki w regale
     * @throws RegalException gdy podany indeks polki jest nieprawidlowy
     * @throws PolkaException gdy polka jest pelna
     */
    public void dodajKsiazkeDoPolki(BookIf ksiazka, int indexPolki) throws RegalException, PolkaException {
        regal.getPolka(indexPolki).polozKsiazke(ksiazka);
    }

    private Czytelnia() throws StolException {

    }
}
