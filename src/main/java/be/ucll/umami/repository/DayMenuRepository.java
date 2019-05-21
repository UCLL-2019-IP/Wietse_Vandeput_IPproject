package be.ucll.umami.repository;

import be.ucll.umami.model.DayMenu;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayMenuRepository extends JpaRepository<DayMenu, String> {
}

