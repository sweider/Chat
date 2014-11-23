package by.bsuir.cnas.informatics.g153501.chat.services;

import java.util.HashMap;

/**
 * Created by alex on 11/23/14.
 */
public class UsersSessionsStorage {
    private final HashMap<Integer, RemoteAddress> connectedUsers;

    public UsersSessionsStorage() {
        this.connectedUsers = new HashMap<>();
    }


}
