/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class TourImages {
    private Images images;
    private Tour tour;

    public TourImages(Images images, Tour tour) {
        this.images = images;
        this.tour = tour;
    }

    public TourImages() {
        this(null, null);
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "TourImages{" + "images=" + images + ", tour=" + tour + '}';
    }
    
}
