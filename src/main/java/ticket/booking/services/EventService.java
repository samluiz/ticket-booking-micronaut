package ticket.booking.services;

import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ticket.booking.exceptions.ResourceNotFoundException;
import ticket.booking.models.Event;
import ticket.booking.repositories.EventRepository;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Event findById(String id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }
    
}
