package minji.sharinglibraryserver.user;

import lombok.RequiredArgsConstructor;
import minji.sharinglibraryserver.common.response.ResponseService;
import minji.sharinglibraryserver.common.response.SingleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final ResponseService responseService;
    private final UserService userService;

    @GetMapping(value = "/user/{userId}")
    public SingleResponse<User> getUserById(@PathVariable long userId) {
        SingleResponse<User> result = responseService.getSingleResponse(userService.getUserById(userId));
        return result;
    }
}
