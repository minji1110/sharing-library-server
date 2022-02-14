package minji.sharinglibraryserver.kakao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@Slf4j
@RestController
public class KakaoController {
    @Value("${kakao.host}") private String host;
    @Value("${kakao.search_book_path}") private String searchBookPath;
    @Value("${kakao.api_key}") private String apiKey;

    @GetMapping(value="/book/search")
    public KakaoBookResult searchBook(@RequestParam String title) throws JsonProcessingException {
        URI kakaoAPI = UriComponentsBuilder
                .fromUriString(host)
                .path(searchBookPath)
                .queryParam("target","title")
                .queryParam("query",title)
                .build()
                .toUri();
        System.out.println("kakaoAPI = " + kakaoAPI);

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
