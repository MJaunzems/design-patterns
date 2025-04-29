package org.example.Controllers;

import org.example.Repositories.ShapeRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GridControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShapeRepository shapeRepository;

    @BeforeEach
    void setUp() {
        shapeRepository.deleteAll();
    }

    private String shapeJson = """
                {
                    "type": "SQUARE",
                    "size": 2,
                    "color": "RED",
                    "x": 0,
                    "y": 0
                }
                """;

    @Test
    void testAddShape() throws Exception {
        mockMvc.perform(post("/api/grid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(shapeJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.message").value("Shape added successfully!"));

        assert shapeRepository.findAll().size() == 1;
    }

    @Test
    void testDeleteShapeAtCoordinates() throws Exception {
        mockMvc.perform(post("/api/grid")
                .contentType(MediaType.APPLICATION_JSON)
                .content(shapeJson))
            .andExpect(status().isCreated());

        mockMvc.perform(delete("/api/grid/0/0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value("Shape or shapes deleted based on coordinates successfully!"));

        assert shapeRepository.findAll().isEmpty();
    }

    @Test
    void testGetGrid() throws Exception {
        mockMvc.perform(get("/api/grid"))
            .andExpect(status().isOk())
            .andExpect(content().string(Matchers.containsString(". . . ")));
    }
}
