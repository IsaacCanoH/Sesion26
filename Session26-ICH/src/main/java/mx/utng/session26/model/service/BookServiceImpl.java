package mx.utng.session26.model.service;

import mx.utng.session26.model.dao.IBookDao;
import mx.utng.session26.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional
    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Transactional
    @Override
    public void deleteBook(Long id) {
        bookDao.deleteBook(id);
    }
}
