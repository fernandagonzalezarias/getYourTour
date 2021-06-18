/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class TourFavUser {
    private User user;
    private Tour tour;
    private String state;

    public TourFavUser(User user, Tour tour, String state) {
        this.user = user;
        this.tour = tour;
        this.state = state;
    }

    public TourFavUser() {
        this(null, null, null);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TourFavUser{" + "user=" + user + ", tour=" + tour + ", state=" + state + '}';
    }
    
}
