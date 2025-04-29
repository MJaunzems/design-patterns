package org.example.controllers;

import org.example.dtos.ResponseDTO;
import org.example.dtos.ShapeRequestDTO;
import org.example.services.ShapeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ShapeRequestDTO>>> getAllShapes() {
        ResponseDTO<List<ShapeRequestDTO>> response = new ResponseDTO<>(LocalDateTime.now(), HttpStatus.OK.value(), "All shapes gotten!", shapeService.getAllShapes());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<ResponseDTO<Void>> clearShapes() {
        shapeService.clearShapes();
        ResponseDTO<Void> response = new ResponseDTO<>(LocalDateTime.now(), HttpStatus.OK.value(), "All shapes cleared!", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteShapeById(@PathVariable Long id) {
        shapeService.deleteShapeById(id);
        ResponseDTO<Void> response = new ResponseDTO<>(LocalDateTime.now(), HttpStatus.OK.value(), "Shape deleted by id!", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
