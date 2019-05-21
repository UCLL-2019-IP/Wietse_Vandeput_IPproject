package be.ucll.umami;

import be.ucll.umami.model.DayMenu;
import be.ucll.umami.model.Meal;

public class DayMenuBuilder {

    private String dag;
    private String datum;
    private Meal soep;
    private Meal dagschotel;
    private Meal veggie;


    private DayMenuBuilder () {
    }

    public static DayMenuBuilder aDayMenu () {
        return new DayMenuBuilder();
    }

    public static DayMenuBuilder anOKDayMenu() {
        return aDayMenu().withDag("Maandag").withDatum("13-05-2019").withSoep(MealBuilder.anOKSoep().build()).withDagSchotel(MealBuilder.anOKDagschotel().build()).withVeggie(MealBuilder.anOKVeggie().build());
    }

    public static DayMenuBuilder anotherOKDayMenu() {
        return aDayMenu().withDag("Dinsdag").withDatum("14-05-2019").withSoep(MealBuilder.anOKSoep().build()).withDagSchotel(MealBuilder.anOKDagschotel().build()).withVeggie(MealBuilder.anOKVeggie().build());
    }

    public static DayMenuBuilder anOKDayMenuFromThisWeek() {
        return aDayMenu().withDag("Dinsdag").withDatum("21-05-2019").withSoep(MealBuilder.anOKSoep().build()).withDagSchotel(MealBuilder.anOKDagschotel().build()).withVeggie(MealBuilder.anOKVeggie().build());
    }


    public DayMenuBuilder withDag (String dag) {
        this.dag = dag;
        return this;
    }

    public DayMenuBuilder withDatum (String datum) {
        this.datum = datum;
        return this;
    }

    public DayMenuBuilder withSoep (Meal soep) {
        this.soep = soep;
        return this;
    }

    public DayMenuBuilder withDagSchotel (Meal dagschotel) {
        this.dagschotel = dagschotel;
        return this;
    }

    public DayMenuBuilder withVeggie (Meal veggie) {
        this.veggie = veggie;
        return this;
    }

    public DayMenu build() {
        DayMenu dayMenu = new DayMenu();
        dayMenu.setDag(this.dag);
        dayMenu.setDatum(this.datum);
        dayMenu.setSoep(this.soep);
        dayMenu.setDagschotel(this.dagschotel);
        dayMenu.setVeggie(this.veggie);
        return dayMenu;
    }
}
