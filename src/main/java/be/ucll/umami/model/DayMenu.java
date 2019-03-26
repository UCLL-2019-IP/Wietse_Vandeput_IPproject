package be.ucll.umami.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DayMenu {

    @NotNull
    @NotEmpty
    @Size(min=2, max=30)
    private String dag;
    @NotNull
    @NotEmpty
    @Size(min=2, max=30)
    private String datum;
    @NotNull
    private Meal soep;
    @NotNull
    private Meal dagschotel;
    @NotNull
    private Meal veggie;

    public DayMenu() {}


    public DayMenu(String dag, String datum, Meal soep, Meal dagschotel, Meal veggie){
        this.setDag(dag);
        this.setDatum(datum);
        this.setSoep(soep);
        this.setDagschotel(dagschotel);
        this.setVeggie(veggie);
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Meal getSoep() {
        return soep;
    }

    public void setSoep(Meal soep) {
        this.soep = soep;
    }

    public Meal getDagschotel() {
        return dagschotel;
    }

    public void setDagschotel(Meal dagschotel) {
        this.dagschotel = dagschotel;
    }

    public Meal getVeggie() {
        return veggie;
    }

    public void setVeggie(Meal veggie) {
        this.veggie = veggie;
    }
}
