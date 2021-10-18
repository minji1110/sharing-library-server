package minji.sharinglibraryserver.common.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minji.sharinglibraryserver.common.response.CommonResponse;
import minji.sharinglibraryserver.common.response.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    private final ResponseService responseService;

    @ExceptionHandler(InvalidateUserException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private CommonResponse invalidateUserException(){
        log.info(Exception.INVALIDATE_USER.getMessage());
        return responseService.getErrorResponse(Exception.INVALIDATE_USER.getCode(), Exception.INVALIDATE_USER.getMessage());
    }

    @ExceptionHandler(InvalidateBookException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    private CommonResponse invalidateBookException(){
        log.info(Exception.INVALIDATE_BOOK.getMessage());
        return responseService.getErrorResponse(Exception.INVALIDATE_BOOK.getCode(), Exception.INVALIDATE_BOOK.getMessage());
    }
}
