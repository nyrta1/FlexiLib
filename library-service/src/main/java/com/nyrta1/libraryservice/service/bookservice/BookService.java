package com.nyrta1.libraryservice.service.bookservice;

import com.nyrta1.libraryservice.model.Books;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Books> findAll();
    Books findByUUID(UUID uuid);
    UUID save(Books book);
}
