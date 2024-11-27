import java.util.Date;

public class Location {
    private final int id;
    private Date dateLocation;
    private Date DateExpedition;
    private Date DateRetour;
    private Client idClient;
    private Films idFilm;

    Location(int id, Date dateLocation, Date DateExpedition, Date DateRetour, Client idClient, Films idFilm) {
        this.id = id;
        this.dateLocation = dateLocation;
        this.DateExpedition = DateExpedition;
        this.DateRetour = DateRetour;
        this.idClient = idClient;
        this.idFilm = idFilm;
    }

    public int getId() {
        return id;
    }

    public Date getDateLocation() {
        return dateLocation;
    }

    public Date getDateExpedition() {
        return DateExpedition;
    }

    public Date getDateRetour() {
        return DateRetour;
    }

    public Client getIdClient() {
        return idClient;
    }

    public Films getIdFilm() {
        return idFilm;
    }

    public void setDateLocation(Date dateLocation) {
        this.dateLocation = dateLocation;
    }

    public void setDateExpedition(Date DateExpedition) {
        this.DateExpedition = DateExpedition;
    }

    public void setDateRetour(Date DateRetour) {
        this.DateRetour = DateRetour;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public void setIdFilm(Films idFilm) {
        this.idFilm = idFilm;
    }
}
