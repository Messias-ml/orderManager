package messiasproject.microservicespecialist.order.config.util.enums;

public enum MessagesToError {
    MENSAGE_ERRO_VALIDATION("erro.validation"),
    FEIGN_SERVICE_UNAVAILABLE("feign.service.unavailable"),
    FEIGN_RECORD_NOR_FOUND("feign.record.not.found");

    private String message;

    MessagesToError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
