package org.example.Controllers;

import org.example.DTOs.ResponseDTO;
import org.example.DTOs.ShapeRequestDTO;
import org.example.Services.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ShapeService shapeService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<ShapeRequestDTO>>> getAllShapes() {
        ResponseDTO<List<ShapeRequestDTO>> response = new ResponseDTO<List<ShapeRequestDTO>>(LocalDateTime.now(), HttpStatus.OK.value(), "All shapes gotten!", shapeService.getAllShapes());
        return new ResponseEntity<ResponseDTO<List<ShapeRequestDTO>>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<ResponseDTO<Void>> clearShapes() {
        shapeService.clearShapes();
        ResponseDTO<Void> response = new ResponseDTO<Void>(LocalDateTime.now(), HttpStatus.OK.value(), "All shapes cleared!", null);
        return new ResponseEntity<ResponseDTO<Void>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteShapeById(@PathVariable Long id) {
        shapeService.deleteShapeById(id);
        ResponseDTO<Void> response = new ResponseDTO<Void>(LocalDateTime.now(), HttpStatus.OK.value(), "Shape deleted by id!", null);
        return new ResponseEntity<ResponseDTO<Void>>(response, HttpStatus.OK);
    }
}
