/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class Country {

    private String code, name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Country() {
        this("", "");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" + "code=" + code + ", name=" + name + '}';
    }
    
}
