package be.ucll.umami.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UmamiService {

    private List<Meal> meals = new ArrayList<Meal>();
    private AtomicInteger nextId = new AtomicInteger();

    public UmamiService() {
        meals.add(new Meal(2.45, "Tomatensoep", "soep"));
        meals.add(new Meal(4.15, "Konijn met pruimen", "dagschotel"));
        meals.add(new Meal(4, "Spaghetti bolognese", "veggie"));
    }

    public List<Meal> getAllMeals(){
        return meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void deleteMeal(Meal meal) {
        meals.remove(meal);
    }

    public Meal findMealByDescription(String description) {
        for(Meal meal : meals){
            if(meal.getDescription().equals(description)){
                return meal;
            }
        }
        throw new IllegalArgumentException("Er staan geen gerechten op het menu met deze beschrijving.");
    }
}
