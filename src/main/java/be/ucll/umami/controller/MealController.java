package be.ucll.umami.controller;

import be.ucll.umami.model.Meal;
import be.ucll.umami.model.UmamiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class MealController implements WebMvcConfigurer {

    @Autowired
    private UmamiService mealService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/gerechten")
    public String meal(Model model){
        model.addAttribute("meals", mealService.getAllMeals());
        return "meals";
    }

    @GetMapping("/gerechten/change")
    public String changeMeals(Model model){
        model.addAttribute("meals", mealService.getAllMeals());
        return "mealsChange";
    }

    @GetMapping("/gerechten/add")
    public String addMealForm() {
        return "mealsAdd";
    }

    @PostMapping("/gerechten/add")
    public String addMeal(@Valid Meal meal, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "mealsAdd";
        }
        else {
            mealService.addMeal(meal);
            model.addAttribute("meals", mealService.getAllMeals());
            return "mealsChange";
        }
    }

    @GetMapping("/gerechten/update")
    public String updateMealForm(@RequestParam("description") String beschrijving, Model model){
        Meal meal = mealService.findMealByDescription(beschrijving);
        model.addAttribute("meal", meal);
        return "mealsUpdate";
    }


    @PutMapping("/gerechten/update")
    public String updateMeal(@RequestParam("description") String beschrijving,@Valid Meal meal, BindingResult bindingResult, Model model){
        Meal oldMeal = mealService.findMealByDescription(beschrijving);
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "mealsUpdate";
        }
        else {
            mealService.updateMeal(1, meal);
            model.addAttribute("meals", mealService.getAllMeals());
            return "mealsChange";
        }
    }

    @GetMapping("/gerechten/delete")
    public String deleteMealByDescription(@RequestParam("description") String beschrijving,@RequestParam("confirmation") String conf, Model model){
        Meal meal = mealService.findMealByDescription(beschrijving);
        model.addAttribute("meal", meal);
        if(conf.equals("true")){
            mealService.deleteMeal(meal);
            model.addAttribute("meals", mealService.getAllMeals());
            return "mealsChange";
        }

        return "mealsDelete";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Requested ID not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler(){}
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}