public class Main {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        bibliothek.addBuch(new Buch("Clean Code", "Robert Martin", 45, 464));
        bibliothek.addBuch(new Buch("1984", "George Orwell", 18, 328));
        bibliothek.addBuch(new Buch("Animal Farm", "George Orwell", 12, 112));
        bibliothek.addBuch(new Buch("Java Basics", "Max Müller", 35, 520));
        bibliothek.addBuch(new Buch("The Hobbit", "J. R. R. Tolkien", 28, 310));

    }
}