public class Client {
    private final String login;
    private String password;
    private String nom;
    private String prenom;
    private String addresse;

    Client(String login, String password, String nom, String prenom, String addresse) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.addresse = addresse;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
}
