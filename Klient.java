import java.util.ArrayList;
import java.util.Arrays;

public class Klient {
    static String nazwa;
    double pieniadzeKlienta;

    private static ArrayList<Herbaty> listaZakupow = new ArrayList<>();

    public Klient(String nazwa, double pieniadzeKlienta) {
        this.nazwa = nazwa;
        this.pieniadzeKlienta = pieniadzeKlienta;
        listaZakupow = new ArrayList<>();
    }

    public static String nazwaKlienta() {
        return nazwa;
    }

    public void dodaj(Herbaty herbata) {
        listaZakupow.add(herbata);
    }

    public ListaZakupow pobierzListeZakupow() {
        return new ListaZakupow(listaZakupow);
    }

    public static Koszyk pobierzKoszyk() {
        return new Koszyk(Koszyk.klient);
    }


    public void przepakuj(Koszyk koszyk) {
        ArrayList<Herbaty> listaDoUsuniecia = new ArrayList<>();
        String[] listaPorownawcza = new String[2];
        for (Herbaty herbata : listaZakupow) {
            listaPorownawcza[0] = herbata.nazwa();
            listaPorownawcza[1] = herbata.smak;
            for (String[] key : Cennik.cennik.keySet()) {
                if (Arrays.equals(listaPorownawcza, key)) {
                    koszyk.dodajDoKoszyka(herbata);
                    listaDoUsuniecia.add(herbata);
                }
            }
        }
        listaZakupow.removeAll(listaDoUsuniecia);
    }

    public double pobierzPortfel() {
        return pieniadzeKlienta;
    }

    public void zaplac(boolean czyKarta) {
        double cenaNajtanszej = Koszyk.zwrocKoszyk().get(0).zwrocCene();
        for (int i = 0; i < Koszyk.zwrocKoszyk().size(); i++) {
            if (Koszyk.zwrocKoszyk().get(i).zwrocCene() < cenaNajtanszej) {
                cenaNajtanszej = Koszyk.zwrocKoszyk().get(i).zwrocCene();
            }
        }
        double poczatkowaWartoscKoszyka = Koszyk.wartoscKoszyka();

        if (!czyKarta) {
            if (pieniadzeKlienta - Koszyk.wartoscKoszyka() <= 0) {
                Koszyk.zwrocKoszyk().remove(Koszyk.zwrocKoszyk().size() - 1);
            } else {
                while (Koszyk.wartoscKoszyka() > cenaNajtanszej) {
                    usunZbedneZKoszyka();
                }
            }
            pieniadzeKlienta = pieniadzeKlienta - (poczatkowaWartoscKoszyka - Koszyk.wartoscKoszyka());
        } else {
            while (Koszyk.wartoscKoszyka() > (cenaNajtanszej * 1.025)) {
                usunZbedneZKoszyka();
            }
            pieniadzeKlienta = pieniadzeKlienta - (poczatkowaWartoscKoszyka - Koszyk.wartoscKoszyka()) * 1.025;
        }
    }

    private void usunZbedneZKoszyka() {
        int indexNajdrozszej = 0;
        double cenaNajdrozszej = Koszyk.zwrocKoszyk().get(0).zwrocCene();
        for (int i = 0; i < Koszyk.zwrocKoszyk().size(); i++) {
            if (Koszyk.zwrocKoszyk().get(i).zwrocCene() > cenaNajdrozszej) {
                cenaNajdrozszej = Koszyk.zwrocKoszyk().get(i).zwrocCene();
                indexNajdrozszej = i;
            }
        }
        if (Koszyk.zwrocKoszyk().get(indexNajdrozszej).kg > 0) {
            Koszyk.zwrocKoszyk().get(indexNajdrozszej).kg = Koszyk.zwrocKoszyk().get(indexNajdrozszej).kg - 1;
        }
        if (Koszyk.zwrocKoszyk().get(indexNajdrozszej).kg == 0) {
            Koszyk.zwrocKoszyk().remove(indexNajdrozszej);
        }
    }
}
