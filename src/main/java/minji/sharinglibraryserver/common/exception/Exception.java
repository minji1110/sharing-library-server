package minji.sharinglibraryserver.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exception {
    INVALIDATE_USER(1000,"해당하는 사용자가 존재하지 않습니다."),
    INVALIDATE_BOOK(1001,"해당하는 도서가 존재하지 않습니다."),
    INVALIDATE_BOOK_LETTER(1002,"해당하는 글귀가 존재하지 않습니다.");

    private final int code;
    private final String message;
}
