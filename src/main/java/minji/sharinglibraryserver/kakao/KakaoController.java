package minji.sharinglibraryserver.kakao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController
public class KakaoController {
    private static final String host="https://dapi.kakao.com";
    private static final String searchTitleUri="/v3/search/book?target=title&query=";
    private static final String apiKey="1345794fdd4b8c268cc7ff2b244e7dbf";  //fixme 비공개처리

    @GetMapping(value="/book/search")
    public KakaoBookResult searchBook(@RequestParam String title) throws URISyntaxException, JsonProcessingException {
        URI kakaoAPI=new URI(host+searchTitleUri+title);

        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("Authorization","KakaoAK "+apiKey);
        HttpEntity httpEntity=new HttpEntity(httpHeaders);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> result=restTemplate.exchange(
                kakaoAPI.toString(),
                HttpMethod.GET,
                httpEntity,
                String.class
        );

        ObjectMapper objectMapper=new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        KakaoBookResult kakaoBookResult =objectMapper.readValue(result.getBody(), KakaoBookResult.class);

        return kakaoBookResult;
    }
}
