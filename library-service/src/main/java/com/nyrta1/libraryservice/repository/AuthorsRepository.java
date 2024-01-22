package com.nyrta1.libraryservice.repository;

import com.nyrta1.libraryservice.model.Authors;
import com.nyrta1.libraryservice.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorsRepository
        extends JpaRepository<Authors, UUID> {
}
