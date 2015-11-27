CREATE TABLE Posts (
              ID INT PRIMARY KEY auto_increment, 
              title VARCHAR(100),
              created TIMESTAMP,
              lastChanged TIMESTAMP,
              content CLOB,
              tags VARCHAR(255)
);

insert into posts(title, created, lastchanged, content, tags) values( 'tit2', '2015-11-16 18:49:10','2015-11-16 18:49:10', 'sdfsd', 't1 t2');

CREATE USER igor PASSWORD '123';
ALTER USER igor ADMIN TRUE;