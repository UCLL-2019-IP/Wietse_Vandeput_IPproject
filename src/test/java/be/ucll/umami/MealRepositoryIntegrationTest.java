package be.ucll.umami;

import be.ucll.umami.model.Meal;
import be.ucll.umami.repository.MealRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MealRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MealRepository mealRepository;

    @Test
    public void whenFindAll_thenReturnAllFeedback() {
        Meal ok = MealBuilder.anOKMeal().build();
        entityManager.persist(ok);
        entityManager.flush();
        Meal nok = MealBuilder.anOKSoep().build();
        entityManager.persist(nok);
        entityManager.flush();
        List<Meal> MealsFound = mealRepository.findAll();
        assertThat(MealsFound.size() == 2);
        assertThat(MealsFound.contains(ok));
        assertThat(MealsFound.contains(nok));
    }

    @Test
    public void whenFindByDescription_thenReturnMeal() {
        Meal ok = MealBuilder.anOKMeal().build();
        entityManager.persist(ok);
        entityManager.flush();
        Meal found = mealRepository.findByDescription(ok.getDescription());
        assertThat(found.getPrice()).isEqualTo(ok.getPrice());
        assertThat(found.getDescription()).isEqualTo(ok.getDescription());
    }

    @Test
    public void whenAddMeal_thenMealIsFound(){
        Meal ok = MealBuilder.anOKMeal().build();
        Meal mealAdded = mealRepository.save(ok);
        assertThat(mealAdded.getDescription()).isEqualTo(ok.getDescription());
    }
}
