public class Buch {
    private String titel;
    private String autor;
    private double preis;
    private int anzahlSeiten;

    public Buch(String titel, String autor, double preis, int anzahlSeiten) {
        this.titel = titel;
        this.autor = autor;
        this.preis = preis;
        this.anzahlSeiten = anzahlSeiten;
    }

    public String getTitel() { return titel; }
    public String getAutor() { return autor; }
    public double getPreis() { return preis; }
    public int getAnzahlSeiten() { return anzahlSeiten; }

    @Override
    public String toString() {
        return titel + " (" + autor + "), " + preis + " Euro, " + anzahlSeiten + " Seiten";
    }
}