package org.example.Controllers;

import java.time.LocalDateTime;

import org.example.DTOs.ResponseDTO;
import org.example.DTOs.ShapeCreateDTO;
import org.example.Services.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grid")
public class GridController {

    @Autowired
    private GridService gridService;

    @PostMapping
    public ResponseEntity<ResponseDTO<Void>> addShape(@RequestBody ShapeCreateDTO shape) { // Can also use @RequestParam if wanting to pass parameters directly
        gridService.addShape(shape);
        ResponseDTO<Void> response = new ResponseDTO<Void>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Shape added successfully!", null);
        return new ResponseEntity<ResponseDTO<Void>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{x}/{y}")
    public ResponseEntity<ResponseDTO<Void>> deleteShapeAtCoordinates(@PathVariable int x, @PathVariable int y) {
        gridService.deleteShapeAtCoordinates(x, y);
        ResponseDTO<Void> response = new ResponseDTO<Void>(LocalDateTime.now(), HttpStatus.OK.value(), "Shape or shapes deleted based on coordinates successfully!", null);
        return new ResponseEntity<ResponseDTO<Void>>(response, HttpStatus.OK);
    }

    @GetMapping
    public String getGrid() {
        return gridService.getGrid();
    }
}
