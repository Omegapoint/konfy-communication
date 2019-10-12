package konfy.communication;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Post;

import javax.net.ssl.HttpsURLConnection;

@Controller("/mail")
public class MailController {

    private final MailService service;
    private final OptoutClient optoutClient;

    public MailController(MailService service, OptoutClient optoutClient) {
        this.service = service;
        this.optoutClient = optoutClient;
    }

    @Post("/")
    public HttpStatus sendEmail(@Body Message message) {
        System.err.println(message.email());
        System.err.println(message.subject());
        System.err.println(message.body());

        if (message.email() != null) {
            HttpStatus status = optoutClient.check(message.email());
            System.err.println("Opt-out: " + status);

            if (!HttpStatus.OK.equals(status)) {
                System.out.println("Sending mail");
                System.out.println("to: " + message.email());
                System.out.println("subject: " + message.subject());
                System.out.println("body:\n" + message.body());
            }
        }
        return HttpStatus.OK;
    }

}