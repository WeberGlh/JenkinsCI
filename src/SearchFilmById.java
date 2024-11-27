import java.util.ArrayList;
import java.util.Objects;

public class SearchFilmById {
    private final ArrayList<Films> liste;

    public SearchFilmById(ArrayList<Films> liste) {
        this.liste = liste;
    }

    public Films searchById(int id) {
        for (Films o : liste) {
            if (o.getId() == id) {
                return o;
            }
        }
        return null;
    }
}
