package minji.sharinglibraryserver.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minji.sharinglibraryserver.common.response.ListResponse;
import minji.sharinglibraryserver.common.response.ResponseService;
import minji.sharinglibraryserver.common.response.SingleResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private final ResponseService responseService;

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

    //책 등록
    @PostMapping(value="/book/{userId}")
    public Book saveBook(@PathVariable long userId, @ModelAttribute KAKAOBookSearchDto kakaoBookSearchDto){
        return bookService.saveBook(userId,kakaoBookSearchDto);
    }
}


