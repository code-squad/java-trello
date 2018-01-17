INSERT INTO user (user_id, name, password, email) values (1, 'hue', 'password', 'hue@korea.kr');
INSERT INTO user (user_id, name, password, email) values (2, 'java', 'password', 'java@korea.kr');

INSERT INTO board (board_id, name) values (1, 'first board');
INSERT INTO board (board_id, name) values (2, 'second board');

INSERT INTO board_list (user_id, board_id) values (1,1);
INSERT INTO board_list (user_id, board_id) values (1,2);