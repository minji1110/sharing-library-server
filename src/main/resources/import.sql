INSERT INTO user(created_date,user_id, user_email, user_password, user_name, user_nick_name) VALUES(now(),1, 'test@gmail.com','password','kim','nick');

INSERT INTO book(created_date,book_id, book_isbn,book_title,book_author,book_summary,book_image_url,user_id) VALUES (now(),1,111,'책제목1','지은이1','책 줄거리1','https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5551149%3Ftimestamp%3D20220909223606',1);
INSERT INTO book(created_date,book_id, book_isbn,book_title,book_author,book_summary,book_image_url,user_id) VALUES (now(),2,222,'책제목2','지은이2','책 줄거리2','https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5551149%3Ftimestamp%3D20220909223606',1);
INSERT INTO book(created_date,book_id, book_isbn,book_title,book_author,book_summary,book_image_url,user_id) VALUES (now(),3,333,'책제목3','지은이3','책 줄거리3','https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5551149%3Ftimestamp%3D20220909223606',1);
INSERT INTO book(created_date,book_id, book_isbn,book_title,book_author,book_summary,book_image_url,user_id) VALUES (now(),4,444,'책제목4','지은이4','책 줄거리4','https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5551149%3Ftimestamp%3D20220909223606',1);
INSERT INTO book(created_date,book_id, book_isbn,book_title,book_author,book_summary,book_image_url,user_id) VALUES (now(),5,555,'책제목5','지은이5','책 줄거리5','https://search1.kakaocdn.net/thumb/R120x174.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Flbook%2Fimage%2F5551149%3Ftimestamp%3D20220909223606',1);

INSERT INTO book_letter(created_date,letter_id, letter_content, book_id, user_id) VALUES (now(),1,'글귀 1',1,1);
INSERT INTO book_letter(created_date,letter_id, letter_content, book_id, user_id) VALUES (now(),2,'글귀 2',2,1);
INSERT INTO book_letter(created_date,letter_id, letter_content, book_id, user_id) VALUES (now(),3,'글귀 3',3,1);
INSERT INTO book_letter(created_date,letter_id, letter_content, book_id, user_id) VALUES (now(),4,'글귀 4',4,1);
