import java.util.ArrayList;

public class ListaZakupow {
    private ArrayList<Herbaty> listaZakupow;

    public ListaZakupow(ArrayList<Herbaty> listaZakupow) {
        this.listaZakupow = listaZakupow;
    }

    public String toString() {
        if (listaZakupow.isEmpty()) {
            return Klient.nazwaKlienta() + ": -- pusto";
        } else {
            String daneHerbat = "";
            for (Herbaty herbaty : listaZakupow) {
                daneHerbat = daneHerbat + herbaty;
            }
            return Klient.nazwaKlienta() + ": " + "\n" + daneHerbat;
        }
    }
}
