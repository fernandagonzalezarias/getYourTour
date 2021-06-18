/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class Images {
    private int id;
    private String name, path;

    public Images(int id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public Images() {
        this(0, "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Images{" + "id=" + id + ", name=" + name + ", path=" + path + '}';
    }
    
}
