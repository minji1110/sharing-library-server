package minji.sharinglibraryserver.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import minji.sharinglibraryserver.book.Book;
import minji.sharinglibraryserver.common.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class User extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;    //pk

    private String userEmail;   //이메일

    private String userPassword;    //비밀번호

    private String userName;    //이름

    private String userNickName;    //닉네임

    @OneToMany(mappedBy = "user", fetch = LAZY)
    @JsonIgnore
    private List<Book> userBookList=new ArrayList<>();

    public void addBookList(Book book){
        userBookList.add(book);
    }
}
