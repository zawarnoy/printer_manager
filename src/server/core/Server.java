package src.server.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import src.server.core.events.client.NewClientEvent;
import src.server.exception.handler.ServerIOExceptionHandler;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    private int socket;

    public Server(ServerParameters serverParameters) {
        this.socket = serverParameters.getSocket();
    }

    // запускаем сервер на сокете, который передается в классе параметров сервера
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(socket);
            while (true) {
                // создаём эвент по которому у нас создаётся новый обработчик запроса клиента
                // по эвентам ты писал, можешь ещё упомянуть https://www.baeldung.com/spring-events
                this.eventPublisher.publishEvent(new NewClientEvent(this, serverSocket.accept()));
            }
        } catch (IOException e) {
            // Для обработки возникающих ошибок, используется реализация интерфейса ExceptionHandler
            (new ServerIOExceptionHandler()).handle(e);
        }
    }
}
