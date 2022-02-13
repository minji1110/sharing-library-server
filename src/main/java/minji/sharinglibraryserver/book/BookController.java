package minji.sharinglibraryserver.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minji.sharinglibraryserver.common.response.CommonResponse;
import minji.sharinglibraryserver.common.response.ListResponse;
import minji.sharinglibraryserver.common.response.ResponseService;
import minji.sharinglibraryserver.common.response.SingleResponse;
import minji.sharinglibraryserver.kakao.KakaoBookDocument;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private final ResponseService responseService;

    //책 등록
    @PostMapping(value="/book/{userId}")
    public SingleResponse<Book> saveBook(@PathVariable long userId, @ModelAttribute KakaoBookDocument kakaoBookDocument){
        return responseService.getSingleResponse(bookService.saveBook(userId, kakaoBookDocument));
    }

    //책정보 추가
    @PatchMapping(value="/book/{bookId}")
    public SingleResponse<Book> addBookInfo(@PathVariable long bookId, @RequestParam int score,
                                            @RequestParam(required=false)LocalDate startDt,
                                            @RequestParam(required = false) LocalDate endDt){
        return responseService.getSingleResponse(bookService.addBookInfo(bookId,score,startDt,endDt));
    }

    //책 단건 조회
    @GetMapping(value = "/book/{bookId}")
    public SingleResponse<Book> getBookById(@PathVariable long bookId){
         SingleResponse<Book> result=responseService.getSingleResponse(bookService.getBookById(bookId));
         return result;
    }

    //책 목록 조회
    @GetMapping(value = "/books/{userId}")
    public ListResponse<Book> getBookList(@PathVariable long userId){
        return responseService.getListResponse(bookService.getBooksByUser(userId));
    }

    //책 삭제
    @DeleteMapping(value = "/book/{bookId}")
    public CommonResponse deleteBookById(@PathVariable long bookId){
        bookService.deleteBookById(bookId);
        return responseService.getSuccessResponse();
    }
}


