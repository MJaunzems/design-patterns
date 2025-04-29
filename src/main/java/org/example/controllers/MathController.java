package org.example.controllers;

import java.time.LocalDateTime;

import org.example.dtos.ResponseDTO;
import org.example.services.MathService;
import org.example.enums.ShapeType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shapes/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/{type}/area")
    public ResponseEntity<ResponseDTO<Double>> calculateArea(@PathVariable ShapeType type, @RequestParam double size) {
        ResponseDTO<Double> response = new ResponseDTO<>(LocalDateTime.now(), HttpStatus.OK.value(), "Area calculated successfully!", mathService.calculateArea(type, size));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{type}/perimeter")
    public ResponseEntity<ResponseDTO<Double>> calculatePerimeter(@PathVariable ShapeType type, @RequestParam double size) {
        ResponseDTO<Double> response = new ResponseDTO<>(LocalDateTime.now(), HttpStatus.OK.value(), "Area calculated successfully!", mathService.calculatePerimeter(type, size));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
