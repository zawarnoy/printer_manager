package src.server.core.events.client;

import org.springframework.context.ApplicationEvent;

import java.net.Socket;

public class NewClientEvent extends ApplicationEvent {

    private Socket socket;

    public NewClientEvent(Object source, Socket socket) {
        super(source);
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
}
