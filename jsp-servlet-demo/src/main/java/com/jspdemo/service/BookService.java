package com.jspdemo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.jspdemo.model.Book;

@Service
public interface BookService {
    Collection<Book> getBooks();

    Book addBook(Book book);
}