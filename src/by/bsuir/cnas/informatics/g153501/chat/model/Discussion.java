package by.bsuir.cnas.informatics.g153501.chat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by alex on 11/23/14.
 */
@Entity
@Table(name = "discussions")
public class Discussion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Topic")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "topicStarter", referencedColumnName = "id")
    private ChatUser topicStarter;

    @ManyToMany(mappedBy = "discussions")
    private List<ChatUser> chatParticipants;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discussion")
    private List<Message> messages;

    public Discussion(ChatUser topicStarter, ChatUser... participants) {
        this.topicStarter = topicStarter;
        this.chatParticipants = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.chatParticipants.addAll(Arrays.asList(participants));
    }

    public String getTopic() {
        return topic;
    }

    public ChatUser getTopicStarter() {
        return topicStarter;
    }

    public List<ChatUser> getChatParticipants() {
        return chatParticipants;
    }

    public List<Message> getMessages() {
        return messages;
    }

}
