package learn.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private MessageRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

       // repo.deleteAll();

        repo.save(new Message("Hello"));
        repo.save(new Message("Guten Tag"));

        System.out.println("Fetching all messages");
        for (Message msg: repo.findAll()){
            System.out.println(msg);
        }

        System.out.println("=============================");

        for(Message msg: repo.findByMsg("Guten Tag")){
            System.out.println(msg);
        }

    }
}
