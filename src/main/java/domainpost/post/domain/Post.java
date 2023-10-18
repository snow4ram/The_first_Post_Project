package domainpost.post.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(columnDefinition = "DATE")
    private LocalDate creation_date;

    @Column(nullable = false)
    private String writing;

    public Post() {
    }

    public Post(String title, String writer, LocalDate creation_date, String writing) {
        this.title = title;
        this.writer = writer;
        this.creation_date = creation_date;
        this.writing = writing;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", creation_date=" + creation_date +
                ", writing='" + writing + '\'' +
                '}';
    }
}
