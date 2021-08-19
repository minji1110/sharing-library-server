package minji.sharinglibraryserver.book;

import lombok.Builder;
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


    //책 저장
    public Book saveBook(long userId, KAKAOBookSearchDto kakaoBookSearchDto){
        User user=userJpaRepo.getById(userId);
        Book book= Book.builder()
                .bookTitle(kakaoBookSearchDto.title)
                .bookAuthor(kakaoBookSearchDto.authors)
                .bookIsbn(kakaoBookSearchDto.isbn)
                .bookSummary(kakaoBookSearchDto.contents)
                .user(user)
                .build();

        return bookJpaRepo.save(book);
    }

    //사용자별 책 목록 조회
    public List<Book> getBooksByUser(long userId){
        User user=userJpaRepo.getById(userId);
        List<Book> bookList=bookJpaRepo.findBooksByUser(user);
        return bookList;
    }
}
