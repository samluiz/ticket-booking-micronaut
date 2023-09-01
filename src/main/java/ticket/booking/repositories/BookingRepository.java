package ticket.booking.repositories;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import ticket.booking.models.Booking;

@MongoRepository
public interface BookingRepository extends CrudRepository<Booking, String> {
}
