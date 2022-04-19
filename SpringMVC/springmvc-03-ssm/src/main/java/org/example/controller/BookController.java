package org.example.controller;

import org.example.pojo.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> bookList = bookService.selectAllBooks();
        model.addAttribute("bookList", bookList);
        return "books";
    }
    
    @RequestMapping("/books/toAddBookForm")
    public String toAddBookForm() {
        return "addBookForm";
    }
    
    @PostMapping("/books")
    public String insertBook(Book book) {
        bookService.insertBook(book);
        return "redirect:/books";
    }
    
    @RequestMapping("/books/toUpdateBookForm")
    public String toUpdateBookForm(int id, Model model) {
        Book book = bookService.selectBookById(id);
        model.addAttribute("book", book);
        return "updateBookForm";
    }
    
    @RequestMapping("/books/update")
    public String updateBook(Book book) {
        bookService.updateBookById(book);
        return "redirect:/books";
    }
    
    @RequestMapping("/books/delete")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
    
}
