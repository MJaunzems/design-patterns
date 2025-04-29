package org.example.controllers;

import org.example.entities.ShapeEntity;
import org.example.repositories.ShapeRepository;
import org.example.enums.ColorName;
import org.example.enums.ShapeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ShapeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShapeRepository shapeRepository;

    @BeforeEach
    void setUp() {
        shapeRepository.deleteAll();
    }

    private final ShapeEntity shape = new ShapeEntity(null, ShapeType.SQUARE, (short) 5, ColorName.RED, (short) 0, (short) 0);
    
    @Test
    void testGetAllShapes() throws Exception {
        shapeRepository.save(shape);

        mockMvc.perform(get("/api/shapes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].type").value("SQUARE"))
                .andExpect(jsonPath("$.data[0].size").value(5))
                .andExpect(jsonPath("$.data[0].color").value("RED"))
                .andExpect(jsonPath("$.data[0].x").value(0))
                .andExpect(jsonPath("$.data[0].y").value(0));
    }

    @Test
    void testClearShapes() throws Exception {
        shapeRepository.save(shape);

        mockMvc.perform(delete("/api/shapes/clear"))
                .andExpect(status().isOk());

        assert shapeRepository.findAll().isEmpty();
    }

    @Test
    void testDeleteShapeById() throws Exception {
        ShapeEntity savedShape = shapeRepository.save(shape);

        mockMvc.perform(delete("/api/shapes/" + savedShape.getId()))
                .andExpect(status().isOk());

        assert shapeRepository.findById(savedShape.getId()).isEmpty();
    }
}
