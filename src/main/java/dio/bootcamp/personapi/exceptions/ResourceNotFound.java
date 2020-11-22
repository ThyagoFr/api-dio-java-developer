package dio.bootcamp.personapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    private String message;

    public ResourceNotFound(String message) {
        super(message);
        this.message = message;
    }
}
