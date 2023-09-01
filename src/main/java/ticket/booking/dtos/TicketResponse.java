package ticket.booking.dtos;

import io.micronaut.core.annotation.ReflectiveAccess;
import io.micronaut.serde.annotation.Serdeable;
import ticket.booking.models.Event;
import ticket.booking.models.Ticket;

@Serdeable
@ReflectiveAccess
public record TicketResponse(
        String id,
        String name,
        Event event
) {
    public static TicketResponse from(Ticket ticket, Event event) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getName(),
                event
        );
    }
}