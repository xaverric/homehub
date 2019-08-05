package cz.homehub.init;

import cz.homehub.entity.Message;
import cz.homehub.entity.User;
import cz.homehub.repository.MessageDao;
import cz.homehub.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Order(3)
public class MessageDataset implements Dataset {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageDao messageDao;

    @Override
    public void load() {
        createMessage("Welcome to HomeHub", "Welcome to home hub portal!", LocalDateTime.now(), userDao.findByUserName("jilekda").get());
    }

    private void createMessage(String subject, String text, LocalDateTime created, User author){
        Message message = new Message();
        message.setSubject(subject);
        message.setText(text);
        message.setCreated(created);
        message.setAuthor(author);
        messageDao.save(message);
    }
}
