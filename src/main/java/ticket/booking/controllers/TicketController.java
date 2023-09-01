package ticket.booking.controllers;

import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.RequiredArgsConstructor;
import ticket.booking.dtos.TicketResponse;
import ticket.booking.models.Ticket;
import ticket.booking.services.TicketService;

import java.util.List;

@Controller("/tickets")
@ExecuteOn(TaskExecutors.IO)
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @Get
    public List<TicketResponse> findAll(
            @RequestAttribute(name = "page", defaultValue = "0") int page,
            @RequestAttribute(name = "size", defaultValue = "10") int size) {
        Pageable pageable = Pageable.from(page, size);
        return ticketService.findAll(pageable);
    }

    @Get("/{id}")
    @Status(HttpStatus.OK)
    public TicketResponse findById(@PathVariable String id) {
        return ticketService.findById(id);
    }
}
