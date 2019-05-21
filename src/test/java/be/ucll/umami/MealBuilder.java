package be.ucll.umami;

import be.ucll.umami.model.Meal;

public class MealBuilder {

    private String price;
    private String description;
    private String type;

    private MealBuilder () {
    }

    public static MealBuilder aMeal () {
        return new MealBuilder();
    }

    public static MealBuilder anOKMeal () {
        return aMeal().withPrice("1").withDescription("OK well done!!!").withType("type");
    }

    public static MealBuilder anOKSoep () {
        return aMeal().withPrice("1").withDescription("soep").withType("Soep");
    }

    public static MealBuilder anOKDagschotel () {
        return aMeal().withPrice("1").withDescription("dagschotel").withType("Dagschotel");
    }

    public static MealBuilder anOKVeggie () {
        return aMeal().withPrice("1").withDescription("veggie").withType("Veggie");
    }

    public MealBuilder withPrice (String price) {
        this.price = price;
        return this;
    }

    public MealBuilder withDescription (String description) {
        this.description = description;
        return this;
    }

    public MealBuilder withType (String type) {
        this.type = type;
        return this;
    }

    public Meal build() {
        Meal meal = new Meal();
        meal.setPrice(price);
        meal.setDescription(this.description);
        meal.setType(this.type);
        return meal;
    }
}
