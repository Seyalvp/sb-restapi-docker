package learn.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private MessageRepository repo;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Message> index(@PathVariable(required = false) String id) {

        if (null == id) {
            return ResponseEntity.ok().body(new Message("Hello World"));
        }

        Optional<Message> msg = repo.findById(id);
        if (msg.isPresent()) return ResponseEntity.ok().body(msg.get());

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @RequestMapping(value = "/")
    public ResponseEntity<List<Message>> getMessagesByContent(@RequestParam(required = false) String msgContent) {

        if (null == msgContent) {
            List<Message> allMsgs = repo.findAll();
            return ResponseEntity.ok().body(allMsgs);
        } else {
            List<Message> allMsgs = repo.findByMsg(msgContent);
            return ResponseEntity.ok().body(allMsgs);
        }
    }
}
