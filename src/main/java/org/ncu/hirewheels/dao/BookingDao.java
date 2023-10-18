package org.ncu.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ncu.hirewheels.entities.Booking;

import java.util.List;

public interface BookingDao extends JpaRepository<Booking, Long> {
    List<Booking> findByUserFirstNameIgnoreCase(String firstName);
    List<Booking> findByUserFirstNameIgnoreCaseOrUserLastNameIgnoreCase(String firstName, String lastName);
    List<Booking> findByUserEmailIgnoreCase(String email);
    List<Booking> findByUserMobileNumberIgnoreCase(String mobileNumber);
}