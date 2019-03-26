package be.ucll.umami.controller;

import be.ucll.umami.model.DayMenu;
import be.ucll.umami.model.UmamiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private UmamiService menuService;


    @GetMapping("weekmenu")
    public List<DayMenu> getWeekMenu() {
        return menuService.getWeekMenu();
    }

    @PostMapping("weekmenu/add")
    @ResponseStatus(HttpStatus.CREATED)
    public List<DayMenu> createNewDayMenu(@RequestBody @Valid DayMenu dayMenu) {
        menuService.addDayMenu(dayMenu);
        return menuService.getWeekMenu();
    }

    @PutMapping("dagmenu/change/{date}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public DayMenu editSpecificWholeFeedback(@PathVariable("date") String date, @RequestBody @Valid DayMenu changedDayMenu) {
        return menuService.changeDayMenu(date, changedDayMenu);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested feedback not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler() {
    }
}
