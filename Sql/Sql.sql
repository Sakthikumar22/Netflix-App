 create table Movie
(id number(10),name varchar(25)not null unique,price float(10)not null,director_id number(10));
alter table movie drop column director_id;
alter table movie modify id number(10) primary key;
DESC MOVIE;
ALTER TABLE Register
MODIFY (  email not null) MODIFY(username not null) MODIFY(password not null)  MODIFY(gender not null);
create table Moviecast
(id number(10) primary key,cast_name varchar(30) not null,cast_role varchar(20) not null);

create table Director
(id number(10)primary key,name varchar(25) not null ,DateofBirth date);
DESC DIRECTOR;
create table Register
(email varchar(25)not null unique,username varchar(25)not null,password varchar(25)not null,gender varchar(10)not null,id number(10))

alter table movie  add foreign key(director_id) references director(id);
alter table director add primary key(id);
create sequence movie_id start with 1 INCREMENT  by 1 ;
create sequence director_id  start with 1 INCREMENT  by 1 ;
create sequence user_id_seq start with 1 INCREMENT  by 1 ;
select MOVIE.ID as movieid,movie.name as moviename,PRICE,DIRECTOR.NAME as 
directorname,DIRECTOR.DateofBirth as directordob FROM MOVIE,DIRECTOR
WHERE  DIRECTOR_ID= DIRECTOR.ID order by movieid asc;
select * from movie;
select * from register;
delete register where id=24;
