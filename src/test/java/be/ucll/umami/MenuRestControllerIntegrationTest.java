package be.ucll.umami;

import be.ucll.umami.model.DayMenu;
import be.ucll.umami.model.Meal;
import be.ucll.umami.repository.DayMenuRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class MenuRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private DayMenuRepository repository;

    private DayMenu ok;

    @Before
    public void setUp() {
        ok = DayMenuBuilder.anOKDayMenu().build();
    }


    @Test
    public void givenMenus_whenGetWeekMenu_thenStatus200AndJSONofMenus() throws Exception {

        mvc.perform(post("/dagmenu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("{\"dag\": \"Dinsdag\",\"datum\": \"21-05-2019\", \"soep\": {\"mealId\": 6,\"price\": 2.45,\"description\": \"Uiensoep\",\"type\": \"soep\" },\"dagschotel\": {\"mealId\": 5, \"price\": 4.15,   \"description\": \"Steak tartaar\", \"type\": \"dagschotel\"},\"veggie\": { \"mealId\": 7, \"price\": 4, \"description\": \"Lasagne\", \"type\": \"veggie\" } }"));


        mvc.perform(get("/weekmenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].dag").value("Dinsdag"))
                .andExpect(jsonPath("$[0].datum").value("21-05-2019"));
    }

    @Test
    public void givenMenus_whenGetMenus_thenStatus200AndJSONofMenus() throws Exception {

        mvc.perform(post("/dagmenu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("{\"dag\": \"Dinsdag\",\"datum\": \"14-05-2019\", \"soep\": {\"mealId\": 6,\"price\": 2.45,\"description\": \"Uiensoep\",\"type\": \"soep\" },\"dagschotel\": {\"mealId\": 5, \"price\": 4.15,   \"description\": \"Steak tartaar\", \"type\": \"dagschotel\"},\"veggie\": { \"mealId\": 7, \"price\": 4, \"description\": \"Lasagne\", \"type\": \"veggie\" } }"));


        mvc.perform(get("/dagmenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].dag").value("Dinsdag"))
                .andExpect(jsonPath("$[0].datum").value("14-05-2019"));
    }


    @Test
    public void givenNoMenu_whenAddMenu_thenStatus200AndJSONofMenus() throws Exception {

        mvc.perform(post("/dagmenu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("{\"dag\": \"Dinsdag\",\"datum\": \"14-05-2019\", \"soep\": {\"mealId\": 6,\"price\": 2.45,\"description\": \"Uiensoep\",\"type\": \"soep\" },\"dagschotel\": {\"mealId\": 5, \"price\": 4.15,   \"description\": \"Steak tartaar\", \"type\": \"dagschotel\"},\"veggie\": { \"mealId\": 7, \"price\": 4, \"description\": \"Lasagne\", \"type\": \"veggie\" } }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dag").value("Dinsdag"))
                .andExpect(jsonPath("$[0].datum").value("14-05-2019"));
    }
    @Test
    public void givenNoMenus_whenAddInvalidMenu_thenStatus404AndErrorMessage() throws Exception {

        mvc.perform(post("/dagmenu/add")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("{\"dag\": \"Dinsdag\",\"datum\": \"1\", \"soep\": {\"mealId\": 6,\"price\": 2.45,\"description\": \"Uiensoep\",\"type\": \"soep\" },\"dagschotel\": {\"mealId\": 5, \"price\": 4.15,   \"description\": \"Steak tartaar\", \"type\": \"dagschotel\"},\"veggie\": { \"mealId\": 7, \"price\": 4, \"description\": \"Lasagne\", \"type\": \"veggie\" } }"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenOneMenu_whenChangeMenu_thenStatus200AndJSONofMenus() throws Exception {

        mvc.perform(put("/dagmenu/change/14-05-2019")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content("{\"dag\": \"Dinsdag\",\"datum\": \"14-05-2019\", \"soep\": {\"mealId\": 6,\"price\": 2.45,\"description\": \"Tomatensoep\",\"type\": \"soep\" },\"dagschotel\": {\"mealId\": 5, \"price\": 4.15,   \"description\": \"Steak tartaar\", \"type\": \"dagschotel\"},\"veggie\": { \"mealId\": 7, \"price\": 4, \"description\": \"Lasagne\", \"type\": \"veggie\" } }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].soep.description").value("Tomatensoep"))
                .andExpect(jsonPath("$[0].datum").value("14-05-2019"));
    }

    @Test
    public void givenOneMenu_whenDeleteMenu_thenStatus200AndJSONofMenus() throws Exception {

        mvc.perform(post("/dagmenu/delete/14-05-2019"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}

