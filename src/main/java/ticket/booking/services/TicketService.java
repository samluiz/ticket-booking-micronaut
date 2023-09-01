package ticket.booking.services;

import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ticket.booking.dtos.TicketResponse;
import ticket.booking.exceptions.ResourceNotFoundException;
import ticket.booking.models.Event;
import ticket.booking.models.Ticket;
import ticket.booking.repositories.TicketRepository;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventService eventService;

    public List<TicketResponse> findAll(Pageable pageable) {
        return ticketRepository.findAll(pageable).stream().map(ticket ->
            TicketResponse.from(ticket, eventService.findById(ticket.getEventId()))).toList();
    }

    public TicketResponse findById(String id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return TicketResponse.from(ticket, eventService.findById(ticket.getEventId()));
    }

    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
