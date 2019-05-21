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
/**
    Meal meal1 = new Meal("2.45", "Tomatensoep", "soep");
    Meal meal2 = new Meal("4.15", "Konijn met pruimen", "dagschotel");
    Meal meal3 = new Meal("4.0", "Spaghetti bolognese", "veggie");
    Meal meal4 = new Meal("2.45", "Uiensoep", "soep");
    Meal meal5 = new Meal("4.15", "Steak tartaar", "dagschotel");
    Meal meal6 = new Meal("4.0", "Lasagne", "veggie");
    Meal meal7 = new Meal("2.45", "Pompoensoep", "soep");
    Meal meal8 = new Meal("4.15", "Wraps met zalm", "dagschotel");
    Meal meal9 = new Meal("4.0", "Pasta Pesto", "veggie");
**/
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
/**
    // use this to fill up the database from the start
    @Bean
    @Order(1) // do this first
    CommandLineRunner runnerMeals(MealRepository repo){
        return MealArgs -> {
            repo.save(meal1);
            repo.save(meal2);
            repo.save(meal3);
        };
    }

    @Bean
    @Order(2) // do this secondly
    CommandLineRunner runnerMenu(DayMenuRepository repo){
        return MenuArgs -> {
            repo.save(new DayMenu("Maandag", "11-04-2019", meal4, meal5, meal6));
            repo.save(new DayMenu("Dinsdag", "12-04-2019", meal7, meal8, meal9));
        };
    }**/
}
