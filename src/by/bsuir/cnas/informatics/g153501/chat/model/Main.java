package by.bsuir.cnas.informatics.g153501.chat.model;

import by.bsuir.cnas.informatics.g153501.chat.Managers.ChatUserManager;

/**
 * Created by alex on 11/23/14.
 */
public class Main {
    public static void main(String[] args){
        Message m;// =new MessagesManager().createSampleMessage();
        ChatUserManager userManager = new ChatUserManager();
        userManager.setUp();
        ChatUser user = userManager.createUserWithMessage();
        m = user.getMessages().get(0);
        System.out.println(new StringBuilder("User[name: ").append(user.getName()).append("]"));
        System.out.println("text is: " +  m.getText());
    }
}
