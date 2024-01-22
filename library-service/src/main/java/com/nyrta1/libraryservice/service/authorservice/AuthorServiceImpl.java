package com.nyrta1.libraryservice.service.authorservice;

import com.nyrta1.libraryservice.model.Authors;
import com.nyrta1.libraryservice.repository.AuthorsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
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
    public Authors findByUUID(UUID uuid) {
        return authorsRepository
                .findByAuthorUUID(uuid)
                .orElse(null);
    }

    @Override
    public UUID save(Authors author) {
        Authors savedAuthor = authorsRepository.saveAndFlush(author);
        return savedAuthor.getAuthorUUID();
    }
}
