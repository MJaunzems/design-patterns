package org.example.entities;

import org.example.enums.ColorName;
import org.example.enums.ShapeType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShapeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShapeType type;

    private short size;

    @Enumerated(EnumType.STRING)
    private ColorName color;

    private short x;
    private short y;
}
