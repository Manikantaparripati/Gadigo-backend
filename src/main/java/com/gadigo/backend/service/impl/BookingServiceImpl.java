package com.gadigo.backend.service.impl;

import com.gadigo.backend.model.Booking;
import com.gadigo.backend.model.BookingStatus;
import com.gadigo.backend.repository.BookingRepository;
import com.gadigo.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByUser(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Optional<Booking> getBookingById(String id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking createBooking(Booking booking) {
        booking.setCreatedAt(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBookingStatus(String id, String status) {
        return bookingRepository.findById(id).map(existingBooking -> {
            existingBooking.setStatus(BookingStatus.valueOf(status.toUpperCase()));
            return bookingRepository.save(existingBooking);
        }).orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    @Override
    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }
}
