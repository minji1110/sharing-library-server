package minji.sharinglibraryserver.book;

import minji.sharinglibraryserver.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepo extends JpaRepository<Book,Long> {
    List<Book> findBooksByUser(User user);
}
