package minji.sharinglibraryserver.user;

import lombok.Getter;
import minji.sharinglibraryserver.book.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;    //pk

    private String userEmail;   //이메일

    private String userPassword;    //비밀번호

    private String userName;    //이름

    private String userNickName;    //닉네임

    @OneToMany(mappedBy = "user")
    private List<Book> userBookList=new ArrayList<>();

// 좋아요 표시한 책 목록 -> 나중에 생각(따로 엔티티를 만들어야?)
//    @OneToMany(mappedBy = "user")
//    private List<Book> userBookLikedList=new ArrayList<>();
}
