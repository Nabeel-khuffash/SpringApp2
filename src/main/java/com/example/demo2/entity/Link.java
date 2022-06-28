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

}
