package learn.docker;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {

    public List<Message> findByMsg(String msg);

}
