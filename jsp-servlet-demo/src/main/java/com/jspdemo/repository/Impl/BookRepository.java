package com.jspdemo.repository.Impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {
    Collection<BookData> findAll();

    Optional<BookData> findById(String isbn);

    BookData add(BookData book);
}