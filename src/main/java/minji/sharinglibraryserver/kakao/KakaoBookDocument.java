package minji.sharinglibraryserver.kakao;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class KakaoBookDocument {
    String title;       //제목
    private List<String> authors=new ArrayList<>();     //작가
    List<String> translators=new ArrayList<>(); //번역가
    String isbn;        //isbn
    String contents;    //줄거리
    String datetime;    //발행일
    String publisher;   //출판사
    String thumbnail;   //표지 미리보기 url
    int price;          //정가
    int sale_price;      //판매가
    String status;      //판매,품절,절판
    String url;         //도서상세 url
}
