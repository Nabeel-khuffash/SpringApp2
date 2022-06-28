package com.example.demo2.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Vote extends Auditable{
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @Column(nullable = false)
    private int vote;
    @ManyToOne
    private Link link;
}
