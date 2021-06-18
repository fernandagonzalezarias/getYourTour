/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

public class City {
    private String code, name;
    private Country country;

    public City(String code, String name, Country country) {
        this.code = code;
        this.name = name;
        this.country = country;
    }

    public City() {
        this("", "", null);
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" + "code=" + code + ", name=" + name + ", country=" + country + '}';
    }
    
}
