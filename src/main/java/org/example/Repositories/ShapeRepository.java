package org.example.Repositories;

import org.example.Entities.ShapeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShapeRepository extends JpaRepository<ShapeEntity, Long> {
    @Query("SELECT s FROM ShapeEntity s WHERE s.x <= :x AND s.x + s.size > :x AND s.y <= :y AND s.y + s.size > :y")
    List<ShapeEntity> findByCoordinates(@Param("x") int x, @Param("y") int y);
}
