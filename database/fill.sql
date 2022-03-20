USE 'qualleinc';

INSERT INTO user(name, lastname, phone)
values ('Андрей', 'Андреев', '+7456735456');
INSERT INTO user(name, lastname, phone)
values ('Дима', 'Димов', '+784679578');
INSERT INTO user(name, lastname, phone)
values ('Максим', 'Максимов', '+7123578965');
INSERT INTO user(name, lastname, phone)
values ('Лена', 'Ленова', '+77868345634');
INSERT INTO user(name, lastname, phone)
values ('Аня', 'Ааааа', '+7845256734');
INSERT INTO user(name, lastname, phone)
values ('Коля', 'Котлин', '+71457342345');
INSERT INTO user(name, lastname, phone)
values ('Света', 'Свет', '+7345634567');
INSERT INTO user(name, lastname, phone)
values ('Таня', 'Танина', '+72346236');
INSERT INTO user(name, lastname, phone)
values ('Егор', 'Егоров', '+7168956954');
INSERT INTO user(name, lastname, phone)
values ('Катя', 'Катева', '+7123465269');
INSERT INTO user(name, lastname, phone)
values ('Admin', 'Admin', '+71926784359');
INSERT INTO user(name, lastname, phone)
values ('user', 'user', '+123');

INSERT INTO credentials
values (1, 'A1n', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'USER');
INSERT INTO credentials
values (2, 'Dimmer', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'USER');
INSERT INTO credentials
values (3, 'Maximer', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'USER');
INSERT INTO credentials
values (4, 'Vova', '$2a$10$/SftPQLuet74uEXbzap17e3JJyt6wO8RTzulmY71U8GlURTnvqdwi', 'USER');
INSERT INTO credentials
values (5, 'Anna', '$2a$10$HgqfPiefsadzs8H5AxBvpeuu.gajP2nHuAORmyf4sPK3PB/EML/i6', 'USER');
INSERT INTO credentials
values (6, 'Kola', '$2a$10$wGrKQj/d6zpi1q5XWyPByeGgVLUd4zhBzI.2Y9oWkBdFGzgsTxGPC', 'USER');
INSERT INTO credentials
values (7, 'Svet', '$2a$10$Q9VU53RuOuY772z0/uei2ODhWXq.rWGFCLCi5ysehAfCUrm1KjOnu', 'USER');
INSERT INTO credentials
values (8, 'Tanya', '$2a$10$o67Y3mfdnC//M/9CoSgBcOKjQrzL/LJ0M2IyrXyEPWqaD7vNEejzm', 'USER');
INSERT INTO credentials
values (9, 'Egor', '$2a$10$4hXHWtwzje2gXb8gCM772.Pd3DQX.bQLTX7fNL1Tmu2zXdbY4Q7VW', 'USER');
INSERT INTO credentials
values (10, 'Katya', '$2a$10$vjsSVPqs4Cu7im3JoxkVMu67to9xtADpSJuRzL5XnOpgqEQmP0SWC', 'USER');
INSERT INTO credentials
values (11, 'admin', '$2a$10$dt1Jmg.w/sgjVSo2u7Vks.CD6wOGe2PqX.vB9uVPfVswyIeS99/46', 'ADMIN');
INSERT INTO credentials
values (12, 'user', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe', 'USER');

INSERT INTO card(number, date, user_id)
values ('1203945239459324', '12/23', 1);
INSERT INTO card(number, date, user_id)
values ('2203945239459324', '1/23', 2);
INSERT INTO card(number, date, user_id)
values ('3203945239459324', '5/23', 3);
INSERT INTO card(number, date, user_id)
values ('4203945239459324', '8/23', 4);
INSERT INTO card(number, date, user_id)
values ('5203945239459324', '12/23', 5);
INSERT INTO card(number, date, user_id)
values ('6203945239459324', '4/23', 6);
INSERT INTO card(number, date, user_id)
values ('7203945239459324', '2/23', 7);
INSERT INTO card(number, date, user_id)
values ('8203945239459324', '1/23', 8);
INSERT INTO card(number, date, user_id)
values ('9203945239459324', '8/23', 9);
INSERT INTO card(number, date, user_id)
values ('1203945239459324', '9/23', 10);
INSERT INTO card(number, date, user_id)
values ('1203945239459324', '11/23', 11);
INSERT INTO card(number, date, user_id)
values ('1203945239459324', '7/23', 12);

INSERT INTO developer(title)
values ('Other');
INSERT INTO developer(title)
values ('Ubisoft');
INSERT INTO developer(title)
values ('RockStar Games');
INSERT INTO developer(title)
values ('CD Projekt Red');
INSERT INTO developer(title)
values ('DICE');
INSERT INTO developer(title)
values ('Wargaming');
INSERT INTO developer(title)
values ('EA');

INSERT INTO category(value)
values ('Other');
INSERT INTO category(value)
values ('Sport');
INSERT INTO category(value)
values ('Popular');
INSERT INTO category(value)
values ('Main');
INSERT INTO category(value)
values ('Mobile');
INSERT INTO category(value)
values ('RPG');
INSERT INTO category(value)
values ('Multiplayer');
INSERT INTO category(value)
values ('Singleplayer');
INSERT INTO category(value)
values ('Mobile');

INSERT INTO genre(value)
values ('Open World');
INSERT INTO genre(value)
values ('Survival');
INSERT INTO genre(value)
values ('Post-apocalyptic');
INSERT INTO genre(value)
values ('Atmospheric');
INSERT INTO genre(value)
values ('Survival Horror');
INSERT INTO genre(value)
values ('Souls-like');
INSERT INTO genre(value)
values ('Relaxing');
INSERT INTO genre(value)
values ('Fantasy');
INSERT INTO genre(value)
values ('Atmospheric');
INSERT INTO genre(value)
values ('Walking Simulator');
INSERT INTO genre(value)
values ('Great Soundtrack');
INSERT INTO genre(value)
values ('Difficult');

INSERT INTO image(link)
values ('img/products/full/full-witcher.jpg');
INSERT INTO image(link)
values ('img/products/full/full-battlefront.jpg');
INSERT INTO image(link)
values ('img/products/full/full-origins.jpg');
INSERT INTO image(link)
values ('img/products/full/full-mk.jpg');
INSERT INTO image(link)
values ('img/products/logo/logo-cod.png');
INSERT INTO image(link)
values ('img/products/logo/logo-elder-scrolls.png');
INSERT INTO image(link)
values ('img/products/logo/logo-kill-strain.png');
INSERT INTO image(link)
values ('img/products/logo/logo-lol.png');
INSERT INTO image(link)
values ('img/products/logo/logo-quantum-break.png');
INSERT INTO image(link)
values ('img/products/sport/sport-fifa12.png');
INSERT INTO image(link)
values ('img/products/sport/sport-fifa13.png');
INSERT INTO image(link)
values ('img/products/sport/sport-fifa14.png');
INSERT INTO image(link)
values ('img/products/sport/sport-fifa-street.png');
INSERT INTO image(link)
values ('img/products/sport/sport-uefa-euro.png');
INSERT INTO image(link)
values ('img/products/sport/sport-nhl14.png');
INSERT INTO image(link)
values ('img/products/mobile/mobile-3.png');
INSERT INTO image(link)
values ('img/products/mobile/mobile-1.png');
INSERT INTO image(link)
values ('img/products/mobile/mobile-2.png');
INSERT INTO image(link)
values ('img/products/mobile/mobile-4.png');
INSERT INTO image(link)
values ('img/products/mobile/mobile-5.png');
INSERT INTO image(link)
values ('img/products/mobile/mobile-6.png');
INSERT INTO image(link)
values ('img/products/others/product.jpg');

INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Witcher 3', 12.00, '', 'GAME', 4, 4, 4, 1);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Battlefront 2', 23.00, '', 'GAME', 5, 4, 2, 2);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Assassins Creed Origins', 34.00, '', 'GAME', 2, 4, 8, 3);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Mortal Kombat', 27.00, '', 'GAME', 1, 4, 9, 4);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Call of Duty Black Ops', 45.00, '', 'GAME', 7, 3, 1, 5);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('The Elder Scrolls Online', 19.00, '', 'GAME', 1, 3, 2, 6);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Kill Strain', 13.00, '', 'GAME', 1, 3, 10, 7);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('League of Legends', 0, '', 'GAME', 1, 3, 3, 8);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Quantum Break', 8.00, '', 'GAME', 7, 3, 6, 9);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Fifa 12', 25.00, '', 'GAME', 2, 2, 5, 10);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Fifa 13', 30.00, '', 'GAME', 2, 2, 3, 11);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Fifa 14', 35.00, '', 'GAME', 2, 2, 1, 12);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Fifa Street', 32.00, '', 'GAME', 2, 2, 2, 13);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Euro 2012', 26.00, '', 'GAME', 1, 2, 4, 14);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('NHL 14', 31.00, '', 'GAME', 2, 2, 8, 15);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Injustice 2', 0.00, '', 'GAME', 4, 5, 11, 16);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Heroes of Dragon Age', 0.00, '', 'GAME', 1, 5, 6, 17);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Mortal Kombat X', 0.00, '', 'GAME', 1, 5, 12, 18);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('WWE Immortals', 0.00, '', 'GAME', 1, 5, 5, 19);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Star Wars: Galaxy of Heroes', 0.00, '', 'GAME', 2, 5, 7, 20);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Injustice: Gods Among Us', 3.00, '', 'GAME', 1, 5, 4, 21);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 1', 10.00, '', 'GAME', 1, 1, 8, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 2', 10.00, '', 'GAME', 1, 1, 3, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 3', 10.00, '', 'GAME', 1, 1, 1, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 4', 10.00, '', 'GAME', 1, 1, 11, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 5', 10.00, '', 'GAME', 1, 1, 12, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 6', 10.00, '', 'GAME', 1, 1, 5, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 7', 10.00, '', 'GAME', 1, 1, 2, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 8', 10.00, '', 'GAME', 1, 1, 8, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 9', 10.00, '', 'GAME', 1, 1, 12, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 10', 10.00, '', 'GAME', 1, 1, 5, 22);
INSERT INTO product(title, price, description, type, developer_id, category_id, genre_id, image_id)
values ('Игра 11', 10.00, '', 'GAME', 1, 1, 9, 22);

INSERT INTO purchase(product_id, user_id, card_id)
values (1, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (1, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (1, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (1, 8, 8);
INSERT INTO purchase(product_id, user_id, card_id)
values (1, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (1, 2, 2);
INSERT INTO purchase(product_id, user_id, card_id)
values (2, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (2, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (2, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (3, 8, 8);
INSERT INTO purchase(product_id, user_id, card_id)
values (3, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (3, 2, 2);
INSERT INTO purchase(product_id, user_id, card_id)
values (4, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (4, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (5, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (7, 8, 8);
INSERT INTO purchase(product_id, user_id, card_id)
values (7, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (7, 2, 2);
INSERT INTO purchase(product_id, user_id, card_id)
values (7, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (7, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (7, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (8, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (8, 2, 2);
INSERT INTO purchase(product_id, user_id, card_id)
values (8, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (8, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (8, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (9, 8, 8);
INSERT INTO purchase(product_id, user_id, card_id)
values (9, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (10, 2, 2);
INSERT INTO purchase(product_id, user_id, card_id)
values (10, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (10, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (10, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (10, 8, 8);
INSERT INTO purchase(product_id, user_id, card_id)
values (11, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (11, 2, 2);
INSERT INTO purchase(product_id, user_id, card_id)
values (12, 1, 1);
INSERT INTO purchase(product_id, user_id, card_id)
values (12, 4, 4);
INSERT INTO purchase(product_id, user_id, card_id)
values (12, 6, 6);
INSERT INTO purchase(product_id, user_id, card_id)
values (12, 8, 8);
INSERT INTO purchase(product_id, user_id, card_id)
values (12, 12, 12);
INSERT INTO purchase(product_id, user_id, card_id)
values (12, 2, 2);


