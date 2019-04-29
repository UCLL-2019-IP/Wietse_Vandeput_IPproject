package be.ucll.umami.model;

import be.ucll.umami.repository.DayMenuRepository;
import be.ucll.umami.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UmamiService {
    @Autowired
    MealRepository mealRepository ; // dependency injection of the repository

    @Autowired
    DayMenuRepository dayMenuRepository; // dependency injection of the repository

    public UmamiService() {
    }

    public List<DayMenu> getWeekMenu() {return dayMenuRepository.findAll();}

    public void addDayMenu(DayMenu daymenu) {dayMenuRepository.save(daymenu);}

    public DayMenu changeDayMenu(String date, DayMenu dM){
        for(DayMenu dayM : dayMenuRepository.findAll()){
            if(dayM.getDatum().equals(date)){
                dayM.setSoep(dM.getSoep());
                dayM.setDagschotel(dM.getDagschotel());
                dayM.setVeggie(dM.getVeggie());
                return dayM;
            }
        }
        throw new IllegalArgumentException("No menu for this day!");
    }

    public List<Meal> getAllMeals(){
        return mealRepository.findAll();
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public void deleteMeal(Meal meal) {
        mealRepository.delete(meal);
    }

    public Meal findMealByDescription(String description) {
        return mealRepository.findByDescription(description);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal); // all we need to do to change a feedback
    }
}
