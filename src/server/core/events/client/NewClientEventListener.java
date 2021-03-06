package src.server.core.events.client;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import src.server.core.ClientHandler;
import src.server.exception.handler.ServerIOExceptionHandler;

import java.io.IOException;
import java.net.Socket;

@Component
public class NewClientEventListener implements ApplicationListener<NewClientEvent> {
    @Override
    public void onApplicationEvent(NewClientEvent newClientEvent) {
        // когда появляется новый запрос, по эвенту создаём обработчика,
        // в конструкторе обработчика висит метод, который запускает новый поток
        // про многопоточность https://javarush.ru/groups/posts/1992-mnogopotochnostjh-v-java-sutjh-pljusih-i-chastihe-lovushki-
        Socket socket = newClientEvent.getSocket();
        try {
            // обработчик
            new ClientHandler(socket);
        } catch (IOException e) {
            (new ServerIOExceptionHandler()).handle(e);
        }
    }
}
