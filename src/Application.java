package src;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import src.server.core.Server;
import src.server.core.ServerParameters;

@SpringBootApplication
public class Application {

    // главны класс приложения, где оно, собственно, запускается
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // метод для запуска с командной строки
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Server server = new Server(new ServerParameters(2134));
            server.run();
        };
    }

}
