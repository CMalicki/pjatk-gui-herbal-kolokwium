public abstract class Herbaty {
    String smak;
    int kg;

    public Herbaty(String smak, int kg) {
        this.smak = smak;
        this.kg = kg;
    }

    public abstract String nazwa();

    public double zwrocCene() {
        double cena = 0;
        for (String[] key : Cennik.cennik.keySet()) {
            if (nazwa().equals(key[0]) && smak.equals(key[1])) {
                if (kg > Cennik.cennik.get(key)[0]) {
                    return Cennik.cennik.get(key)[2];
                } else {
                    return Cennik.cennik.get(key)[1];
                }
            } else cena = -1;
        }
        return cena;
    }

    public String toString() {
        return nazwa() + ", smak: " + smak + ", " + "ilość " + kg + " kg, " + "cena " + zwrocCene() + "\n";
    }
}

class Czerwona extends Herbaty {
    public Czerwona(String smak, int kg) {
        super(smak, kg);
    }

    @Override
    public String nazwa() {
        return "czerwona";
    }
}

class Czarna extends Herbaty {
    public Czarna(String smak, int kg) {
        super(smak, kg);
    }

    @Override
    public String nazwa() {
        return "czarna";
    }
}

class Zielona extends Herbaty {
    public Zielona(String smak, int kg) {
        super(smak, kg);
    }

    @Override
    public String nazwa() {
        return "zielona";
    }
}

class Niebieska extends Herbaty {
    public Niebieska(String smak, int kg) {
        super(smak, kg);
    }

    @Override
    public String nazwa() {
        return "niebieska";
    }
}