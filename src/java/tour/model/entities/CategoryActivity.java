/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class CategoryActivity {

    private int id;
    private String description;

    public CategoryActivity(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public CategoryActivity() {
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
        return "CategoryActivity{" + "id=" + id + ", description=" + description + '}';
    }
    
    
}
