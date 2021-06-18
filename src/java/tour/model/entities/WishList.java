/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class WishList {
     private User user;
    private Tour tour;
    private String state;

    public WishList(User user, Tour tour, String state) {
        this.user = user;
        this.tour = tour;
        this.state = state;
    }

    public WishList() {
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
        return "WishList{" + "user=" + user + ", tour=" + tour + ", state=" + state + '}';
    }
    
}
