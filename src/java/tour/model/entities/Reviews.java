/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class Reviews {
    private int id;
    private Tour tour;
    private User user;
    private float grade;
    private String comments;

    public Reviews(int id, Tour tour, User user, float grade, String comments) {
        this.id = id;
        this.tour = tour;
        this.user = user;
        this.grade = grade;
        this.comments = comments;
    }

    public Reviews() {
        this(0, null, null, 0.0f, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Reviews{" + "id=" + id + ", tour=" + tour + ", user=" + user + ", grade=" + grade + ", comments=" + comments + '}';
    }
    
}
