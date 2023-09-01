package ticket.booking.exceptions;

public class ResourceNotFoundException extends RuntimeException {

        public ResourceNotFoundException(Object identifier) {
            super("Resource with identifier " + identifier + " not found.");
        }
}
