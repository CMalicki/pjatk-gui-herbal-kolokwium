import java.util.ArrayList;

public class Koszyk {
    private static ArrayList<Herbaty> koszyk = new ArrayList<>();

    public static Klient klient;

    public Koszyk(Klient klient) {
        this.klient = klient;
    }

    public void dodajDoKoszyka(Herbaty herbaty) {
        koszyk.add(herbaty);
    }

    public String toString() {
        if (Koszyk.zwrocKoszyk().isEmpty()) {
            return Klient.nazwaKlienta() + ": -- pusto";
        } else {
            String daneHerbat = "";
            for (Herbaty herbaty : koszyk) {
                daneHerbat = daneHerbat + herbaty;
            }
            return Klient.nazwaKlienta() + ": " + "\n" + daneHerbat;
        }
    }

    public static ArrayList<Herbaty> zwrocKoszyk() {
        return koszyk;
    }

    public static double wartoscKoszyka() {
        double wartoscKoszyka = 0;
        for (String[] key : Cennik.cennik.keySet()) {
            for (int i = 0; i < Koszyk.zwrocKoszyk().size(); i++) {
                for (String s : key) {
                    if (Koszyk.zwrocKoszyk().get(i).smak.equals(s)) {
                        if (Cennik.cennik.get(key)[0] == 0 || Cennik.cennik.get(key)[0] > Koszyk.zwrocKoszyk().get(i).kg) {
                            wartoscKoszyka = wartoscKoszyka + Koszyk.zwrocKoszyk().get(i).kg * Cennik.cennik.get(key)[1];
                        } else {
                            wartoscKoszyka = wartoscKoszyka + Koszyk.zwrocKoszyk().get(i).kg * Cennik.cennik.get(key)[2];
                        }
                    }
                }
            }
        }
        return wartoscKoszyka;
    }
}
