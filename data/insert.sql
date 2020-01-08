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

INSERT INTO qualle.developer(title) values('Другое');
INSERT INTO qualle.category(title) values('Спорт');
INSERT INTO qualle.category(title) values('Шутеры');
INSERT INTO qualle.category(title) values('RPG');
INSERT INTO qualle.category(title) values('Мобильные игры');
INSERT INTO qualle.category(title) values('Аниме');

INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Witcher 3', 12.00, '', 4, 4);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Battlefront 2', 23.00, '', 5, 3);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Assassins Creed Origins', 34.00, '', 2, 4);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Mortal Kombat', 27.00, '', 1, 1);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Call of Duty Black Ops', 45.00, '', 8, 3);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('The Elder Scrolls Online', 19.00, '', 1, 4);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Kill Strain', 13.00, '', 1, 1);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('League of Legends', 0, '', 1, 4);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Quantum Break', 8.00, '', 8, 3);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Fifa 12', 25.00, '', 2, 2);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Fifa 13', 30.00, '', 2, 2);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Fifa 14', 35.00, '', 2, 2);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Fifa Street', 32.00, '', 2, 2);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Euro 2012', 26.00, '', 1, 2);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('NHL 14', 31.00, '', 2, 2);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Injustice 2', 0.00, '', 4, 5);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Heroes of Dragon Age', 0.00, '', 1, 5);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Mortal Kombat X', 0.00, '', 1, 5);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('WWE Immortals', 0.00, '', 1, 5);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Star Wars: Galaxy of Heroes', 0.00, '', 2, 5);
INSERT INTO qualle.game(title, price, description, developer_id, category_id) values('Injustice: Gods Among Us', 3.00, '', 1, 5);




