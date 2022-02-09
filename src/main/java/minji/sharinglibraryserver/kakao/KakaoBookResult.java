package minji.sharinglibraryserver.kakao;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class KakaoBookResult {
    private List<KakaoBookDocument> documents=new ArrayList<>();
    private KakaoBookMeta meta;
}


