package com.nyrta1.yamllibraryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="authorUUID", insertable = false, updatable = false, nullable = false)
    private UUID authorUUID;

    @Column(nullable = false)
    @Size(min = 3, max = 255)
    private String authorName;
}
