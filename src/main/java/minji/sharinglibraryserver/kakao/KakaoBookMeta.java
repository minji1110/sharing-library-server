package minji.sharinglibraryserver.kakao;

import lombok.Data;

@Data
public class KakaoBookMeta {
    int total_count;
    int pageable_count;
    boolean is_end;
}
