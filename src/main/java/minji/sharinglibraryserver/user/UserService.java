package minji.sharinglibraryserver.user;

import lombok.RequiredArgsConstructor;
import minji.sharinglibraryserver.common.exception.InvalidateUserException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepo userJpaRepo;

    public User getUserById(long userId) {
        User user=userJpaRepo.findById(userId).orElseThrow(InvalidateUserException::new);
        return user;
    }
}
