package minji.sharinglibraryserver.book;

import lombok.RequiredArgsConstructor;
import minji.sharinglibraryserver.user.User;
import minji.sharinglibraryserver.user.UserJpaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final UserJpaRepo userJpaRepo;
    private final BookJpaRepo bookJpaRepo;

    public List<Book> getBooksByUser(long userId){
        User user=userJpaRepo.getById(userId);
        List<Book> bookList=bookJpaRepo.findBooksByBookReader(user);
        return bookList;
    }
}
