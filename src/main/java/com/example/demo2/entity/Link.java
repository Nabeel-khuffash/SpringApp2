package com.example.demo2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Link extends Auditable{

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String url;
    @NonNull
    private String title;
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "link")
    private List<Vote> votes = new ArrayList<>();

    public Link(@NonNull String title, @NonNull String url) {
        this.url = url;
        this.title = title;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    //convert the Link to string with its comments, without going in infinite loop
    public String toString2() {
        
        String commentsString="";
        for (Comment i: comments) {
            commentsString+=i.toString3();
        }
        
        return "Link{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", comments=" + commentsString +
                ", votes=" + votes +
                '}';
    }

    //convert the link to string without its comments
    public String toString3() {

        return "Link{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", votes=" + votes +
                '}';
    }

}
