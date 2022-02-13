package minji.sharinglibraryserver.book_letter;

import minji.sharinglibraryserver.book.Book;
import minji.sharinglibraryserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookLetterJpaRepo extends JpaRepository<BookLetter,Long> {
    List<BookLetter> findBookLettersByUserAndBook(User user, Book book);
    List<BookLetter> findBookLettersByUser(User user);
}
