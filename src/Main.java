import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        bibliothek.addBuch(new Buch("Clean Code", "Robert Martin", 45, 464));
        bibliothek.addBuch(new Buch("1984", "George Orwell", 18, 328));
        bibliothek.addBuch(new Buch("Animal Farm", "George Orwell", 12, 112));
        bibliothek.addBuch(new Buch("Java Basics", "Max Müller", 35, 520));
        bibliothek.addBuch(new Buch("The Hobbit", "J. R. R. Tolkien", 28, 310));

        System.out.println("--- 1. Bücher eines Autors (George Orwell) ---");
        List<Buch> orwellBuecher = bibliothek.getBuecherVonAutor("George Orwell");
        for (Buch b : orwellBuecher) {
            System.out.println(b.getTitel());
        }

        System.out.println("\n--- 2. Durchschnittliche Seitenanzahl ---");
        System.out.printf("%.2f%n", bibliothek.getDurchschnittlicheSeitenanzahl());

        System.out.println("\n--- 3. Bücher innerhalb eines Preislimits (30 Euro) ---");
        List<Buch> limitBuecher = bibliothek.getBuecherUnterPreislimit(30);
        for (Buch b : limitBuecher) {
            System.out.println(b.getTitel() + " -> " + b.getPreis() + " Euro");
        }

        System.out.println("\n--- 4. Teuerstes Buch ---");
        Buch teuerstes = bibliothek.getTeuerstesBuch();
        if (teuerstes != null) {
            System.out.println(teuerstes.getTitel() + " (" + teuerstes.getPreis() + " Euro)");
        }

        System.out.println("\n--- 5. Bücher mit einer Mindestseitenanzahl (300 Seiten) ---");
        List<Buch> dickeBuecher = bibliothek.getBuecherMitMindestseiten(300);
        for (Buch b : dickeBuecher) {
            System.out.println(b.getTitel());
        }

        System.out.println("\n--- 6. Zwei Bücher innerhalb eines Budgets (55 Euro) ---");
        List<Buch> budgetBuecher = bibliothek.getZweiBuecherInnerhalbBudgets(55);
        if (budgetBuecher.size() == 2) {
            System.out.println(budgetBuecher.get(0).getTitel() + " + " + budgetBuecher.get(1).getTitel());
            System.out.println("Gesamtpreis: " + (budgetBuecher.get(0).getPreis() + budgetBuecher.get(1).getPreis()) + " Euro");
        } else {
            System.out.println("Keine passenden Bücher gefunden.");
        }
    }
}