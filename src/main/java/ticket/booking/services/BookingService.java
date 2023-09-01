package ticket.booking.services;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ticket.booking.models.Booking;
import ticket.booking.models.Event;
import ticket.booking.models.Ticket;
import ticket.booking.repositories.BookingRepository;

@Singleton
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final TicketService ticketService;
    private final EventService eventService;

    public Booking save(Booking booking, String eventId) {
        Event event = eventService.findById(eventId);

        var ticket = ticketService.save(Ticket
                .builder()
                .name(booking.getFullName())
                .eventId(event.getId())
                .build());

        booking.setEvent(event);
        booking.setTicket(ticket);
        return bookingRepository.save(booking);
    }
}
