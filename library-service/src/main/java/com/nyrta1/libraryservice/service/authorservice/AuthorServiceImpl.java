package com.nyrta1.libraryservice.service.authorservice;

import com.nyrta1.libraryservice.model.Authors;
import com.nyrta1.libraryservice.model.Books;
import com.nyrta1.libraryservice.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

class AuthorServiceImpl implements AuthorService {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public List<Authors> findAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors findById(UUID uuid) {
        return authorsRepository
                .findByAuthorID(uuid)
                .orElse(null);
    }

    @Override
    public UUID save(Authors author) {
        Authors savedAuthor = authorsRepository.saveAndFlush(author);
        return savedAuthor.getAuthorID();
    }
}
