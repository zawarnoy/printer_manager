package src.server.core;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    protected Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    // создаём обработчик клиента, который наследуется от класса Thread, что позволяет реализовать многопоточность и
    // обрабатывать каждого клиента в отдельном потоке
    //
    // in, out - для ввода вывода данных
    //
    // start() - запускает поток
    //
    // в методе run() - пишем то как наш сервер должен обрабатывать запрос
    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    public void run() {

    }

}
