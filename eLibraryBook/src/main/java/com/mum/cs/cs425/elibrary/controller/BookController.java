package com.mum.cs.cs425.elibrary.controller;

import com.mum.cs.cs425.elibrary.model.Book;
import com.mum.cs.cs425.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/homeApp",method = RequestMethod.GET)
    public String display(){
        return "home/applicationForm";
    }
    // this will post a book
    @RequestMapping(value = "/book/post", method = RequestMethod.POST)
    public String edit(@ModelAttribute("book") Book book)  {
       // I am saving book
        Book book1 = bookService.save(book);
        return "redirect:/books";
    }
    //

    //

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public ModelAndView books(){
        // retrieve list of books from database
        List<Book> books = bookService.retrieveAllBooks();
        // we are creating ModelAndView object will store view and data
        ModelAndView modelAndView = new ModelAndView();
        // we are adding an object books(ListOfBooks) to our ModelAndView - >attribute name "books"
        modelAndView.addObject("books", books);
        // we are adding an html file to our ModelAndView
        modelAndView.setViewName("book/list");
        // return our modelAndView
        return modelAndView;
    }
///----------------------------------------------end of home work=-----------------------
    // display single book by given book id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("book", bookService.retrieveSingleBook(id));
        modelAndView.setViewName("book/singlebook");
        return modelAndView;
    }
   // book delete by id
    @RequestMapping(value="/book/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id){
        bookService.delete(id);
        return "redirect:/books";
    }
}
