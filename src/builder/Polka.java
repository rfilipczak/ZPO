package builder;

import dekoracja.BookIf;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Polka, na polce przechowywane sa Ksiazki, stanowi czesc Regalu.
 */
public class Polka {
    private int maksymalnaIloscStron;
    private ArrayList<BookIf> ksiazki = new ArrayList<>();
    private int catchedTotal = 0;

    public Polka(int maksymalnaIloscStron) throws PolkaException {
        if (maksymalnaIloscStron <= 0) {
            throw new PolkaException("Polka musi miec jakas pojemnosc!");
        }
        this.maksymalnaIloscStron = maksymalnaIloscStron;
    }


    /**
     * Zwraca maksymalna ilosc stron ksiazek przechowywanych na polce.
     * @return Maksymalna ilosc stron.
     */
    public int getMaksymalnaIloscStron() {
        return maksymalnaIloscStron;
    }

    /**
     * Zwraca pierwsza ksiazke po lewej na polce.
     * @return Pierwsza ksiazke po lewej na polce.
     * @throws PolkaException gdy polka jest pusta
     */
    public BookIf wezKsiazke() throws PolkaException {
        if (ksiazki.isEmpty()) {
            throw new PolkaException("Polka jest pusta!");
        }
        BookIf ksiazka = ksiazki.get(0);
        ksiazki.remove(0);
        catchedTotal -= ksiazka.getPageCount();
        return ksiazka;
    }

    /**
     * Zwraca ksiazke z podanym indeksem na polce.
     * @param index Indeks ksiazki na polce
     * @return Ksiazka z podanym indeksem na polce.
     * @throws PolkaException gdy polka jest pusta, albo podano niedozwolony indeks.
     */
    public BookIf wezKsiazke(int index) throws PolkaException {
        if (ksiazki.isEmpty()) {
            throw new PolkaException("Polka jest pusta!");
        }
        BookIf ksiazka = null;
        try {
            ksiazka = ksiazki.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new PolkaException("Niedozwolony indeks ksiazki!");
        }
        ksiazki.remove(index);
        catchedTotal -= ksiazka.getPageCount();
        return ksiazka;
    }

    /**
     * Odklada ksiazke na polke.
     * @param k Ksiazka do odlozenia na polke.
     * @throws PolkaException gdy polka jest pelna.
     */
    public void polozKsiazke(BookIf k) throws PolkaException {
        if (k.getPageCount() + catchedTotal > maksymalnaIloscStron) {
            throw new PolkaException("Polka jest pelna!");
        }
        catchedTotal += k.getPageCount();
        ksiazki.add(k);
    }

    /**
     * Buduje string, w ktorym zawarte sa ksiazki na polce.
     * @return String z ksiazkami na polce. Jedna pod druga, wraz z indeksem.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ksiazki.size(); ++i) {
            stringBuilder.append("[").append(i).append("] ").append(ksiazki.get(i)).append('\n');
        }
        return stringBuilder.toString();
    }
}
