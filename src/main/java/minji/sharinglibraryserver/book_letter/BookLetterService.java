package minji.sharinglibraryserver.book_letter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minji.sharinglibraryserver.book.Book;
import minji.sharinglibraryserver.book.BookJpaRepo;
import minji.sharinglibraryserver.common.exception.InvalidateBookException;
import minji.sharinglibraryserver.common.exception.InvalidateBookLetterException;
import minji.sharinglibraryserver.common.exception.InvalidateUserException;
import minji.sharinglibraryserver.user.User;
import minji.sharinglibraryserver.user.UserJpaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BookLetterService {
    private final BookLetterJpaRepo bookLetterJpaRepo;
    private final BookJpaRepo bookJpaRepo;
    private final UserJpaRepo userJpaRepo;

    //글귀 등록(by 사진)
    public BookLetter saveBookLetterByPhoto(long userId, long bookId, MultipartFile imageFile) {
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        Book book=bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);

        String content="";
        /**
         * google vision api 이용해서 ocr
         */
        BookLetter bookLetter=BookLetter.builder()
                .user(user)
                .book(book)
                .letterContent(content)
                .build();

        return bookLetterJpaRepo.save(bookLetter);
    }

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

    // 글귀 단건 조회
    public BookLetter getOneBookLetter(long letterId) {
        return bookLetterJpaRepo.findByIdWithBook(letterId).orElseThrow(InvalidateBookLetterException::new);
    }

    //글귀 수정
    public BookLetter modifyBookLetter(long bookLetterId, String content) {
        //fixme 오류 새로 만들기
        BookLetter bookLetter=bookLetterJpaRepo.findById(bookLetterId).orElseThrow(InvalidateBookException::new);
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
        return bookLetterJpaRepo.findBookLettersByUserWithBook(user);
    }

    //책별 글귀목록 조회(본인이 저장한것만)
    public List<BookLetter> getBookLettersByBook(long userId,long bookId){
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        Book book=bookJpaRepo.findById(bookId).orElseThrow(InvalidateBookException::new);

        return bookLetterJpaRepo.findBookLettersByUserAndBook(user,book);
    }

}
