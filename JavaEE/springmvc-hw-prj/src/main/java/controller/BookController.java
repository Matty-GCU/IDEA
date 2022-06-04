package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Book;
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
        String[] bookshelfNames = {"教材", "文学", "生活"};
        int[] bookshelfId = {1, 2, 3};
        model.addAttribute("bookshelfNames", bookshelfNames);
        model.addAttribute("bookshelfId", bookshelfId);
        return "book";
    }
    
    @RequestMapping("/getByName")
    public String getByName(String name, Model model) {
        List<Book> books = bookService.selectBookByName("%" + name + "%");
        model.addAttribute("result", books);
        return "result1";
    }
    
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Book> books = bookService.selectAllBooks();
        model.addAttribute("result", books);
        return "result1";
    }
    
    @RequestMapping("/add")
    public String add(Book book, Model model) {
        // 数据库里没有该书架，所以新增书籍之前应该先新增该书架，即连同关联对象一起写入数据库
        // 如果数据库里已有该书架，把book对象的bookShelf属性设为空，就不会连同关联对象一起写入数据库。
        if(bookShelfService.getById(book.getBookShelf().getId()) != null) {
            // 不过这样做的话，当书是要放到旧书架上时，书的记录会少了shelfId这个外键，但不这样做又很容易导致重复插入失败，所以说治标不治本。
            // 如何从根本上解决问题？改SQL或该service层
            book.setBookShelf(null);
        }
        int lineAffected = bookService.insertBook(book);
        String resultMessage = lineAffected + "行受影响，";
        resultMessage += (lineAffected == 0) ? "添加失败！" : "添加成功";
        model.addAttribute("result", resultMessage);
        return "result2";
    }
    
    /**
     * @param book 绑定请求参数输入值到领域模型
     */
    @RequestMapping("/update")
    public String update(Book book, Model model) {
        // 只有当该书籍已存在时，才可以修改成功
        int lineAffected = bookService.updateBook(book);
        String resultMessage = lineAffected + "行受影响，";
        resultMessage += (lineAffected == 0) ? "修改失败！" : "修改成功";
        model.addAttribute("result", resultMessage);
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
