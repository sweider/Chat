package by.bsuir.cnas.informatics.g153501.chat.Managers;

import by.bsuir.cnas.informatics.g153501.chat.model.ChatUser;
import by.bsuir.cnas.informatics.g153501.chat.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by alex on 11/23/14.
 */
public class ChatUserManager {
    @PersistenceContext
    EntityManager em;

    public void setUp(){
        this.em = ManagersShared.em;
    }

    public ChatUser createUserWithMessage(){
        ChatUser user = new ChatUser("user1", "useruser", "nick", 10);
        Message m  = new Message(user, "text", new Date());
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        user.addMessage(m);
        em.persist(user);
        transaction.commit();
        return user;
    }
}
