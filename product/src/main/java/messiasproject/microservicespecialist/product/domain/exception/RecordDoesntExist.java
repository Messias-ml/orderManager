package messiasproject.microservicespecialist.product.domain.exception;

public class RecordDoesntExist extends BusinessException {
    private Object[] objects;

    public RecordDoesntExist(Object[] objects) {
        super("record_does_not_exist", objects);
        this.objects = objects;
    }
}
