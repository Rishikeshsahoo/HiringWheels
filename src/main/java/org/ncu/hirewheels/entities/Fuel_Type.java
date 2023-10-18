package org.ncu.hirewheels.entities;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name = "fuel_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fuel_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fuel_type_id", nullable = false, precision = 10)
    private Long fuelTypeId;

    @Column(name = "fuel_type", nullable = false, length = 50, unique = true)
    private String fuelType;
    
    @OneToMany(mappedBy = "fuelType")
    private List<Vehicle> vehicles;

    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
