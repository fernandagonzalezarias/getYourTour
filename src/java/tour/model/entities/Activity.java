/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class Activity {
    private int id;
    private String description;

    public Activity(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Activity() {
        this(0, "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Activity{" + "id=" + id + ", description=" + description + '}';
    }
    
}
