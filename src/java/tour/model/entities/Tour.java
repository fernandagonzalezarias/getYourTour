/*
    Laboratorio Móviles 
    Elaborado por:
                   - Fernanda González Arias
                   - Scarleth Villareal Jimenez
 */
package tour.model.entities;

import java.util.Date;

public class Tour {

    private int id, maxCant;
    private String name, description, guidance;
    private float duration, price;
    private Date inicitalDate;
    private City city;
    private CategoryActivity category;

    public Tour(int id, int maxCant, String name, String description, String guidance, float duration, float price, Date inicitalDate, City city, CategoryActivity category) {
        this.id = id;
        this.maxCant = maxCant;
        this.name = name;
        this.description = description;
        this.guidance = guidance;
        this.duration = duration;
        this.price = price;
        this.inicitalDate = inicitalDate;
        this.city = city;
        this.category = category;
    }

    public Tour() {
        this(0, 0, null, null, null, 0, 0, null, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCant() {
        return maxCant;
    }

    public void setMaxCant(int maxCant) {
        this.maxCant = maxCant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuidance() {
        return guidance;
    }

    public void setGuidance(String guidance) {
        this.guidance = guidance;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getInicitalDate() {
        return inicitalDate;
    }

    public void setInicitalDate(Date inicitalDate) {
        this.inicitalDate = inicitalDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CategoryActivity getCategory() {
        return category;
    }

    public void setCategory(CategoryActivity category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Tour{" + "id=" + id + ", maxCant=" + maxCant + ", name=" + name + ", description=" + description 
                + ", guidance=" + guidance + ", duration=" + duration + ", price=" + price + ", inicitalDate=" 
                + inicitalDate + ", city=" + city + ", category=" + category + '}';
    }
    
    
}
