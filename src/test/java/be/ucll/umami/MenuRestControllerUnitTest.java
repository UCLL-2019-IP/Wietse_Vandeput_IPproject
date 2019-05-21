package be.ucll.umami;

import be.ucll.umami.controller.MenuController;
import be.ucll.umami.model.DayMenu;
import be.ucll.umami.model.DayMenuService;
import be.ucll.umami.model.Meal;
import be.ucll.umami.model.MealService;
import be.ucll.umami.repository.DayMenuRepository;
import be.ucll.umami.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
public class MenuRestControllerUnitTest {

    @TestConfiguration
    static class MealServiceTestContextConfiguration {
        @Bean
        public DayMenuService dayMenuService() {
            return new DayMenuService();
        }
    }

    @Autowired
    private DayMenuService dayMenuService;

    @MockBean
    private MealService mealService;

    @MockBean
    private MealRepository mealRepository;


    @MockBean
    private DayMenuRepository dayMenuRepository;

    private DayMenu ok;
    private DayMenu nok;
    private DayMenu thisWeek;
    private List<DayMenu> all;

    @Before
    public void setUp() {
        ok = DayMenuBuilder.anOKDayMenu().build();
        nok = DayMenuBuilder.anotherOKDayMenu().build();
        thisWeek = DayMenuBuilder.anOKDayMenuFromThisWeek().build();
        all = new ArrayList<>();
        all.add(ok);
        all.add(nok);
    }

    @Test
    public void givenOneDaymenuThisWeek_whenGetWeekMenu_thenReturnJSONArray(){

          dayMenuService.addDayMenu(thisWeek);
          Mockito.verify(dayMenuRepository, Mockito.times(1)).findById(thisWeek.getDatum());


    }

    @Test
    public void givenTwoDayMenus_whenGetDagMenus_thenReturnJsonArray() {
        dayMenuService.getAllDayMenus();
        Mockito.verify(dayMenuRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void givenNoMenus_whenAddMenu_thenReturnJsonArray(){
        dayMenuService.addDayMenu(ok);
        Mockito.verify(dayMenuRepository, Mockito.times(1)).save(ok);
    }

    @Test
    public void givenOneMenu_whenChangeMenu_thenReturnJsonArray(){
        dayMenuService.changeDayMenu(ok.getDatum(), ok);
        Mockito.verify(dayMenuRepository, Mockito.times(1)).save(ok);
    }

    @Test
    public void givenOneMenu_whenDeleteMenu_thenReturnJsonArray() {
        dayMenuService.deleteDayMenu(ok);
            Mockito.verify(dayMenuRepository, Mockito.times(1)).delete(ok);
    }
}
