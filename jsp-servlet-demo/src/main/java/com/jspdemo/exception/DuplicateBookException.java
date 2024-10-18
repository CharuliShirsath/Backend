package com.jspdemo.exception;

import com.jspdemo.model.Book;


public class DuplicateBookException extends RuntimeException 
{
	private final Book book;

	public DuplicateBookException(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}



}