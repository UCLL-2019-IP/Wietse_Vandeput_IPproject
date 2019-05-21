package be.ucll.umami.controller;

import be.ucll.umami.model.DayMenu;
import be.ucll.umami.model.DayMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("menuController")
public class MenuController {

    @Autowired
    private DayMenuService menuService;


    @GetMapping("weekmenu")
    public List<DayMenu> getWeekMenu() {
        return menuService.getWeekMenu();
    }

    @GetMapping("dagmenu")
    public List<DayMenu> getDagMenus() {
        return menuService.getAllDayMenus();
    }

    @PostMapping("dagmenu/add")
    @ResponseStatus(HttpStatus.OK)
    public List<DayMenu> createNewDayMenu(@RequestBody @Valid DayMenu dayMenu) {
        menuService.addDayMenu(dayMenu);
        return menuService.getAllDayMenus();
    }

    @PutMapping("dagmenu/change/{date}")
    public List<DayMenu> editSpecificDayMenu(@PathVariable("date") String date, @RequestBody @Valid DayMenu changedDayMenu) {
        menuService.changeDayMenu(date, changedDayMenu);
        return menuService.getAllDayMenus();
    }


    @PostMapping("dagmenu/delete/{date}")
    public List<DayMenu> deleteSpecificDayMenu(@PathVariable("date") String date) {
        DayMenu dM = menuService.findDayMenuById(date);
        menuService.deleteDayMenu(dM);
        return menuService.getAllDayMenus();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested menu not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler() {
    }
}
