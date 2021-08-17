package minji.sharinglibraryserver.user;

import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;    //pk
    @Column
    private String userEmail;   //이메일
    @Column
    private String userPassword;    //비밀번호
    @Column
    private String userName;    //이름
    @Column
    private String userNickName;    //닉네임
}
