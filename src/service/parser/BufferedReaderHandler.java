package src.service.parser;

import org.springframework.stereotype.Service;
import src.server.exception.handler.BufferedReaderExceptionHandler;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class BufferedReaderHandler {

    private BufferedReader bufferedReader;

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    // тут будем получать строку, которую отправлии с клиента
    public String readDataFromBuffer() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            // если произошла ошибка при чтении останавливаем текущий поток
            (new BufferedReaderExceptionHandler()).handle(e);
            return null;
        }
    }
}
