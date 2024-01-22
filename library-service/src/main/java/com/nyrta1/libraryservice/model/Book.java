package com.nyrta1.libraryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="authorUUID", insertable = false, updatable = false, nullable = false)
    private UUID bookUUID;

    @Column(nullable = false)
    @Size(min = 3, max = 255)
    private String title;

    @Column(nullable = false)
    @Size(min = 3, max = 255)
    private String isbn;

    @Column(nullable = false)
    private Integer publishedYear;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;
}
