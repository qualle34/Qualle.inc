INSERT INTO qualle.user(name, lastname, phone) values('Андрей', 'Андреев', '+7456735456');
INSERT INTO qualle.user(name, lastname, phone) values('Дима', 'Димов', '+784679578');
INSERT INTO qualle.user(name, lastname, phone) values('Максим', 'Максимов', '+7123578965');
INSERT INTO qualle.user(name, lastname, phone) values('Лена', 'Ленова', '+77868345634');
INSERT INTO qualle.user(name, lastname, phone) values('Аня', 'Ааааа', '+7845256734');
INSERT INTO qualle.user(name, lastname, phone) values('Коля', 'Котлин', '+71457342345');
INSERT INTO qualle.user(name, lastname, phone) values('Света', 'Свет', '+7345634567');
INSERT INTO qualle.user(name, lastname, phone) values('Таня', 'Танина', '+72346236');
INSERT INTO qualle.user(name, lastname, phone) values('Егор', 'Егоров', '+7168956954');
INSERT INTO qualle.user(name, lastname, phone) values('Катя', 'Катева', '+7123465269');
INSERT INTO qualle.user(name, lastname, phone) values('Admin', 'Admin', '+71926784359');
INSERT INTO qualle.user(name, lastname, phone) values('user', 'user', '+123');

INSERT INTO qualle.cart values(1);
INSERT INTO qualle.cart values(2);
INSERT INTO qualle.cart values(3);
INSERT INTO qualle.cart values(4);
INSERT INTO qualle.cart values(5);
INSERT INTO qualle.cart values(6);
INSERT INTO qualle.cart values(7);
INSERT INTO qualle.cart values(8);
INSERT INTO qualle.cart values(9);
INSERT INTO qualle.cart values(10);
INSERT INTO qualle.cart values(11);
INSERT INTO qualle.cart values(12);

INSERT INTO qualle.creds values(1, 'A1n', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'USER');
INSERT INTO qualle.creds values(2, 'Dimmer', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'USER');
INSERT INTO qualle.creds values(3, 'Maximer', '$2a$10$ge8V9B.RtVvf8/2SlGLemui1ohaz93UGiepzPCGiGZVnm/hnCSkxm', 'USER');
INSERT INTO qualle.creds values(4, 'Vova', '$2a$10$/SftPQLuet74uEXbzap17e3JJyt6wO8RTzulmY71U8GlURTnvqdwi', 'USER');     
INSERT INTO qualle.creds values(5, 'Anna', '$2a$10$HgqfPiefsadzs8H5AxBvpeuu.gajP2nHuAORmyf4sPK3PB/EML/i6', 'USER');         
INSERT INTO qualle.creds values(6, 'Kola', '$2a$10$wGrKQj/d6zpi1q5XWyPByeGgVLUd4zhBzI.2Y9oWkBdFGzgsTxGPC', 'USER');            
INSERT INTO qualle.creds values(7, 'Svet', '$2a$10$Q9VU53RuOuY772z0/uei2ODhWXq.rWGFCLCi5ysehAfCUrm1KjOnu', 'USER');            
INSERT INTO qualle.creds values(8, 'Tanya', '$2a$10$o67Y3mfdnC//M/9CoSgBcOKjQrzL/LJ0M2IyrXyEPWqaD7vNEejzm', 'USER');       
INSERT INTO qualle.creds values(9, 'Egor', '$2a$10$4hXHWtwzje2gXb8gCM772.Pd3DQX.bQLTX7fNL1Tmu2zXdbY4Q7VW', 'USER');         
INSERT INTO qualle.creds values(10, 'Katya', '$2a$10$vjsSVPqs4Cu7im3JoxkVMu67to9xtADpSJuRzL5XnOpgqEQmP0SWC', 'USER');       
INSERT INTO qualle.creds values(11, 'admin', '$2a$10$dt1Jmg.w/sgjVSo2u7Vks.CD6wOGe2PqX.vB9uVPfVswyIeS99/46', 'ADMIN');
INSERT INTO qualle.creds values(12, 'user', '$2a$10$w9Xvn7V.w6XTMoCrLyPIX.X/gnSaSavaRhO2yVEFNwrlb4kqj4jhe', 'USER');

INSERT INTO qualle.developer(title) values('Other');
INSERT INTO qualle.developer(title) values('Ubisoft');
INSERT INTO qualle.developer(title) values('RockStar Games');
INSERT INTO qualle.developer(title) values('CD Projekt Red');
INSERT INTO qualle.developer(title) values('DICE');
INSERT INTO qualle.developer(title) values('Wargaming');
INSERT INTO qualle.developer(title) values('EA');

INSERT INTO qualle.category(title, title_ru) values('Other', 'Другое');
INSERT INTO qualle.category(title, title_ru) values('Sport', 'Спорт');
INSERT INTO qualle.category(title, title_ru) values('Popular', 'Популярные');
INSERT INTO qualle.category(title, title_ru) values('Main', 'Основные');
INSERT INTO qualle.category(title, title_ru) values('Mobile', 'Мобильные игры');

INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Witcher 3', 12.00, '', 4, 4, 'img/games/full/full-witcher.jpg');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Battlefront 2', 23.00, '', 5, 4, 'img/games/full/full-battlefront.jpg');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Assassins Creed Origins', 34.00, '', 2, 4, 'img/games/full/full-origins.jpg');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Mortal Kombat', 27.00, '', 1, 4, 'img/games/full/full-mk.jpg');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Call of Duty Black Ops', 45.00, '', 7, 3, 'img/games/logo/logo-cod.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('The Elder Scrolls Online', 19.00, '', 1, 3, 'img/games/logo/logo-elder-scrolls.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Kill Strain', 13.00, '', 1, 3, 'img/games/logo/logo-kill-strain.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('League of Legends', 0, '', 1, 3, 'img/games/logo/logo-lol.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Quantum Break', 8.00, '', 7, 3, 'img/games/logo/logo-quantum-break.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Fifa 12', 25.00, '', 2, 2, 'img/games/sport/sport-fifa12.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Fifa 13', 30.00, '', 2, 2, 'img/games/sport/sport-fifa13.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Fifa 14', 35.00, '', 2, 2, 'img/games/sport/sport-fifa14.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Fifa Street', 32.00, '', 2, 2, 'img/games/sport/sport-fifa-street.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Euro 2012', 26.00, '', 1, 2, 'img/games/sport/sport-uefa-euro.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('NHL 14', 31.00, '', 2, 2, 'img/games/sport/sport-nhl14.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Injustice 2', 0.00, '', 4, 5, 'img/games/mobile/mobile-3.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Heroes of Dragon Age', 0.00, '', 1, 5, 'img/games/mobile/mobile-1.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Mortal Kombat X', 0.00, '', 1, 5, 'img/games/mobile/mobile-2.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('WWE Immortals', 0.00, '', 1, 5, 'img/games/mobile/mobile-4.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Star Wars: Galaxy of Heroes', 0.00, '', 2, 5, 'img/games/mobile/mobile-5.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Injustice: Gods Among Us', 3.00, '', 1, 5, 'img/games/mobile/mobile-6.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 1', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 2', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 3', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 4', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 5', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 6', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 7', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 8', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 9', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 10', 10.00, '', 1, 1, 'img/games/others/game.png');
INSERT INTO qualle.game(name, price, description, developer_id, category_id, img_link) values('Игра 11', 10.00, '', 1, 1, 'img/games/others/game.png');

INSERT INTO qualle.user_game values(1, 1);
INSERT INTO qualle.user_game values(1, 4);
INSERT INTO qualle.user_game values(1, 6);
INSERT INTO qualle.user_game values(1, 8);
INSERT INTO qualle.user_game values(1, 12);
INSERT INTO qualle.user_game values(1, 2);

INSERT INTO qualle.user_game values(2, 1);
INSERT INTO qualle.user_game values(2, 4);
INSERT INTO qualle.user_game values(2, 6);

INSERT INTO qualle.user_game values(3, 8);
INSERT INTO qualle.user_game values(3, 12);
INSERT INTO qualle.user_game values(3, 2);

INSERT INTO qualle.user_game values(4, 1);
INSERT INTO qualle.user_game values(4, 4);

INSERT INTO qualle.user_game values(5, 6);

INSERT INTO qualle.user_game values(7, 8);
INSERT INTO qualle.user_game values(7, 12);
INSERT INTO qualle.user_game values(7, 2);
INSERT INTO qualle.user_game values(7, 1);
INSERT INTO qualle.user_game values(7, 4);
INSERT INTO qualle.user_game values(7, 6);

INSERT INTO qualle.user_game values(8, 12);
INSERT INTO qualle.user_game values(8, 2);
INSERT INTO qualle.user_game values(8, 1);
INSERT INTO qualle.user_game values(8, 4);
INSERT INTO qualle.user_game values(8, 6);

INSERT INTO qualle.user_game values(9, 8);
INSERT INTO qualle.user_game values(9, 12);

INSERT INTO qualle.user_game values(10, 2);
INSERT INTO qualle.user_game values(10, 1);
INSERT INTO qualle.user_game values(10, 4);
INSERT INTO qualle.user_game values(10, 6);
INSERT INTO qualle.user_game values(10, 8);

INSERT INTO qualle.user_game values(11, 12);
INSERT INTO qualle.user_game values(11, 2);

INSERT INTO qualle.user_game values(12, 1);
INSERT INTO qualle.user_game values(12, 4);
INSERT INTO qualle.user_game values(12, 6);
INSERT INTO qualle.user_game values(12, 8);
INSERT INTO qualle.user_game values(12, 12);
INSERT INTO qualle.user_game values(12, 2);

INSERT INTO qualle.cart_game values(1, 3);

INSERT INTO qualle.cart_game values(2, 10);

INSERT INTO qualle.cart_game values(4, 3);
INSERT INTO qualle.cart_game values(4, 8);

INSERT INTO qualle.cart_game values(5, 7);

INSERT INTO qualle.cart_game values(6, 7);
INSERT INTO qualle.cart_game values(6, 11);

INSERT INTO qualle.user_game values(10, 3);
INSERT INTO qualle.user_game values(10, 11);

INSERT INTO qualle.user_game values(12, 3);
INSERT INTO qualle.user_game values(12, 7);
