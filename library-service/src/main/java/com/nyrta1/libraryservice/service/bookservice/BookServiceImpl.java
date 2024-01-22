package com.nyrta1.libraryservice.service.bookservice;

import com.nyrta1.libraryservice.model.Books;
import com.nyrta1.libraryservice.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class BookServiceImpl implements BookService{
    private final BooksRepository booksRepository;

    @Autowired
    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Books> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Books findByUUID(UUID uuid) {
        return booksRepository
                .findById(uuid)
                .orElse(null);
    }

    @Override
    public UUID save(Books book) {
        Books savedBook = booksRepository.saveAndFlush(book);
        return savedBook.getBookUUID();
    }
}
