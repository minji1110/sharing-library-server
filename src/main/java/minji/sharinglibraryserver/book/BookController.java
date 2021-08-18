package minji.sharinglibraryserver.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private static final String KAKAO_HOST ="https://dapi.kakao.com";
    private static final String KAKAO_SEARCH_URI="/v3/search/book?target=title";

//    @GetMapping("/book")
//    public ResponseEntity searchBook(String searchVal){
//        RestTemplate restTemplate=new RestTemplate();
//        HttpHeaders httpHeaders=new HttpHeaders();

//        httpHeaders.add()
//        return
//    }

    @GetMapping(value = "/books/{userId}")
    public List<Book> getBookList(@PathVariable long userId){
        return bookService.getBooksByUser(userId);
    }
}
