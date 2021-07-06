CREATE TABLE USERS
(id int PRIMARY KEY AUTO_INCREMENT ,
 name varchar (100),
 email varchar(50) UNIQUE,
 cpf varchar(50) UNIQUE,
 birthdate date
 );

--INSERT INTO USERS (name, email, cpf, birthdate) VALUES ('Joao', 'joao@email', '79782572071', '2000-10-10');
--INSERT INTO USERS (name, email, cpf, birthdate) VALUES ('Maria', 'maria@email', '46556303020', '1995-10-10');

CREATE TABLE COMICS
(id int PRIMARY KEY AUTO_INCREMENT,
 comic_id int,
 title varchar(100),
 price double,
 author varchar(400),
 isbn varchar(100),
 description varchar(1000),
 price_with_discount double
 );

CREATE TABLE USERS_COMICS(
id int PRIMARY KEY AUTO_INCREMENT,
USERS_ID INT UNIQUE,
COMICS_ID INT,
CONSTRAINT fk_UCR_users1 FOREIGN KEY (users_id) REFERENCES USERS (id),
CONSTRAINT fk_UCR_comics1 FOREIGN KEY (comics_id) REFERENCES COMICS (id)
);


