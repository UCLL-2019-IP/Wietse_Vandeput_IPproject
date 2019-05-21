package be.ucll.umami.repository;

import be.ucll.umami.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    Meal findByDescription(String description);


}
