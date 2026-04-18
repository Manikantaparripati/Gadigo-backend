package com.gadigo.backend.service;

import com.gadigo.backend.model.Booking;
import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> getAllBookings();
    List<Booking> getBookingsByUser(String userId);
    Optional<Booking> getBookingById(String id);
    Booking createBooking(Booking booking);
    Booking updateBookingStatus(String id, String status);
    void deleteBooking(String id);
}
