package com.nyrta1.libraryservice.repository;

import com.nyrta1.libraryservice.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BooksRepository
        extends JpaRepository<Books, UUID> {
    Optional<Books> findByBookUUID(UUID uuid);
}
