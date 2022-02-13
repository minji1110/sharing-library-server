package minji.sharinglibraryserver.book_letter;

import lombok.RequiredArgsConstructor;
import minji.sharinglibraryserver.common.response.CommonResponse;
import minji.sharinglibraryserver.common.response.ListResponse;
import minji.sharinglibraryserver.common.response.ResponseService;
import minji.sharinglibraryserver.common.response.SingleResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookLetterController {
    private final BookLetterService bookLetterService;
    private final ResponseService responseService;

    //글귀 등록(by 사진)

    //글귀 등록(직접입력)
    @PostMapping(value = "/{userId}/bookletter/{bookId}")
    public SingleResponse<BookLetter> saveBookLetter(@PathVariable long userId, @PathVariable long bookId,
                                                     @RequestParam String content){
        return responseService.getSingleResponse(bookLetterService.saveBookLetter(userId,bookId,content));
    }

    //책별 글귀목록 조회(본인이 저장한것만)
    @GetMapping(value = "/{userId}/bookletters/{bookId}")
    public ListResponse<BookLetter> getBookLettersByBook(@PathVariable long userId,@PathVariable long bookId){
        return responseService.getListResponse(bookLetterService.getBookLettersByBook(userId,bookId));
    }

    //사용자별 글귀목록 전체조회
    @GetMapping(value = "/{userId}/bookletters")
    public ListResponse<BookLetter> getBookLettersByUser(@PathVariable long userId){
        return responseService.getListResponse(bookLetterService.getBookLettersByUser(userId));
    }

    //글귀 수정
    @PatchMapping(value = "/bookletter/{bookLetterId}")
    public SingleResponse<BookLetter> modifyBookLetter(@PathVariable long bookLetterId,String content){
        return responseService.getSingleResponse(bookLetterService.modifyBookLetter(bookLetterId,content));
    }

    //글귀 삭제
    @DeleteMapping(value = "/bookletter/{bookLetterId}")
    public CommonResponse deleteBookLetter(@PathVariable long bookLetterId){
        bookLetterService.deleteBookLetter(bookLetterId);
        return responseService.getSuccessResponse();
    }
}
