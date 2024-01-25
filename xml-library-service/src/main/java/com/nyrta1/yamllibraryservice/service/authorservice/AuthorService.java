package com.nyrta1.yamllibraryservice.service.authorservice;

import com.nyrta1.yamllibraryservice.model.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<Author> findAll();
    Author findByUUID(UUID uuid);
    UUID save(Author author);
    Author update(UUID uuid, Author author);
    int deleteByUUID(UUID uuid);
}
