 create table Movie
(id number(10),name varchar(25),price number(10),director_id number(10));
DESC MOVIE;

create table Director
(id number(10),name varchar(25),DateofBirth date);
DESC DIRECTOR;
create table Register
(email varchar(25),username varchar(25),password varchar(25),gender varchar(25),id number(10))

alter table movie  add foreign key(director_id) references director(id);
alter table director add primary key(id);
create sequence user_id_seq start with 1 INCREMENT by 1;
select * from movie;
select * from register;
select * from director;
delete register where id=24;
