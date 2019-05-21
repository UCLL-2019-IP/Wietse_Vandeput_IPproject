package be.ucll.umami.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DayMenu {
    @NotNull
    @NotEmpty
    @Size(min=6, max=12,message = "The day must be a valid weekday.")
    private String dag;
    @Id
    @NotNull
    @NotEmpty
    @Size(min=10, max=10 ,message = "The date must be in format dd-MM-yyyy.")
    private String datum;
    @NotNull
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="soup_id", referencedColumnName="mealId")
    private Meal soep;
    @NotNull
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="dagschotel_id", referencedColumnName="mealId")
    private Meal dagschotel;
    @NotNull
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="veggie_id", referencedColumnName="mealId")
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
