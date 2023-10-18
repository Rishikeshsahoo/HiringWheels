package org.ncu.hirewheels.controller;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hirewheels/v1")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.addBooking(booking);

        if (savedBooking != null) {
            String responseMessage = "Booking successfully added to the database. Booking ID: " + savedBooking.getBookingId();
            return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add booking.", HttpStatus.BAD_REQUEST);
        }
    }
}
