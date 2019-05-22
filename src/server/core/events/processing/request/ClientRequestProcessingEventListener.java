package src.server.core.events.processing.request;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import src.service.parser.BufferedReaderHandler;

import java.io.BufferedReader;
import java.util.Map;

public class ClientRequestProcessingEventListener implements ApplicationListener<ClientRequestProcessingEvent> {

    @Autowired
    BufferedReaderHandler bufferedReaderHandler;

    @Override
    public void onApplicationEvent(ClientRequestProcessingEvent clientRequestProcessingEvent) {
        BufferedReader in = clientRequestProcessingEvent.getInSource();

        bufferedReaderHandler.setBufferedReader(in);
        String json = bufferedReaderHandler.readDataFromBuffer();

        Map requestData = (new Gson()).fromJson(json, Map.class);

        // дальше обрабатываем эти данные
    }
}
