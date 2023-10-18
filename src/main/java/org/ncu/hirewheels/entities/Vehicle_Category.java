package org.ncu.hirewheels.entities;


import lombok.*;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "vehicle_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_category_id", nullable = false, precision = 10)
    private Long vehicleCategoryId;

    @Column(name = "vehicle_category_name", nullable = false, length = 50, unique = true)
    private String vehicleCategoryName;
   
    @OneToMany(mappedBy = "vehicleCategory")
    private List<Vehicle> vehicles;
    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
