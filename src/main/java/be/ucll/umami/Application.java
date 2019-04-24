package be.ucll.umami;

import be.ucll.umami.model.DayMenu;
import be.ucll.umami.model.Meal;
import be.ucll.umami.repository.DayMenuRepository;
import be.ucll.umami.repository.MealRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    // use this to fill up the database from the start
    @Bean
    @Order(1) // do this first
    CommandLineRunner runnerMeals(MealRepository repo){
        return MealArgs -> {
            repo.save(new Meal("2.45", "Tomatensoep", "soep"));
            repo.save(new Meal("4.15", "Konijn met pruimen", "dagschotel"));
            repo.save(new Meal("4.0", "Spaghetti bolognese", "veggie"));
            repo.save(new Meal("2.45", "Uiensoep", "soep"));
            repo.save(new Meal("4.15", "Steak tartaar", "dagschotel"));
            repo.save(new Meal("4.0", "Lasagne", "veggie"));
            repo.save(new Meal("2.45", "Pompoensoep", "soep"));
            repo.save(new Meal("4.15", "Wraps met zalm", "dagschotel"));
            repo.save(new Meal("4.0", "Pasta Pesto", "veggie"));
        };
    }

    @Bean
    @Order(2) // do this secondly
    CommandLineRunner runnerMenu(DayMenuRepository repo){
        return MenuArgs -> {
            repo.save(new DayMenu("Maandag", "11-04-2019", new Meal("2.45", "Tomatensoep", "soep"), new Meal("4.15", "Steak tartaar", "dagschotel"), new Meal("4.0", "Pasta Pesto", "veggie")));
            repo.save(new DayMenu("Dinsdag", "12-04-2019", new Meal("2.45", "Uiensoep", "soep"), new Meal("4.15", "Wraps met zalm", "dagschotel"), new Meal("4.0", "Spaghetti bolognese", "veggie")));
        };
    }
}
