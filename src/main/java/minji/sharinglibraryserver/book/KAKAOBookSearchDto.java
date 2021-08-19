package minji.sharinglibraryserver.book;

import lombok.Data;

@Data
public class KAKAOBookSearchDto {
    String title;       //제목
    String authors;     //작가
    String isbn;        //isbn
    String contents;    //줄거리
    String datetime;    //발행일
    String publisher;   //출판사
    String thumbnail;   //표지 미리보기 url
    int price;          //정가
    int salePrice;      //판매가
    String status;      //판매,품절,절판
    String translators; //번역가
    String url;         //도서상세 url
}
