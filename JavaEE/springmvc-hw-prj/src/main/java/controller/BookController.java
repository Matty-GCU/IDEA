package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pojo.Book;
import pojo.BookShelf;
import service.BookService;
import service.BookShelfService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @Autowired
    BookShelfService bookShelfService;
    
    @RequestMapping
    public String toBookPage(Model model) {
        //这里的new Book()就是form-backing object！
        model.addAttribute("book", new Book());
        return "book";
    }
    
    @RequestMapping("/getByName")
    public String getByName(String name, Model model) {
        List<Book> books = bookService.selectBookByName("%" + name + "%");
        model.addAttribute("result", books);
        model.addAttribute("back", "book.jsp");
        return "result1";
    }
    
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Book> books = bookService.selectAllBooks();
        model.addAttribute("result", books);
        model.addAttribute("back", "book.jsp");
        return "result1";
    }
    
    @RequestMapping("/add")
    public String add(Book book, int bookShelfId, String bookShelfName, Model model) {
        BookShelf bookShelf = bookShelfService.getById(bookShelfId);
        // 数据库里没有该书架，所以新增书籍之前应该先新增该书架
        if(bookShelf == null) {
            // 连同关联对象一起写入数据库
            book.setBookShelf(new BookShelf(bookShelfId, bookShelfName, null));
        }
        // 数据库里已有该书架，把book对象的bookShelf属性设为空，就不会连同关联对象一起写入数据库。
        else {
            book.setBookShelf(null);
        }
        int lineAffected = bookService.insertBook(book);
        String resultMessage = lineAffected + "行受影响，";
        resultMessage += (lineAffected == 0) ? "添加失败！" : "添加成功";
        model.addAttribute("result", resultMessage);
        model.addAttribute("back", "book.jsp");
        return "result2";
    }
    
    /**
     * @param book 绑定请求参数输入值到邻域模型
     */
    @RequestMapping("/update")
    public String update(Book book, Model model) {
        // 只有当该书籍已存在时，才可以修改成功
        int lineAffected = bookService.updateBook(book);
        String resultMessage = lineAffected + "行受影响，";
        resultMessage += (lineAffected == 0) ? "修改失败！" : "修改成功";
        model.addAttribute("result", resultMessage);
        model.addAttribute("back", "book.jsp");
        return "result2";
    }

    @RequestMapping("/delete")
    public String update(int id, Model model) {
        int lineAffected = bookService.deleteById(id);
        String resultMessage = lineAffected + "行受影响，";
        resultMessage += (lineAffected == 0) ? "删除失败！" : "删除成功";
        model.addAttribute("result", resultMessage);
        return "result2";
    }
}
