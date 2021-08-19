package minji.sharinglibraryserver.book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping(value="/book/{userId}")
    public Book saveBook(@PathVariable long userId, @ModelAttribute KAKAOBookSearchDto kakaoBookSearchDto){
        return bookService.saveBook(userId,kakaoBookSearchDto);
    }

    @GetMapping(value = "/books/{userId}")
    public List<Book> getBookList(@PathVariable long userId){
        return bookService.getBooksByUser(userId);
    }
}
