package com.nyrta1.libraryservice.service.authorservice;

import com.nyrta1.libraryservice.model.Author;
import com.nyrta1.libraryservice.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorsRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorsRepository.findAll();
    }

    @Override
    public Author findByUUID(UUID uuid) {
        return authorsRepository
                .findByAuthorUUID(uuid)
                .orElse(null);
    }

    @Override
    public UUID save(Author author) {
        Author savedAuthor = authorsRepository.saveAndFlush(author);
        return savedAuthor.getAuthorUUID();
    }
}
