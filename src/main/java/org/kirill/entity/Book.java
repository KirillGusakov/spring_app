package org.kirill.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Field shouldn't be empty") //VALID
    private String name;

    @Column(name = "author")
    @NotEmpty(message = "There must be an author") //VALID
    private String author;

    @Column(name = "year")
    @NotNull(message = "There must be an year of publishing") //VALID
    private LocalDate year;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;


    public Book(String name, String author, LocalDate year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
}

