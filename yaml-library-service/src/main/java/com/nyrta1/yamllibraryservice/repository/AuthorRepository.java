package com.nyrta1.yamllibraryservice.repository;

import com.nyrta1.yamllibraryservice.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository
        extends JpaRepository<Author, UUID> {
    Optional<Author> findByAuthorUUID(UUID uuid);
    int deleteByAuthorUUID(UUID uuid);
}
