import java.util.HashMap;
import java.util.Map;

public class Cennik {
    private static Cennik instance = new Cennik();
    public static Map<String[], Double[]> cennik;

    public static Cennik pobierzCennik() {
        return instance;
    }

    private Cennik() {
        cennik = new HashMap<>();
    }

    public void dodaj(String nazwa, String smak, double cena) {
        cennik.put(new String[]{nazwa, smak}, new Double[]{0.0, cena, cena});
    }

    public void dodaj(String nazwa, String smak, double kgBariera, double cena1, double cena2) {
        cennik.put(new String[]{nazwa, smak}, new Double[]{kgBariera, cena1, cena2});
    }
}
