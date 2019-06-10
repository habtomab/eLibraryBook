package com.mum.cs.cs425.elibrary.serviceImp;

import com.mum.cs.cs425.elibrary.repository.BookRepository;
import com.mum.cs.cs425.elibrary.model.Book;
import com.mum.cs.cs425.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book retrieveSingleBook(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }


    @Override
    public List<Book> retrieveAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
