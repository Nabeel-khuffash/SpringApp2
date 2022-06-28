package com.example.demo2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Comment extends Auditable{
    @Id @GeneratedValue
    private Long id;
    @NonNull
    private String body;
    @ManyToOne
    private Link link;

    public Comment(@NonNull String body, Link link) {
        this.body = body;
        this.link = link;
    }

    //convert the Comment to string with its link, without going in infinite loop
    public String toString2() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", link=" + link.toString3() +
                '}';
    }

    //convert the Comment to string without its link
    public String toString3() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}
