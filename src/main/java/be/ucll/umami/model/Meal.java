package be.ucll.umami.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mealId;

    @NotNull(message = "De prijs mag niet leeg zijn.")
    @DecimalMin(value = "0.10", message = "In de prijs moet er een getal tussen 0,1 en 10,00 ingegeven worden.")
    @DecimalMax(value = "10.00", message = "In de prijs moet er een getal tussen 0,1 en 10,00 ingegeven worden.")
    private double price;

    @NotEmpty(message =  "De beschrijving mag ni et leeg zijn.")
    @Size(min=4, max=50, message = "In de beschrijving moeten er minimum 4 en maximum 50 tekens ingegeven worden.")
    private String description;

    @NotEmpty(message =  "Het type moet een van de volgende waardes zijn: soep, dagschotel of veggie.")
    private String type;

    public Meal() {
    }

    public Meal(String price, String description, String type) {
        setPrice(price);
        this.description = description;
        this.type = type;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer id) {
        this.mealId = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        try
        {
            this.price = (double) Double.parseDouble(price.trim());
        }
        catch(NumberFormatException e)
        {
            this.price = 0;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
