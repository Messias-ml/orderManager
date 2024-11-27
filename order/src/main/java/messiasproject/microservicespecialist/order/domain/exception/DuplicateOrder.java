package messiasproject.microservicespecialist.order.domain.exception;

import lombok.Getter;

@Getter
public class DuplicateOrder extends BusinessException{
    private Object[] objects;

    public DuplicateOrder(Object[] objects) {
        super("duplicate_order", objects);
        this.objects = objects;
    }
}
