package com.example.javapentalog.SecondModule.repository.matches;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Accessors(chain = true)
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String matchName;

    private String prize;
}
