package messiasproject.microservicespecialist.itemorder.domain.exception;

public class ListEmptyException extends RuntimeException {
    public ListEmptyException() {
        super("List_Empty_Exception");
    }
}
