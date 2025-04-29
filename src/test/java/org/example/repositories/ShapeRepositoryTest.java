package org.example.repositories;

import org.example.entities.ShapeEntity;
import org.example.enums.ColorName;
import org.example.enums.ShapeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ShapeRepositoryTest {

    @Autowired
    private ShapeRepository shapeRepository;

    @Test
    void testFindByCoordinates() {
        ShapeEntity shape = new ShapeEntity();
        shape.setType(ShapeType.SQUARE);
        shape.setSize((short) 5);
        shape.setColor(ColorName.BLUE);
        shape.setX((short) 0);
        shape.setY((short) 0);
        shapeRepository.save(shape);

        List<ShapeEntity> result = shapeRepository.findByCoordinates(0, 0);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(ShapeType.SQUARE, result.get(0).getType());
    }
}
