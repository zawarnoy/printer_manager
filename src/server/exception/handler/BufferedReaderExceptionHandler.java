package src.server.exception.handler;

import src.exception.ExceptionHandler;

public class BufferedReaderExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(Exception e) {
        System.out.println("Error read client data. Closing connection");
        Thread.currentThread().interrupt();
    }
}
