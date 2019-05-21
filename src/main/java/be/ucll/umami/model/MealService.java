package be.ucll.umami.model;

import be.ucll.umami.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MealService")
public class MealService {

    @Autowired
    MealRepository mealRepository ;

    public MealService() {
    }

    public List<Meal> getAllMeals(){
        return mealRepository.findAll();
    }

    public Meal addMeal(Meal meal) { return mealRepository.save(meal); }

    public void deleteMeal(Meal meal) {
        mealRepository.delete(meal);
    }

    public Meal findMealByDescription(String description) {
        return mealRepository.findByDescription(description);
    }

    public Meal updateMeal(Meal meal) { return mealRepository.save(meal); }
}
