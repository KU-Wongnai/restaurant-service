package ku.cs.kuwongnai.restaurant.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllRestaurants() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurants")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetRestaurantById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurants/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testGetMenusByRestaurantId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurants/1/menu")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testMenuById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurants/1/menu/items/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetMenuOptions() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurants/1/menu/items/1/options")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetMenuOptionById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/restaurants/1/menu/items/1/options/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}