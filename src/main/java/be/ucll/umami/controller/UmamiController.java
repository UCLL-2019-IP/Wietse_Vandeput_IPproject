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
public class UmamiController implements WebMvcConfigurer {

    @Autowired
    private UmamiService umamiService;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/gerechten")
    public String meal(Model model){
        model.addAttribute("meals", umamiService.getAllMeals());
        return "meals";
    }

    @GetMapping("/gerechten/change")
    public String changeMeals(Model model){
        model.addAttribute("meals", umamiService.getAllMeals());
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
            umamiService.addMeal(meal);
            model.addAttribute("meals", umamiService.getAllMeals());
            return "mealsChange";
        }
    }

    @GetMapping("/gerechten/update")
    public String updateMeal(Model model){
        return "mealsUpdate";
    }

//    @GetMapping("/gerechten/delete")
//    public String deleteMeal(Model model){
//       return "mealsDelete";
//    }

    @GetMapping("/gerechten/delete")
    public String deleteMealByDescription(@RequestParam("description") String beschrijving,@RequestParam("confirmation") String conf, Model model){
        Meal meal = umamiService.findMealByDescription(beschrijving);
        model.addAttribute("meal", meal);
        if(conf.equals("true")){
            umamiService.deleteMeal(meal);
            model.addAttribute("meals", umamiService.getAllMeals());
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