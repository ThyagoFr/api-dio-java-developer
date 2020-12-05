package dio.bootcamp.personapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

    private String message;

    public BadRequest(String message) {
        super(message);
        this.message = message;
    }

}
