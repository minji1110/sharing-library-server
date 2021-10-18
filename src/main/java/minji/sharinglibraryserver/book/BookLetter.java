package minji.sharinglibraryserver.book;

import lombok.Getter;
import minji.sharinglibraryserver.common.BaseTime;
import minji.sharinglibraryserver.user.User;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class BookLetter extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterId;

    @Column(length = 100)
    private String letterContent;

    @JoinColumn(name = "bookId")
    @ManyToOne(fetch = LAZY)
    private Book book;

    @JoinColumn(name="userId")
    @ManyToOne(fetch = LAZY)
    private User user;
}
