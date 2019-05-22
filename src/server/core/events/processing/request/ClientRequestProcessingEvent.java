package src.server.core.events.processing.request;

import org.springframework.context.ApplicationEvent;

import java.io.BufferedReader;

public class ClientRequestProcessingEvent extends ApplicationEvent {

    BufferedReader in;

    public ClientRequestProcessingEvent(Object source, BufferedReader in) {
        super(source);
        this.in = in;
    }

    public BufferedReader getInSource() {
        return in;
    }
}
