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
}
