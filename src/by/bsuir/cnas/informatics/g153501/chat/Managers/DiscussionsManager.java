package by.bsuir.cnas.informatics.g153501.chat.Managers;

import by.bsuir.cnas.informatics.g153501.chat.model.Discussion;
import by.bsuir.cnas.informatics.g153501.chat.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by alex on 11/23/14.
 */
public class DiscussionsManager {
    @PersistenceContext
    EntityManager em;
    public void setUp(){
        this.em = ManagersShared.em;
    }

    public Message addMessageToDiscussion(int discussionId, Message message){
        this.em.getTransaction().begin();
        Discussion discussion = this.em.find(Discussion.class, discussionId);
        discussion.getMessages().add(message);
        message.setDiscussion(discussion);
        this.em.getTransaction().commit();
        return message;
    }
}
