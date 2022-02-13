package minji.sharinglibraryserver.book_letter;

import lombok.Builder;
import lombok.Getter;
import minji.sharinglibraryserver.book.Book;
import minji.sharinglibraryserver.common.BaseTime;
import minji.sharinglibraryserver.user.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
@Builder
public class BookLetter extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterId;

    @Column(length = 100)
    private String letterContent;

    @JoinColumn(name = "bookId")
    @ManyToOne(fetch = LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    @JoinColumn(name="userId")
    @ManyToOne(fetch = LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    protected void updateLetterContent(String letterContent){
        this.letterContent=letterContent;
    }
}