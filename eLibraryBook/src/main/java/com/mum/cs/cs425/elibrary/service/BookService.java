package com.mum.cs.cs425.elibrary.service;

import com.mum.cs.cs425.elibrary.model.Book;

import java.util.List;

public interface BookService {
    public Book save(Book book);
    public Book retrieveSingleBook(Integer id);
    public List<Book> retrieveAllBooks();
    public void delete(Integer id);

}
