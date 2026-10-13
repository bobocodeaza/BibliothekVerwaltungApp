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

    public List<Buch> getBuecherMitMindestseiten(int mindestseiten) {
        List<Buch> ergebnis = new ArrayList<>();
        for (Buch b : this.buecher) {
            if (b.getAnzahlSeiten() >= mindestseiten) {
                ergebnis.add(b);
            }
        }
        return ergebnis;
    }

    public List<Buch> getZweiBuecherInnerhalbBudgets(double budget) {
        Buch bestBuch1 = null;
        Buch bestBuch2 = null;
        double maxPreisGefunden = -1;
        int maxSeitenGefunden = -1;

        for (int i = 0; i < this.buecher.size() - 1; i++) {
            for (int j = i + 1; j < this.buecher.size(); j++) {
                Buch b1 = this.buecher.get(i);
                Buch b2 = this.buecher.get(j);
                double summePreis = b1.getPreis() + b2.getPreis();

                if (summePreis <= budget) {
                    if (summePreis > maxPreisGefunden) {
                        maxPreisGefunden = summePreis;
                        maxSeitenGefunden = b1.getAnzahlSeiten() + b2.getAnzahlSeiten();
                        bestBuch1 = b1;
                        bestBuch2 = b2;
                    }
                    else if (summePreis == maxPreisGefunden) {
                        int summeSeiten = b1.getAnzahlSeiten() + b2.getAnzahlSeiten();
                        if (summeSeiten > maxSeitenGefunden) {
                            maxSeitenGefunden = summeSeiten;
                            bestBuch1 = b1;
                            bestBuch2 = b2;
                        }
                    }
                }
            }
        }

        List<Buch> ergebnis = new ArrayList<>();
        if (bestBuch1 != null && bestBuch2 != null) {
            ergebnis.add(bestBuch1);
            ergebnis.add(bestBuch2);
        }
        return ergebnis;
    }
}