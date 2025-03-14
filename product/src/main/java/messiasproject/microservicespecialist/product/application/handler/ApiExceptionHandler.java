package messiasproject.microservicespecialist.product.application.handler;

import lombok.AllArgsConstructor;
import messiasproject.microservicespecialist.product.domain.exception.BusinessException;
import messiasproject.microservicespecialist.product.domain.exception.RecordDoesntExist;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Problem> hendlerBusinessException(BusinessException BusinessException) {
        String nameErro = "Erro no formulario";
        Problem problem = getProblem(BusinessException.getMessage(), BusinessException.getObjects(),
                nameErro, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(problem);
    }

    @ExceptionHandler(RecordDoesntExist.class)
    public ResponseEntity<Problem> hendlerRecordDoesntExist(RecordDoesntExist recordDoesntExist) {
        String nameErro = "Registro não existente";
        Problem problem = getProblem(recordDoesntExist.getMessage(), recordDoesntExist.getObjects(),
                nameErro, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(problem);
    }


    private Problem getProblem(String message, Object[] objects, String nameErro, Integer status) {
        String detail = getMessage(objects, message.concat(".detail"));
        String messageUser = getMessage(objects, message.concat(".message_user"));
        return Problem.builder()
                .status(status)
                .title(nameErro)
                .detail(detail)
                .messageUser(messageUser)
                .build();
    }

    private String getMessage(Object[] objects, String message) {
        return messageSource.getMessage(message, objects, LocaleContextHolder.getLocale());
    }
}
