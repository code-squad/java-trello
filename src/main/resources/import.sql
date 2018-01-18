INSERT INTO user (user_id, name, password, email) values (1, 'hue', 'password', 'hue@korea.kr');
INSERT INTO user (user_id, name, password, email) values (2, 'java', 'password', 'java@korea.kr');

INSERT INTO board (board_id, name) values (1, 'first board');
INSERT INTO board (board_id, name) values (2, 'second board');

INSERT INTO board_list (user_id, board_id) values (1,1);
INSERT INTO board_list (user_id, board_id) values (1,2);

INSERT INTO deck (deck_id, name) values (1,'first deck');
INSERT INTO deck (deck_id, name) values (2,'second deck');
INSERT INTO deck (deck_id, name) values (3,'Hello world');
INSERT INTO deck (deck_id, name) values (4,'Java World!!');

INSERT INTO board_decks (board_board_id, decks_deck_id) values (1,1);
INSERT INTO board_decks (board_board_id, decks_deck_id) values (1,2);
INSERT INTO board_decks (board_board_id, decks_deck_id) values (1,3);
INSERT INTO board_decks (board_board_id, decks_deck_id) values (2,4);

INSERT INTO card (card_id, name) values (1, 'first card');
INSERT INTO card (card_id, name) values (2, 'hi!!!');
INSERT INTO card (card_id, name) values (3, 'hello world!!');
INSERT INTO card (card_id, name) values (4, 'It is dummy1');
INSERT INTO card (card_id, name) values (5, 'It is dummy2');
INSERT INTO card (card_id, name) values (6, 'It is dummy3');
INSERT INTO card (card_id, name) values (7, 'It is dummy4');
INSERT INTO card (card_id, name) values (8, 'It is dummy5');

INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (1,1);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (1,2);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (1,3);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (3,4);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (1,5);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (4,6);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (3,7);
INSERT INTO deck_cards (deck_deck_id, cards_card_id) values (2,8);
