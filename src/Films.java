public class Films {
    private final int id;
    private int year;
    private int length;
    private String title;
    private String subject;
    private String director;
    private int popularity;
    private int awards;

    Films(int id, int year, int length, String title, String subject, String director, int popularity, int awards) {
        this.id = id;
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.director = director;
        this.popularity = popularity;
        this.awards = awards;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getDirector() {
        return director;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getAwards() {
        return awards;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }
}
