package minji.sharinglibraryserver.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import minji.sharinglibraryserver.book_letter.BookLetter;
import minji.sharinglibraryserver.common.BaseTime;
import minji.sharinglibraryserver.user.User;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;               //pk

    private String bookIsbn;          //isbn

    private String bookTitle;         //제목

    private String bookAuthor;        //작가

    @Column(length = 1000)
    private String bookSummary;       //줄거리

    @ColumnDefault("-1")
    private int bookScore;            //평점

    private LocalDate bookStartDt;   //시작일시

    private LocalDate bookEndDt;     //종료일시

    private String bookImageUrl;     //책 이미지

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<BookLetter> bookLetterList=new ArrayList<>();  //fk - 글귀

    @JsonIgnore
    @JoinColumn(name = "userId",nullable = false)
    @ManyToOne(fetch = LAZY)
    private User user;    //fk - 등록자

    protected void addBookInfo(int score, LocalDate startDt, LocalDate endDt){
        this.bookScore=score;
        this.bookStartDt=startDt;
        this.bookEndDt=endDt;
    }
}

