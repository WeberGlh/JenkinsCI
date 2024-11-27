import java.util.ArrayList;
import java.util.Objects;

public class SearchClientById {
    private final ArrayList<Client> liste;

    public SearchClientById(ArrayList<Client> liste) {
        this.liste = liste;
    }

    public Client searchById(String id) {
        for (Client o : liste) {
            if (Objects.equals(o.getLogin(), id)) {
                return o;
            }
        }
        return null;
    }
}
