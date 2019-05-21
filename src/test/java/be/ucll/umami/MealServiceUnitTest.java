package be.ucll.umami;

import be.ucll.umami.model.Meal;
import be.ucll.umami.model.MealService;
import be.ucll.umami.repository.MealRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;

@RunWith(SpringRunner.class)
public class MealServiceUnitTest {

    @TestConfiguration
    static class MealServiceTestContextConfiguration {
        @Bean
        public MealService mealService() {
            return new MealService();
        }
    }

    @Autowired
    private MealService mealService;

    @MockBean
    private MealRepository mealRepository;

    private Meal ok;
    private Meal soep;
    private Meal dagschotel;
    private Meal veggie;
    private List<Meal> allMeals;


    @Before
    public void setUp() {
        ok = MealBuilder.anOKMeal().build();
        soep = MealBuilder.anOKSoep().build();
        dagschotel = MealBuilder.anOKDagschotel().build();
        veggie = MealBuilder.anOKVeggie().build();
        allMeals = new ArrayList<>();
        allMeals.add(soep);
        allMeals.add(dagschotel);
        allMeals.add(veggie);
        allMeals.add(ok);
    }

    @Test
    public void whenFindMealByDescription_thenMealShouldBeFound(){
        Mockito.when(mealRepository.findByDescription("OK well done!!!")).thenReturn(ok);

        String price = "1";
        double priceD = (double) Double.parseDouble(price.trim());
        String description = "OK well done!!!";
        String type = "type";
        Meal found = mealService.findMealByDescription(description);
        assertThat(found.getDescription()).isEqualTo(description);
        assertThat(found.getPrice()).isEqualTo(priceD);
        assertThat(found.getType()).isEqualTo(type);
    }

    @Test
    public void whenAddMeal_thenMealShouldBeFound() {
        Mockito.when(mealRepository.save(ok)).thenReturn(ok);

        Meal MealAdded = mealService.addMeal(ok);
        assertThat(MealAdded).isEqualTo(ok);
    }

    @Test
    public void whenDeleteMeal_thenMealShouldBeGone() {
        mealService.deleteMeal(ok);
        Mockito.verify(mealRepository, Mockito.times(1)).delete(ok);

    }

    @Test
    public void whenUpdateMeal_thenMealShouldBeGoneUpdated() {
        Mockito.when(mealRepository.save(ok)).thenReturn(ok);

        Meal mealUpdated = mealService.updateMeal(ok);
        assertThat(mealUpdated.getDescription()).isEqualTo("OK well done!!!");
    }

    @Test
    public void whenGetAllMeals_thenAllMealsShouldBeFound(){
        Mockito.when(mealRepository.findAll()).thenReturn(allMeals);

        List<Meal> found = mealService.getAllMeals();
        assertThat(found.size()).isEqualTo(4);
        assertThat(found).contains(soep);
        assertThat(found).contains(dagschotel);
        assertThat(found).contains(veggie);
        assertThat(found).contains(ok);
    }


}
