package com.example.startProject.controller;

import com.example.startProject.model.Book;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class BookController {

    private HashMap<Integer, Book>  bookHashMap =  new HashMap<Integer, Book>();
    private static Logger Logger  = LoggerFactory.getLogger(BookController.class);

//     insertBook - PostMethod - RequestBody
//    updateBook - PutMethod - RequestBody
//    GetBookDetails - GetMethod - RequestParam - book id
//    delete Book - DeleteMethod - RequestParam - book id
//    getAllBooks - Get -  return book list

   @PostMapping("/insert_book")
    public String insertBook(@RequestBody Book book){
       Logger.info("Book coming for inserted ", book);
       if(bookHashMap.containsKey(book.getId()))
       {
           Logger.error("Book id already exists!!");
           return "Book id already Present!!";
       }

       bookHashMap.put(book.getId(),book);
       return "Book Inserted Successfully";
   }


   @GetMapping("/book/{bookId}")
    public Book getBookByBookId(@PathVariable ("bookId") int bookId)
   {
       Logger.info("bookid received : {}", bookId);
       return bookHashMap.get(bookId);

   }


   @GetMapping("/books/all")
    public List<Book> getBooks(){

       return bookHashMap.values().stream().collect(Collectors.toList());

   }


@PutMapping("updateBook")
    public Book updateBook(@RequestBody Book book)
{
    bookHashMap.put(book.getId(), book);
    return bookHashMap.get(book.getId());
}


@DeleteMapping("/deleteBook/{id}")
    public String deleteBookById(@PathVariable ("id") int bookId)
{
    bookHashMap.remove(bookId);
    return "Book Deleted Sucessfully!!";
}

}
