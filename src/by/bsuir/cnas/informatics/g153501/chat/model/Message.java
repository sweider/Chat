package by.bsuir.cnas.informatics.g153501.chat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 11/23/14.
 */
@Entity
@Table(name = "Messages")
@NamedEntityGraphs(value = {
    @NamedEntityGraph(name = "displayingMessageGraph",
        attributeNodes = {
            @NamedAttributeNode(value = "text"),
            @NamedAttributeNode(value = "creationDate"),
            @NamedAttributeNode(value = "author", subgraph = "messageAuthor")
        },
        subgraphs = {
            @NamedSubgraph(name = "messageAuthor", attributeNodes = {
                @NamedAttributeNode(value = "nickName")
            })
        }
    )
})
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private ChatUser author;

    @ManyToOne
    @JoinColumn(name = "discussion", referencedColumnName = "id")
    private Discussion discussion;
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public Message(ChatUser author, String text, Date creationDate) {
        this.text = text;
        this.creationDate = creationDate;
        this.author = author;
    }

    protected Message(){ }

    public Long getId() {
        return id;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public String getText() {
        return text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }
}
