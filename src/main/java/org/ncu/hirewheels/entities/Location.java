package org.ncu.hirewheels.entities;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false, precision = 10)
    private Long locationId;

    @Column(name = "location_name", nullable = false, length = 50)
    private String locationName;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "pincode", nullable = false, length = 6)
    private String pincode;
    
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings;
    

    @OneToMany(mappedBy = "location")
    private List<Vehicle> vehicles;


	public void setName(Location location) {
		// TODO Auto-generated method stub
		
	}
	public Location(String name) {
	    this.locationName = name;
	}


    // Constructors, getters, and setters

    // toString() method

    // Other methods or attributes as needed
}
