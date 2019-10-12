package konfy.communication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Message {

    private final String email;
    private final String subject;
    private final String body;

    @JsonCreator
    public Message(@JsonProperty("email") String email, @JsonProperty("subject") String subject, @JsonProperty("body") String body) {
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    public String email() {
        return email;
    }

    public String subject() {
        return subject;
    }

    public String body() {
        return body;
    }
}
