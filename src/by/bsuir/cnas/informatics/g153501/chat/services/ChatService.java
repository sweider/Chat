package by.bsuir.cnas.informatics.g153501.chat.services;

import by.bsuir.cnas.informatics.g153501.chat.Managers.DiscussionsManager;
import by.bsuir.cnas.informatics.g153501.chat.model.Message;

/**
 * Created by alex on 11/23/14.
 */
public class ChatService {
    private DiscussionsManager discussionsManager;

    public ChatService() {
        this.discussionsManager = new DiscussionsManager();
        this.discussionsManager.setUp();
    }

    public void addMessageToDiscussion(int discussionId, Message message){
        this.discussionsManager.addMessageToDiscussion(discussionId, message);
    }
}
