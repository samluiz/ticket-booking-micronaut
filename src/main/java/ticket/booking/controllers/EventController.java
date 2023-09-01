package ticket.booking.controllers;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import ticket.booking.models.Event;
import ticket.booking.services.EventService;

import java.util.List;

@Controller("/events")
@ExecuteOn(TaskExecutors.IO)
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @Get
    @Status(HttpStatus.OK)
    public List<Event> findAll(
            @RequestAttribute(name = "page", defaultValue = "0") int page,
            @RequestAttribute(name = "size", defaultValue = "10") int size) {
        Pageable pageable = Pageable.from(page, size);
        return eventService.findAll(pageable);
    }

    @Get("/{id}")
    @Status(HttpStatus.OK)
    public Event findById(@PathVariable String id) {
        return eventService.findById(id);
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Event save(@Body Event event) {
        return eventService.save(event);
    }

}
