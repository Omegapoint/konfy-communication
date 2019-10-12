package konfy.communication;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Client(id = "opt-out", path = "/opt")
public interface OptoutClient {

    @Get("/{email}")
    HttpStatus check(String email);
}