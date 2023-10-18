package org.ncu.hirewheels.entities;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;



@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false, precision = 10)
    private Long roleId;

    @Column(name = "role_name", nullable = false, length = 50, unique = true)
    
    private String roleName;
    
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;


    // Constructors, getters, and setters are generated by Lombok's @Data annotation

    // toString() method is automatically generated by Lombok's @Data annotation

}