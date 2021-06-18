/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class TourActivity {
    private Activity activity;
    private Tour tour;

    public TourActivity(Activity activity, Tour tour) {
        this.activity = activity;
        this.tour = tour;
    }

    public TourActivity() {
        this(null, null);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "TourActivity{" + "activity=" + activity + ", tour=" + tour + '}';
    }
}
