package minji.sharinglibraryserver.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class BookLetter {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterId;

    @Column(length = 100)
    private String letterContent;

    @JsonIgnore
    @JoinColumn(name = "bookId")
    @ManyToOne(fetch = LAZY)
    private Book book;
}
