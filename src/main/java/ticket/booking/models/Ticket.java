package ticket.booking.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.data.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedEntity("tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String eventId;

    @Relation(value = Relation.Kind.ONE_TO_ONE, mappedBy = "ticket")
    private Booking booking;

    @JsonProperty("created_at")
    @DateCreated
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @DateUpdated
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
