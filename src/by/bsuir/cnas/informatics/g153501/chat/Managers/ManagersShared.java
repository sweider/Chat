package by.bsuir.cnas.informatics.g153501.chat.Managers;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by alex on 11/23/14.
 */
public class ManagersShared {
    @PersistenceContext
    static EntityManager em = Persistence.createEntityManagerFactory("ChatPersistence").createEntityManager();
}
