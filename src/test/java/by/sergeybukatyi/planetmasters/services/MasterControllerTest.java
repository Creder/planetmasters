package by.sergeybukatyi.planetmasters.services;

import by.sergeybukatyi.planetmasters.controllers.MasterController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MasterController.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
class MasterControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private MasterService service;


    @Test
    void saveMaster() throws Exception {
        mvc.perform(post("/masters/save").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))
                .param("name", "Tanos").param("age", "10"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Tanos saved!"));
    }


    @Test
    void getAll() {
    }


    @Test
    void getMastersWithoutPlanets() {

    }

    @Test
    void getTenYoungestMasters() {
    }
}