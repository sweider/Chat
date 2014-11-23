package by.bsuir.cnas.informatics.g153501.chat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alex on 11/23/14.
 */
@Entity
@Table(name = "users")
@NamedEntityGraphs(value = {
        @NamedEntityGraph(name = "lightChatUserGraph", attributeNodes = {
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(value = "lastName"),
                @NamedAttributeNode(value = "nickName"),
                @NamedAttributeNode(value = "age")
        }),
        @NamedEntityGraph(name = "ChatUserOwnClientSideInfoGraph",
            attributeNodes = {
                @NamedAttributeNode(value = "id"),
                @NamedAttributeNode(value = "name"),
                @NamedAttributeNode(value = "lastName"),
                @NamedAttributeNode(value = "nickName"),
                @NamedAttributeNode(value = "age"),
                @NamedAttributeNode(value = "discussions", subgraph = "userDiscussions")
            },
            subgraphs = {
                @NamedSubgraph(name = "userDiscussions",
                attributeNodes = {
                    @NamedAttributeNode(value = "topic")
                })
            }
        )


})

public class ChatUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Nick")
    private String nickName;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Password")
    private String encryptedPassword;

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    @OneToMany(cascade = CascadeType.PERSIST,  mappedBy = "author")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "topicStarter")
    private List<Discussion> startedDiscussions;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Discussion> discussions;

    public ChatUser(String name, String lastName, String nickName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.messages = new ArrayList<>();
        this.startedDiscussions = new ArrayList<>();
    }

    protected ChatUser(){}

    public Long getId() {
        return id;
    }

    public List<Message> getMessages(){
        return this.messages;
    }
    public void addMessage(Message message){
        this.messages.add(message);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public Integer getAge() {
        return age;
    }

    public Message createMessage(String text){
        Message message = new Message(this, text, new Date());
        return message;
    }
}
