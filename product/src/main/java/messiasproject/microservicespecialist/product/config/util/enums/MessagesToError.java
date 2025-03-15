package messiasproject.microservicespecialist.product.config.util.enums;

public enum MessagesToError {
    MENSAGE_ERRO_VALIDATION("erro.validation");
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
