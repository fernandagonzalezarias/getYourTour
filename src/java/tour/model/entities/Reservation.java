/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class Reservation {
    private int id, tickets;
    private User user;
    private Tour tour;

    public Reservation(int id, int tickets, User user, Tour tour) {
        this.id = id;
        this.tickets = tickets;
        this.user = user;
        this.tour = tour;
    }

    public Reservation() {
        this(0, 0, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
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

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", tickets=" + tickets + ", user=" + user + ", tour=" + tour + '}';
    }
}
