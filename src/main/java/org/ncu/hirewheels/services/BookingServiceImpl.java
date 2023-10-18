package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.Booking;
import org.ncu.hirewheels.entities.User;
import org.ncu.hirewheels.dao.UserDao;
import org.ncu.hirewheels.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired
    private BookingDao bookingDao;
    
    @Autowired
    private UserDao userDao;

    @Override
    public Booking addBooking(Booking booking) {
        // Check if the user has sufficient balance
        User user = userDao.findById(booking.getUser().getUserId()).orElse(null);
        if (user != null && user.getAccountBalance() >= booking.getAmount()) {
            // Deduct the booking amount from the user's wallet balance
            user.setWalletMoney(user.getAccountBalance() - booking.getAmount());
            userDao.save(user);

            // Save the booking
            bookingDao.save(booking);

            return booking;
        } else {
            System.out.println("Insufficient Balance. Please Check With Admin.");
            return null; // or throw an exception
        }
    }
}
