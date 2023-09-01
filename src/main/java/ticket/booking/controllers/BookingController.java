package ticket.booking.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.RequiredArgsConstructor;
import ticket.booking.models.Booking;
import ticket.booking.services.BookingService;

@Controller("/bookings")
@ExecuteOn(TaskExecutors.IO)
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @Post
    @Status(HttpStatus.CREATED)
    public Booking save(@Body Booking booking, @QueryValue(value = "event") String eventId) {
        return bookingService.save(booking, eventId);
    }
}
