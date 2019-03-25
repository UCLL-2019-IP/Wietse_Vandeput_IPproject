package be.ucll.umami.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

public class Meal {

    //Test jenkins autopush update deploy

    @NotNull(message = "De prijs mag niet leeg zijn.")
    @DecimalMin(value = "0.10", message = "In de prijs moet er een getal tussen 0,1 en 10,00 ingegeven worden.")
    @DecimalMax(value = "10.00", message = "In de prijs moet er een getal tussen 0,1 en 10,00 ingegeven worden.")
    private double price;

    @NotEmpty(message =  "De omschrijving mag niet leeg zijn.")
    @Size(min=4, max=50, message = "In de beschrijving moeten er minimum 4 en maximum 50 tekens ingegeven worden.")
    private String description;

    @NotEmpty(message =  "Het type moet een van de volgende waardes zijn: soep, dagschotel of veggie.")
    private String type;

    public Meal() {
    }

    public Meal(double price, String description, String type) {
        this.price = price;
        this.description = description;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
