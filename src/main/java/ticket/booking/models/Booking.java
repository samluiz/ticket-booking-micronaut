package ticket.booking.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.data.annotation.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ticket.booking.enums.PaymentMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedEntity("bookings")
public class Booking {

    @Id
    @GeneratedValue
    private String id;

    @JsonProperty("full_name")
    private String fullName;

    private String phone;

    @Email(message = "Email should be valid")
    private String email;

    private String address;

    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;

    @JsonProperty("birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Relation(value = Relation.Kind.ONE_TO_ONE, mappedBy = "booking", cascade = Relation.Cascade.ALL)
    private Ticket ticket;

    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private Event event;

    @JsonProperty("created_at")
    @DateCreated
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @DateUpdated
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
