package ticket.booking.repositories;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import ticket.booking.models.Ticket;

import java.util.List;

@MongoRepository
public interface TicketRepository extends CrudRepository<Ticket, String> {
    List<Ticket> findAll(Pageable pageable);
}
