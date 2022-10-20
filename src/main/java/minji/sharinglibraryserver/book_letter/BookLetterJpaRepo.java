package minji.sharinglibraryserver.book_letter;

import minji.sharinglibraryserver.book.Book;
import minji.sharinglibraryserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookLetterJpaRepo extends JpaRepository<BookLetter,Long> {
    List<BookLetter> findBookLettersByUserAndBook(User user, Book book);

    @Query(value = "select bl from BookLetter bl join fetch bl.book where bl.user=:user")
    List<BookLetter> findBookLettersByUserWithBook(@Param("user") User user);

    @Query(value = "select bl from BookLetter bl join fetch bl.book where bl.letterId=:letterId")
    Optional<BookLetter> findByIdWithBook(@Param("letterId") long letterId);
}
