package minji.sharinglibraryserver.book_letter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class BookLetter extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterId;

    @Column(length = 100)
    private String letterContent;

    @JoinColumn(name = "bookId")
    @ManyToOne(fetch = LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Book book;

    @JoinColumn(name="userId")
    @ManyToOne(fetch = LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    protected void updateLetterContent(String letterContent){
        this.letterContent=letterContent;
    }
}
