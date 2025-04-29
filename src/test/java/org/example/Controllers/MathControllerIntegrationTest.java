package org.example.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculateAreaForSquare() throws Exception {
        mockMvc.perform(get("/api/shapes/math/SQUARE/area")
                .param("size", "4"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").value("16.0"));
    }

    @Test
    void testCalculatePerimeterForSquare() throws Exception {
        mockMvc.perform(get("/api/shapes/math/SQUARE/perimeter")
                .param("size", "4"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").value("16.0"));
    }

    @Test
    void testCalculateAreaForTriangle() throws Exception {
        mockMvc.perform(get("/api/shapes/math/TRIANGLE/area")
                .param("size", "5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").value("12.5"));
    }

    @Test
    void testCalculatePerimeterForTriangle() throws Exception {
        mockMvc.perform(get("/api/shapes/math/TRIANGLE/perimeter")
                .param("size", "5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data").value("7.0710678118654755"));
    }
}
