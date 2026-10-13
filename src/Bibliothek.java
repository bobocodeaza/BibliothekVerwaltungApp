import java.util.ArrayList;
import java.util.List;

public class Bibliothek {
    private List<Buch> buecher;
    public Bibliothek() {
        this.buecher = new ArrayList<>();
    }

    public void addBuch(Buch buch) {
        this.buecher.add(buch);
    }

    public List<Buch> getBuecherVonAutor(String autor) {
        List<Buch> ergebnis = new ArrayList<>();
        for (Buch b : this.buecher) {
            if (b.getAutor().equals(autor)) {
                ergebnis.add(b);
            }
        }
        return ergebnis;
    }

    public double getDurchschnittlicheSeitenanzahl() {
        if (this.buecher.isEmpty()) return 0;
        double summe = 0;
        for (Buch b : this.buecher) {
            summe += b.getAnzahlSeiten();
        }
        return summe / this.buecher.size();
    }

    public List<Buch> getBuecherUnterPreislimit(double maxPreis) {
        List<Buch> ergebnis = new ArrayList<>();
        for (Buch b : this.buecher) {
            if (b.getPreis() <= maxPreis) {
                ergebnis.add(b);
            }
        }
        return ergebnis;
    }

    public Buch getTeuerstesBuch() {
        if (this.buecher.isEmpty()) return null;
        Buch teuerstes = this.buecher.get(0);
        for (Buch b : this.buecher) {
            if (b.getPreis() > teuerstes.getPreis()) {
                teuerstes = b;
            }
        }
        return teuerstes;
    }
}