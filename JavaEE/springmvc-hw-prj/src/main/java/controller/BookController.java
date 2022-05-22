package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Book;
import service.BookService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @RequestMapping("/all")
    public String getByName(Model model) {
        List<Book> books = bookService.selectAllBooks();
        model.addAttribute("books", books);
        return "book";
    }
    
    @RequestMapping("/getByName")
    @GetMapping
    public String getByName(String bookname, Model model) {
        System.out.println(bookname);
        return "book";
    }
}
