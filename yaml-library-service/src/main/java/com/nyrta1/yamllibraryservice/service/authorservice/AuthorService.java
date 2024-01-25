package com.nyrta1.xmllibraryservice.service.authorservice;

import com.nyrta1.xmllibraryservice.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<Author> findAll();
    Author findByUUID(UUID uuid);
    UUID save(Author author);
    Author update(UUID uuid, Author author);
    int deleteByUUID(UUID uuid);
}
