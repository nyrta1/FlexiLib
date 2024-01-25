package com.nyrta1.yamllibraryservice.service.bookservice;

import com.nyrta1.yamllibraryservice.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> findAll();
    Book findByUUID(UUID uuid);
    UUID save(Book book);
    Book update(UUID uuid, Book book);
    int deleteByUUID(UUID uuid);
}
