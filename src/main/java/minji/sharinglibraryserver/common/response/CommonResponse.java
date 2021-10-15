package minji.sharinglibraryserver.common.response;

import lombok.Getter;

@Getter
class CommonResponse {
    boolean success;
    int code;
    String message;
}

