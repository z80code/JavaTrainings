drop table if exists logins;

create table logins(
     idLogin int auto_increment primary key,
     name VARCHAR(255)
);

create table tests(
     idTest int auto_increment primary key,
     name VARCHAR(255)
);

create table results(
     loginId int NOT NULL,
     testId int NOT NULL,
     dat date,
     mark int,
     FOREIGN KEY(loginId) REFERENCES logins(idLogin) ON UPDATE CASCADE,
     FOREIGN KEY(testId) REFERENCES tests(idTest) ON UPDATE CASCADE
);

