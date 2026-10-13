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

}