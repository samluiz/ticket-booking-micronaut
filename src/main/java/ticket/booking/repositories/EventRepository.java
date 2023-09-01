package ticket.booking.repositories;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import ticket.booking.models.Event;

import java.util.List;

@MongoRepository
public interface EventRepository extends CrudRepository<Event, String> {

    List<Event> findAll(Pageable pageable);
}
