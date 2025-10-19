package net.engineeringdigest.journalApp.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//plain old java object (POJ0)
@Document(collection = "journal_entries") //will tell spring k mongodb collection se mapped entry row
public class JournalEntry {

    @Id //primary key
    private ObjectId id;

    private String title;

    private String content;

    private LocalDateTime date;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}


//@Id --->primary key(by default objectId, agar nai apya to mongodb will add according to itself !
// if apsu to will convert to string (only for those that can be autoconverted baki write inside ""
