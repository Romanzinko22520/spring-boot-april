package com.roman.springbootapril.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = {"user"})
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private User user;
}
