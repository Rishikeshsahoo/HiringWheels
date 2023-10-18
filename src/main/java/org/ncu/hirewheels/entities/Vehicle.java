package org.ncu.hirewheels.entities;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false, precision = 10)
    private Long vehicleId;

    @Column(name = "vehicle_model", nullable = false, length = 50)
    private String vehicleModel;

    @Column(name = "vehicle_number", nullable = false, length = 10)
    private String vehicleNumber;

    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_id", nullable = true)
    private Vehicle_Subcategory vehicleSubcategory;

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = true)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id", nullable =true)
    private Fuel_Type fuelType;

    @Column(name = "availability_status", nullable = false)
    private int availabilityStatus;

    @Column(name = "vehicle_image_url", nullable = false, length = 500)
    private String vehicleImageUrl;
    
    
    
    @ManyToOne
    @JoinColumn(name = "vehicle_category_id", nullable = true)
    private Vehicle_Category vehicleCategory;
    // Constructors, getters, and setters



    public void setAvailabilityStatus(int i) {
        this.availabilityStatus = i;
    }
    
    public Location getlocation() {
        return location;
    }




    // toString() method

    // Other methods or attributes as needed
}