package mx.utng.session26.model.dao;

import mx.utng.session26.model.entity.Book;

import java.util.List;

public interface IBookDao {
    List<Book> listBooks();
    void saveBook(Book book);
    Book getBookById(Long id);
    void deleteBook(Long id);
}
