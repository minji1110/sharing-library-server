package minji.sharinglibraryserver.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minji.sharinglibraryserver.common.exception.InvalidateBookException;
import minji.sharinglibraryserver.common.exception.InvalidateUserException;
import minji.sharinglibraryserver.kakao.KakaoBookDocument;
import minji.sharinglibraryserver.user.User;
import minji.sharinglibraryserver.user.UserJpaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final UserJpaRepo userJpaRepo;
    private final BookJpaRepo bookJpaRepo;

    //책 저장
    public Book saveBook(long userId, KakaoBookDocument kakaoBookDocument){
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        Book book= Book.builder()
                .bookTitle(kakaoBookDocument.getTitle())
                .bookAuthor(kakaoBookDocument.getAuthors().get(0))
                .bookIsbn(kakaoBookDocument.getIsbn())
                .bookSummary(kakaoBookDocument.getContents())
                .bookImageUrl(kakaoBookDocument.getThumbnail())
                .user(user)
                .build();

        return bookJpaRepo.save(book);
    }

    //책 저장 이후 별점,시작일,종료일 등록
    public Book addBookInfo(long bookId, int score, LocalDate startDt, LocalDate endDt) {
        Book book=bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);
        book.addBookInfo(score,startDt,endDt);
        return book;
    }

    //책 단건조회
    public Book getBookById(long bookId) {
        return bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);
    }

    //사용자별 책 목록 조회
    public List<Book> getBooksByUser(long userId){
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);

        List<Book> bookList=bookJpaRepo.findBooksByUser(user);
        return bookList;
    }

    //책 삭제
    public void deleteBookById(long bookId){
        Book book=bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);
        bookJpaRepo.delete(book);
    }

}
