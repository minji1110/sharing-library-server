package minji.sharinglibraryserver.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import minji.sharinglibraryserver.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;    //pk

    private long bookIsbn;  //isbn

    private String bookTitle;   //제목

    private String bookAuthor;  //작가

    private String bookSummary; //줄거리

    private int bookScore;  //평점

    private LocalDate bookStartDt;   //시작일시

    private LocalDate bookEndDt;     //종료일시

    @OneToMany(mappedBy = "book")
    private List<BookLetter> bookLetterList=new ArrayList<>();  //fk - 글귀

    @JsonIgnore
    @JoinColumn(name = "userId")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;    //fk - 등록자
}
