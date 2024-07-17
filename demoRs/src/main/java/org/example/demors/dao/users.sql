create table users
(
    id       int primary key auto_increment not null,
    username varchar(128)                   not null,
    email    varchar(128)
);

insert into users (username, email) values ('tiranosaur', 'tiranosaur@mail.com');
insert into users (username, email) values ('fucker', null);

