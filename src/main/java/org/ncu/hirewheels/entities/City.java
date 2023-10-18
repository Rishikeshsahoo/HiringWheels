package org.ncu.hirewheels.entities;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false, precision = 10)
    private Long cityId;

    @Column(name = "city_name", nullable = false, length = 50)
    private String cityName;
    
    @OneToMany(mappedBy = "city")
    private List<Location> locations;

    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
