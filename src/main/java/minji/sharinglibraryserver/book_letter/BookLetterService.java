package minji.sharinglibraryserver.book_letter;

import lombok.RequiredArgsConstructor;
import minji.sharinglibraryserver.book.Book;
import minji.sharinglibraryserver.book.BookJpaRepo;
import minji.sharinglibraryserver.common.exception.InvalidateBookException;
import minji.sharinglibraryserver.common.exception.InvalidateUserException;
import minji.sharinglibraryserver.user.User;
import minji.sharinglibraryserver.user.UserJpaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLetterService {
    private final BookLetterJpaRepo bookLetterJpaRepo;
    private final BookJpaRepo bookJpaRepo;
    private final UserJpaRepo userJpaRepo;

    //글귀 등록(by 사진)

    //글귀 등록(직접입력)
    public BookLetter saveBookLetter(long userId, long bookId, String content){
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        Book book=bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);

        BookLetter bookLetter=BookLetter.builder()
                .user(user)
                .book(book)
                .letterContent(content)
                .build();

        return bookLetterJpaRepo.save(bookLetter);
    }

    //글귀 수정
    public BookLetter modifyBookLetter(long bookLetterId, String content) {
        BookLetter bookLetter=bookLetterJpaRepo.getById(bookLetterId);
        bookLetter.updateLetterContent(content);

        return bookLetter;
    }

    //글귀 삭제
    public void deleteBookLetter(long bookLetterId){
        bookLetterJpaRepo.deleteById(bookLetterId);
    }

    //사용자별 글귀목록 전체조회
    public List<BookLetter> getBookLettersByUser(long userId){
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        return bookLetterJpaRepo.findBookLettersByUser(user);
    }

    //책별 글귀목록 조회(본인이 저장한것만)
    public List<BookLetter> getBookLettersByBook(long userId,long bookId){
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        Book book=bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);

        return bookLetterJpaRepo.findBookLettersByUserAndBook(user,book);
    }
}
