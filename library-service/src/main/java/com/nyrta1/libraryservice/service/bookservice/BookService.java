package com.nyrta1.libraryservice.service.bookservice;

import com.nyrta1.libraryservice.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> findAll();
    Book findByUUID(UUID uuid);
    UUID save(Book book);
}
