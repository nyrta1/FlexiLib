package com.nyrta1.libraryservice.service.authorservice;

import com.nyrta1.libraryservice.model.Authors;
import com.nyrta1.libraryservice.model.Books;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<Authors> findAll();
    Authors findByUUID(UUID uuid);
    UUID save(Authors author);
}
